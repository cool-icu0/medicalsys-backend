package com.example.medicalsysbackend.mapper;

import com.example.medicalsysbackend.domain.Medicine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Cool
* @description 针对表【medicine】的数据库操作Mapper
* @createDate 2024-04-22 22:00:19
* @Entity generator.domain.Medicine
*/
public interface MedicineMapper extends BaseMapper<Medicine> {
    @Select("select * from medicine")
    public List<Medicine> selectAllMedicine();

    @Select("select * from medicine where medicine_name = #{medicine_name}")
    public Medicine selectMedicineByName(String medicine_name);

    @Select("select * from medicine where medicine_id = #{medicineId}")
    public Medicine selectMedicineById(int medicine_id);

    @Insert("insert into medicine values(null,#{medicineName},#{manufacturer},#{imgUrl},#{unitPrice},#{quantity},#{description})")
    public int insertMedicine(Medicine medicine);

    @Update("update medicine set medicine_name = #{medicineName},manufacturer=#{manufacturer},img_url=#{imgUrl},unit_price=#{unitPrice},quantity=#{quantity},description=#{description} where medicine_id = #{medicineId}")
    public int updateMedicine(Medicine medicine);


}




