package com.example.medicalsysbackend.service;

import com.example.medicalsysbackend.domain.Medicine;
import com.baomidou.mybatisplus.extension.service.IService;

import java.text.ParseException;
import java.util.List;

/**
* @author Cool
* @description 针对表【medicine】的数据库操作Service
* @createDate 2024-04-22 22:00:19
*/
public interface MedicineService extends IService<Medicine> {
    public List<Medicine> selectAllMedicine();
    public Medicine selectMedicineByName(String medicine_name);
    public int insertMedicine(Medicine medicine);
    public int updateMedicine(Medicine medicine);
    public Medicine selectMedicineById(int medicine_id);
    int charge(Medicine medicine, int quantity, int user_id) throws ParseException;
}
