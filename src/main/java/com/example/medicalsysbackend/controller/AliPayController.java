package com.example.medicalsysbackend.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.example.medicalsysbackend.config.AlipayConfig;
import com.example.medicalsysbackend.domain.*;
import com.example.medicalsysbackend.service.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.print.Doc;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/pay")
public class AliPayController {
    @Resource
    MedicineService medicineService;
    @Resource
    ConsultationPriceService consultationPriceService;
    @Resource
    DoctorInfoService doctorInfoService;
    @Resource
    PrescriptionService prescriptionService;
    @Resource
    PrescribepriceService prescribepriceService;

    Medicine medicine;
    DoctorInfo doctorInfo;
    Prescription prescription;
    int quantity;
    String u;
    int user_id;
    int prescription_id = 0;


    @RequestMapping(value = "/toAliPay")
    public String  toPay(Medicine md, String url,int q,int uid) throws Exception{
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        String out_trade_no = UUID.randomUUID().toString();
        try {
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                    + "\"total_amount\":\""+ md.getUnitPrice() * q +"\","
                    + "\"subject\":\""+ md.getMedicineName()+"药品交易支付" +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
            String result;
            result = alipayClient.pageExecute(alipayRequest).getBody();
            System.out.println("*********************\n返回结果为："+result);
            medicine=md;
            quantity=q;
            u=url;
            user_id=uid;
            System.out.println(u);
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/toAliPay2")
    public String  toPay2(DoctorInfo di, String url, int uid) throws Exception{
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        String out_trade_no = UUID.randomUUID().toString();
        ConsultationPrice consultationPrice = consultationPriceService.selectConsultationPriceByPosition(di.getPosition());
        System.out.println(consultationPrice+"----------------1111111");
        try {
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                    + "\"total_amount\":\""+ consultationPrice.getPrice() +"\","
                    + "\"subject\":\""+ di.getDoctorName()+"医生问诊交易支付" +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
            String result;
            result = alipayClient.pageExecute(alipayRequest).getBody();
            System.out.println("*********************\n返回结果为："+result);
            doctorInfo=di;
            u=url;
            user_id=uid;
            System.out.println(u);
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/toAliPay3")
    public String  toPay3(String url, int id){
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        String out_trade_no = UUID.randomUUID().toString();
        Prescribeprice prescribeprice = prescribepriceService.selectPrescribepriceByPrescribeId(id);
        System.out.println(prescribeprice+"----------------1111111");
        try {
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                    + "\"total_amount\":\""+ prescribeprice.getPrices() +"\","
                    + "\"subject\":\""+ "处方交易支付" +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
            String result;
            result = alipayClient.pageExecute(alipayRequest).getBody();
            System.out.println("*********************\n返回结果为："+result);
            u=url;
            prescription_id=id;
            System.out.println(u);
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/return_sult")
    public void toResult(HttpServletResponse response) throws Exception {
        System.out.println("111:"+u);
        int result=0;
        if (medicine != null){
            System.out.println("这是购买药品的方法");
            result=medicineService.charge(medicine,quantity,user_id);
        }else if (doctorInfo != null){
            System.out.println("这是预约的方法");
            result = doctorInfoService.charge(doctorInfo,user_id);
        }else if (prescription_id > 0){
            System.out.println("这是处方支付的方法");
            result = prescriptionService.charge(prescription_id);
        }

        response.sendRedirect(u);
    }

//    private static final String filePath = "/img/";
//    @RequestMapping("qrpay")
//    public ResponseResult payQR(String house_id, String parking_id, double fee, String type,int m){
//        // 设置下载的响应头信息
//        String userDir=System.getProperties().getProperty("user.dir");
//        QrcodeUtil qrcodeUtil1=new QrcodeUtil();
//        qrcodeUtil1.setWidth(300);
//        qrcodeUtil1.setHeight(300);
//        qrcodeUtil1.setFormat("png");
//        qrcodeUtil1.setContent("http://47.98.213.9:8039/api/v2/form/payForm?house_id="+ house_id+"&parking_id="+parking_id
//                +"&m="+m+"&fee="+fee+"&type="+type);
//
//        String fileName=userDir+filePath+parking_id+".png";
//        File uploadFile = new File(fileName);
//        // 当父级目录不存在时，自动创建
//        if (!uploadFile.getParentFile().exists()) {
//            uploadFile.getParentFile().mkdirs();
//        }
//        int result=qrcodeUtil1.qrcode(userDir+filePath+parking_id+".png");
//        if(result>=1) {
//            System.out.println("二维码生成成功");
//            return  new ResponseResult(0,"success",parking_id+".png");
//        }else {
//            System.out.println("二维码生成失败");
//            return  new ResponseResult(-1,"fail",null);
//        }
//    }
}