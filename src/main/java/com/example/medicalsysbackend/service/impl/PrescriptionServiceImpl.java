package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.*;
import com.example.medicalsysbackend.mapper.PrescribepriceMapper;
import com.example.medicalsysbackend.mapper.PrescriptionMapper;
import com.example.medicalsysbackend.mapper.UserMapper;
import com.example.medicalsysbackend.service.HealthCardService;
import com.example.medicalsysbackend.service.MedicineService;
import com.example.medicalsysbackend.service.PrescriptionService;
import com.example.medicalsysbackend.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
* @author Cool
* @description 针对表【prescription】的数据库操作Service实现
* @createDate 2024-04-22 22:00:29
*/
@Service
public class PrescriptionServiceImpl extends ServiceImpl<PrescriptionMapper, Prescription>
    implements PrescriptionService{
    @Resource
    PrescriptionMapper prescriptionMapper;
    @Resource
    HealthCardService healthCardService;
    @Resource
    PrescribepriceMapper prescribepriceMapper;
    @Resource
    MedicineService medicineService;
    @Resource
    UserMapper userMapper;

    @Override
    public List<Prescription> selectAllPrescription() {
        return prescriptionMapper.selectAllPrescription();
    }

    @Override
    public List<Prescription> selectPrescriptionByUserId(int userId) {
        return prescriptionMapper.selectPrescriptionByUserId(userId);
    }

    @Override
    public Prescription selectOnlyOnePrescriptionByUserId(int userId) {
        return prescriptionMapper.selectOnlyOnePrescriptionByUserId(userId);
    }

    @Override
    public Prescription selectPrescriptionById(int id) {
        return prescriptionMapper.selectPrescriptionById(id);
    }

    @Override
    public int insertPrescription(Prescription prescription) throws ParseException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter fullDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(fullDate);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
        prescription.setCreateTime(d);
        if (prescription.getStatus() == null)prescription.setStatus("未受理");

        String[] medicines = prescription.getMedicationGuide().split("；");
        double sum = 0;
        for (String s : medicines){
            String[] m = s.split("x");
            System.out.println(m[0]+"--------");
            Medicine medicine = medicineService.selectMedicineByName(m[0]);
            if (medicine != null){
               sum += medicine.getUnitPrice() * Integer.parseInt(m[1]);
                System.out.println(sum+"--------2");
            }
        }
        Prescribeprice prescribeprice = new Prescribeprice();
        prescribeprice.setPrices(sum);
        int result = prescriptionMapper.insertPrescription(prescription);
        Prescription prescription1 = prescriptionMapper.selectOnlyOnePrescriptionByUserId(prescription.getUserId());
        prescribeprice.setPrescribeId(prescription1.getId());
        prescribepriceMapper.insertPrescribeprice(prescribeprice);
        return result;
    }

    @Override
    public int insertDocPrescription(Prescription prescription) throws ParseException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter fullDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(fullDate);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
        prescription.setCreateTime(d);
        if (prescription.getStatus() == null)prescription.setStatus("已受理");

        String[] medicines = prescription.getMedicationGuide().split("；");
        double sum = 0;
        for (String s : medicines){
            String[] m = s.split("x");
            System.out.println(m[0]+"--------");
            Medicine medicine = medicineService.selectMedicineByName(m[0]);
            if (medicine != null){
                sum += medicine.getUnitPrice() * Integer.parseInt(m[1]);
                System.out.println(sum+"--------2");
            }
        }
        Prescribeprice prescribeprice = new Prescribeprice();
        prescribeprice.setPrices(sum);
        int result = prescriptionMapper.insertPrescription(prescription);
        Prescription prescription1 = prescriptionMapper.selectOnlyOnePrescriptionByUserId(prescription.getUserId());
        prescribeprice.setPrescribeId(prescription1.getId());
        prescribepriceMapper.insertPrescribeprice(prescribeprice);
        return result;
    }

    @Override
    public int updatePrescription(Prescription prescription) {
        return prescriptionMapper.updatePrescription(prescription);
    }

    @Override
    public int authorize(int id) {
        return prescriptionMapper.authorize(id);
    }

    @Override
    public int unAuthorize(int id,int userid) {
        Prescription prescription = prescriptionMapper.selectPrescriptionById(id);
        HealthCard healthCard = healthCardService.selectHealthCardByUserId(prescription.getUserId());
        Prescribeprice prescribeprice = prescribepriceMapper.selectPrescribepriceByPrescribeId(id);
        System.out.println(healthCard + "-------111111-----" + prescribeprice);
        System.out.println(healthCard.getCardPrices()+"----------"+prescribeprice.getPrices());
        healthCard.setCardPrices(healthCard.getCardPrices() + prescribeprice.getPrices());
        int i = healthCardService.updateHealthCard(healthCard);
        String status = "";
        User user = userMapper.selectUserById(userid);
        if (user.getRole() == 2){
            status = "已拒绝";
        }else{
            status = "已取消";
        }
        return prescriptionMapper.unAuthorize(id,status);
    }

    @Override
    public int charge(int id) {
        String status = "已付款";
        return prescriptionMapper.unAuthorize(id,status);
    }

    @Override
    public int healCardCharge(int id) {
        Prescription prescription = prescriptionMapper.selectPrescriptionById(id);
        HealthCard healthCard = healthCardService.selectHealthCardByUserId(prescription.getUserId());
        Prescribeprice prescribeprice = prescribepriceMapper.selectPrescribepriceByPrescribeId(id);
        System.out.println(healthCard + "-------111111-----" + prescribeprice);
        System.out.println(healthCard.getCardPrices()+"----------"+prescribeprice.getPrices());
        if(healthCard.getCardPrices() < prescribeprice.getPrices() * 0.8) return -1;
        healthCard.setCardPrices(healthCard.getCardPrices() - prescribeprice.getPrices() * 0.8);
        int i = healthCardService.updateHealthCard(healthCard);
        String status = "已付款";
        return prescriptionMapper.unAuthorize(id,status);
    }
}




