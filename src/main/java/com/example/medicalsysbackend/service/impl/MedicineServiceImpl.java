package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.Medicine;
import com.example.medicalsysbackend.domain.Prescription;
import com.example.medicalsysbackend.service.MedicineService;
import com.example.medicalsysbackend.mapper.MedicineMapper;
import com.example.medicalsysbackend.service.PrescriptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
* @author Cool
* @description 针对表【medicine】的数据库操作Service实现
* @createDate 2024-04-22 22:00:19
*/
@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine>
    implements MedicineService{

    @Resource
    MedicineMapper medicineMapper;

    @Resource
    PrescriptionService prescriptionService;

    @Override
    public List<Medicine> selectAllMedicine() {
        return medicineMapper.selectAllMedicine();
    }

    @Override
    public Medicine selectMedicineByName(String medicine_name) {
        return medicineMapper.selectMedicineByName(medicine_name);
    }

    @Override
    public Medicine selectMedicineById(int medicine_id) {
        return medicineMapper.selectMedicineById(medicine_id);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public int charge(Medicine medicine, int quantity, int user_id) throws ParseException {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter fullDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(fullDate);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
        if (medicine.getQuantity() < quantity) return -2;
        medicine.setQuantity(medicine.getQuantity() - quantity);
        int result = medicineMapper.updateMedicine(medicine);
        if(result >= 1){
            Prescription prescription = new Prescription();
            prescription.setUserId(user_id);
            prescription.setCreateTime(d);
            prescription.setMedicationGuide(medicine.getMedicineName()+"x"+quantity);
            System.out.println(prescription.getMedicationGuide()+"11111111----");
            prescription.setStatus("未受理");
            result = prescriptionService.insertPrescription(prescription);
        }
        if(result >= 1) return result;
        else {
            double t = 1 / 0;
            return -1;
        }
    }

    @Override
    public int insertMedicine(Medicine medicine) {
        Medicine m = medicineMapper.selectMedicineByName(medicine.getMedicineName());
        if(m != null) return -1;
        return medicineMapper.insertMedicine(medicine);
    }

    @Override
    public int updateMedicine(Medicine medicine) {
        return medicineMapper.updateMedicine(medicine);
    }
}




