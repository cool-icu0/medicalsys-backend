package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.DoctorInfo;
import com.example.medicalsysbackend.domain.Medicine;
import com.example.medicalsysbackend.service.DoctorInfoService;
import com.example.medicalsysbackend.service.FileService;
import com.example.medicalsysbackend.service.MedicineService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/file")
public class FileController {
    //private static final String filePath = "d:/img/";
    @Resource
    MedicineService medicineService;
    @Resource
    private FileService fileService;
    @Resource
    DoctorInfoService doctorInfoService;

//    @ApiOperation(value="添加药品信息，添加图片的方法")
//    @RequestMapping(value = "upload1",method = RequestMethod.POST)
//    public ResponseResult upload1(@RequestParam("head_img") MultipartFile file, Medicine medicine) {
//        // System.out.println("用户名："+user.getUser_name());
//        String userDir = System.getProperties().getProperty("user.dir")+"/img/";   //可以代替filePath
//        System.out.println("用户路径：" + userDir);
//        // 获取文件名
//        String fileName = file.getOriginalFilename();
//        System.out.println("上传的文件名为：" + fileName);
//
//        // 获取文件的后缀名,比如图片的jpeg,png
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        System.out.println("上传的后缀名为：" + suffixName);
//        File uploadFile = new File(userDir + fileName);
//        // 当父级目录不存在时，自动创建
//        if (!uploadFile.getParentFile().exists()) {
//            uploadFile.getParentFile().mkdirs();
//        }
//        // 文件上传后的路径
//        //fileName = UUID.randomUUID() + suffixName;
//        fileName = medicine.getImgUrl() + suffixName;
//        System.out.println("转换后的名称:"+fileName);
//        File dest = new File(userDir + fileName);
//        try {
//            file.transferTo(dest);
////            return new ResponseResult(0, "success to save",user.getUser_name());
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if(medicine.getMedicineId() == null){
//            return new ResponseResult(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMessage(),medicine);
//        }
//
//        int result = medicineService.insertMedicine(medicine);
//        if(result>=1)
//            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),medicine);
//        else
//            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage(),medicine);
//    }

//    @ApiOperation(value="修改药品信息，修改图片的方法")
//    @RequestMapping(value = "upload2",method = RequestMethod.POST)
//    public ResponseResult upload2(@RequestParam("head_img") MultipartFile file, Medicine medicine) {
//        // System.out.println("用户名："+user.getUser_name());
//        String userDir = System.getProperties().getProperty("user.dir")+"/img/";   //可以代替filePath
//        System.out.println("用户路径：" + userDir);
//        // 获取文件名
//        String fileName = file.getOriginalFilename();
//        System.out.println("上传的文件名为：" + fileName);
//
//        // 获取文件的后缀名,比如图片的jpeg,png
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        System.out.println("上传的后缀名为：" + suffixName);
//        File uploadFile = new File(userDir + fileName);
//        // 当父级目录不存在时，自动创建
//        if (!uploadFile.getParentFile().exists()) {
//            uploadFile.getParentFile().mkdirs();
//        }
//        // 文件上传后的路径
//        //fileName = UUID.randomUUID() + suffixName;
//        fileName = medicine.getImgUrl() + suffixName;
//        System.out.println("转换后的名称:"+fileName);
//        File dest = new File(userDir + fileName);
//        try {
//            file.transferTo(dest);
////            return new ResponseResult(0, "success to save",user.getUser_name());
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if(medicine.getMedicineId() == null){
//            return new ResponseResult(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMessage(),medicine);
//        }
//
//        int result = medicineService.updateMedicine(medicine);
//        if(result>=1)
//            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),medicine);
//        else
//            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage(),medicine);
//    }

//    @ApiOperation(value="添加医生信息，添加图片的方法")
//    @RequestMapping(value = "upload3",method = RequestMethod.POST)
//    public ResponseResult upload3(@RequestParam("head_img") MultipartFile file, DoctorInfo doctorInfo) {
//        // System.out.println("用户名："+user.getUser_name());
//        String userDir = System.getProperties().getProperty("user.dir")+"/img/";   //可以代替filePath
//        System.out.println("用户路径：" + userDir);
//        // 获取文件名
//        String fileName = file.getOriginalFilename();
//        System.out.println("上传的文件名为：" + fileName);
//
//        // 获取文件的后缀名,比如图片的jpeg,png
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        System.out.println("上传的后缀名为：" + suffixName);
//        File uploadFile = new File(userDir + fileName);
//        // 当父级目录不存在时，自动创建
//        if (!uploadFile.getParentFile().exists()) {
//            uploadFile.getParentFile().mkdirs();
//        }
//        // 文件上传后的路径
//        //fileName = UUID.randomUUID() + suffixName;
//        fileName = doctorInfo.getHospitalName() + doctorInfo.getDepartment() + doctorInfo.getDoctorName() + suffixName;
//        System.out.println("转换后的名称:"+fileName);
//        File dest = new File(userDir + fileName);
//        try {
//            file.transferTo(dest);
////            return new ResponseResult(0, "success to save",user.getUser_name());
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if(doctorInfo.getDoctorName() == null){
//            return new ResponseResult(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMessage(),doctorInfo);
//        }
//
//        int result = doctorInfoService.insertDoctorInfo(doctorInfo);
//        if(result>=1)
//            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),doctorInfo);
//        else
//            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage(),doctorInfo);
//    }

//    @ApiOperation(value="修改医生信息，修改图片的方法")
//    @RequestMapping(value = "upload4",method = RequestMethod.POST)
//    public ResponseResult upload4(@RequestParam("head_img") MultipartFile file, DoctorInfo doctorInfo) {
//        // System.out.println("用户名："+user.getUser_name());
//        String userDir = System.getProperties().getProperty("user.dir")+"/img/";   //可以代替filePath
//        System.out.println("用户路径：" + userDir);
//        // 获取文件名
//        String fileName = file.getOriginalFilename();
//        System.out.println("上传的文件名为：" + fileName);
//
//        // 获取文件的后缀名,比如图片的jpeg,png
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        System.out.println("上传的后缀名为：" + suffixName);
//        File uploadFile = new File(userDir + fileName);
//        // 当父级目录不存在时，自动创建
//        if (!uploadFile.getParentFile().exists()) {
//            uploadFile.getParentFile().mkdirs();
//        }
//        // 文件上传后的路径
//        //fileName = UUID.randomUUID() + suffixName;
//        fileName = doctorInfo.getHospitalName() + doctorInfo.getDepartment() + doctorInfo.getDoctorName() + suffixName;
//        System.out.println("转换后的名称:"+fileName);
//        File dest = new File(userDir + fileName);
//        try {
//            file.transferTo(dest);
////            return new ResponseResult(0, "success to save",user.getUser_name());
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if(doctorInfo.getDoctorName() == null){
//            return new ResponseResult(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMessage(),doctorInfo);
//        }
//
//        int result = doctorInfoService.updateDoctorInfo(doctorInfo);
//        if(result>=1)
//            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),doctorInfo);
//        else
//            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage(),doctorInfo);
//    }

//    @ApiOperation(value="根据图片名.后缀下载图片")
//    @GetMapping("/download")
//    public void download(@RequestParam String fileName, HttpServletResponse response) {
//        //  新建文件流，从磁盘读取文件流
//        String userDir = System.getProperties().getProperty("user.dir")+"/img/";   //可以代替filePath
//        System.out.println("用户路径：" + userDir);
//        try (FileInputStream fis = new FileInputStream(userDir + fileName);
//             BufferedInputStream bis = new BufferedInputStream(fis);
//             OutputStream os = response.getOutputStream()) {    //  OutputStream 是文件写出流，讲文件下载到浏览器客户端
//            // 新建字节数组，长度是文件的大小，比如文件 6kb, bis.available() = 1024 * 6
//            byte[] bytes = new byte[bis.available()];
//            // 从文件流读取字节到字节数组中
//            bis.read(bytes);
//            // 重置 response
//            response.reset();
//            // 设置 response 的下载响应头
//            response.setContentType("application/octet-stream");
//            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));  // 注意，这里要设置文件名的编码，否则中文的文件名下载后不显示
//            // 写出字节数组到输出流
//            os.write(bytes);
//            // 刷新输出流
//            os.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    /**
     * 上传头像
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "文件上传")
    @PostMapping("/fileupload")
    public ResponseResult<String> uploadOssFile(@RequestPart("file") MultipartFile file) {
        //获取上传的文件
        if (file.isEmpty()) {
            return new ResponseResult<>(ErrorCode.NULL_ERROR, "上传文件为空");
        }
        //返回上传到oss的路径
        String url = fileService.uploadFileAvatar(file);
        //返回r对象
        return new ResponseResult(200,"上传成功",url);
    }

    @ApiOperation(value = "添加药品信息，添加图片的方法")
    @PostMapping("/insertMedicine")
    public ResponseResult insertMedicine(@RequestPart("file") MultipartFile file, Medicine medicine) {
        //获取上传的文件
        if (file.isEmpty()) {
            return new ResponseResult(ErrorCode.NULL_ERROR.getCode(),"上传文件为空");
        }
        //返回上传到oss的路径
        String url = fileService.uploadFileAvatar(file);
        medicine.setImgUrl(url);
        //返回r对象
        int result = medicineService.insertMedicine(medicine);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),medicine);
        else
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage(),medicine);
    }

