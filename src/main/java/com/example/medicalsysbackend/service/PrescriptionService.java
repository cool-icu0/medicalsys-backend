package com.example.medicalsysbackend.service;

import com.example.medicalsysbackend.domain.PhysicalCondition;
import com.example.medicalsysbackend.domain.Prescription;
import com.baomidou.mybatisplus.extension.service.IService;

import java.text.ParseException;
import java.util.List;

/**
* @author Cool
* @description 针对表【prescription】的数据库操作Service
* @createDate 2024-04-22 22:00:29
*/
public interface PrescriptionService extends IService<Prescription> {
    public List<Prescription> selectAllPrescription();
    public List<Prescription> selectPrescriptionByUserId(int userId);
    public Prescription selectOnlyOnePrescriptionByUserId(int userId);
    public Prescription selectPrescriptionById(int id);
    public int insertPrescription(Prescription prescription) throws ParseException;
    public int insertDocPrescription(Prescription prescription) throws ParseException;
    public int updatePrescription(Prescription prescription);
    public int authorize(int id);
    public int unAuthorize(int id,int userid);
    public int charge(int id);
    public int healCardCharge(int id);
}
