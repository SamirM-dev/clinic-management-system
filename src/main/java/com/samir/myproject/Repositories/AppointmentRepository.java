package com.samir.myproject.Repositories;

import com.samir.myproject.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    public List<Appointment> findByPatientId(Long patientId);
    public List<Appointment> findByStatus(String status);
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id=:id AND a.appointmentDate BETWEEN :startDate AND :endDate") public List<Appointment> findByDoctorIdAndDate(@Param("id")Long id,@Param("startDate") LocalDateTime startDate,@Param("endDate") LocalDateTime endDate);

}