    @ApiOperation(value = "修改药品信息，修改图片的方法")
    @PostMapping("/updateMedicine")
    public ResponseResult uploadOssFileTest(@RequestParam(value = "file",required = false) MultipartFile file, Medicine medicine) throws Exception{
        //返回上传到oss的路径
        try{
            if (file != null) {
                //返回上传到oss的路径
                String url = fileService.uploadFileAvatar(file);
                medicine.setImgUrl(url);
            }
        }catch (Exception e){

        }finally {

        }
        //返回r对象
        int result = medicineService.updateMedicine(medicine);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),medicine);
        else
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage(),medicine);
    }

    @ApiOperation(value = "添加医生信息，添加图片的方法")
    @PostMapping("/insertDoctor")
    public ResponseResult insertDoctor(@RequestPart("file") MultipartFile file, DoctorInfo doctorInfo) {
        //返回上传到oss的路径
        String url = fileService.uploadFileAvatar(file);
        doctorInfo.setImgUrl(url);
        //返回r对象
        int result = doctorInfoService.insertDoctorInfo(doctorInfo);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),doctorInfo);
        else
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage(),doctorInfo);
    }

    @ApiOperation(value = "修改医生信息，修改图片的方法")
    @PostMapping("/updateDoctorInfo")
    public ResponseResult updateDoctorInfo(@RequestParam(value = "file",required = false)  MultipartFile file, DoctorInfo doctorInfo) {
        try{
            if (file != null) {
                //返回上传到oss的路径
                String url = fileService.uploadFileAvatar(file);
                doctorInfo.setImgUrl(url);
            }
        }catch (Exception e){

        }finally {

        }
        int result = doctorInfoService.updateDoctorInfo(doctorInfo);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),doctorInfo);
        else
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage(),doctorInfo);
    }
}