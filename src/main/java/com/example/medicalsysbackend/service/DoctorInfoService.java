package com.example.medicalsysbackend.service;

import com.example.medicalsysbackend.domain.DoctorInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.medicalsysbackend.domain.Medicine;

import java.text.ParseException;
import java.util.List;

/**
* @author Cool
* @description 针对表【doctor_info】的数据库操作Service
* @createDate 2024-04-22 22:00:04
*/
//asdasda
public interface DoctorInfoService extends IService<DoctorInfo> {
    public List<DoctorInfo> selectAllDoctorInfo();
    public DoctorInfo selectDoctorInfoById(int id);
    public List<DoctorInfo> selectDoctorInfoBydoctorName(String doctorName);
    public List<DoctorInfo> selectDoctorInfoByDepartment(String department);
    public int insertDoctorInfo(DoctorInfo doctorInfo);
    public int updateDoctorInfo(DoctorInfo doctorInfo);
    public int deleteDoctorInfo(int id);
    int charge(DoctorInfo doctorInfo, int user_id) throws ParseException;
}
