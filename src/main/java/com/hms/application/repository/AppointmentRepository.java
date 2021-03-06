package com.hms.application.repository;

import com.hms.application.entity.infoAppoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 预约信息表数据库操作接口
 */
public interface AppointmentRepository extends JpaRepository<infoAppoint,String> {
    //根据预约编号查找预约信息
    List<infoAppoint>findByAppointId(String appointId);
    //根据预约日期查找预约信息
    List<infoAppoint>findByAppointDate(String appointDate);
    //根据预约日期和是否删除标志查找预约信息
    List<infoAppoint>findByAppointDateAndDm(String appointDate,String dm);
    //根据预约医生和是否删除标志查找预约信息
    List<infoAppoint>findByAppointDocAndDm(String appointDoc,String dm);

    //根据预约编号更新预约信息
    @Transactional
    @Modifying
    @Query(value = "update info_appoint set appoint_clinic = ?1,appoint_type=?2,appoint_date=?3,appoint_doc=?4,appoint_inf=?5", nativeQuery = true)
    int updateAppoint(String appointClinic,String appointType,String appointDate,String appointDoc,String appointInf);

}
