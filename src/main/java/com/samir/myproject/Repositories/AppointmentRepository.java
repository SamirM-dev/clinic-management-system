package com.samir.myproject.Repositories;

import com.samir.myproject.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    public List<Appointment> findByDoctorIdAndAppointmentDate(Long doctorId, LocalDateTime appointmentDate);
    public List<Appointment> findByPatientId(Long patientId);
    public List<Appointment> findByStatus(String status);

}
