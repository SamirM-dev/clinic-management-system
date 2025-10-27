package com.samir.myproject.Services;

import com.samir.myproject.Utils.ClinicManagementSystemUtil;
import com.samir.myproject.Entity.Appointment;
import com.samir.myproject.Repositories.AppointmentRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service @Transactional public class AppointmentService {
    AppointmentRepository appointmentRepository;
    ClinicManagementSystemUtil clinicManagementSystemUtil;

    public AppointmentService(AppointmentRepository appointmentRepository,ClinicManagementSystemUtil clinicManagementSystemUtil){
        this.appointmentRepository=appointmentRepository;
        this.clinicManagementSystemUtil=clinicManagementSystemUtil;
    }

    public Appointment scheduleAppointment(Appointment appointment){
        if (appointment==null) {
            throw new IllegalArgumentException("Приёма не существует!");
        }
        return appointmentRepository.save(appointment);
    }
    public Appointment updateAppointmentStatus(Long id, String newStatus){
        if (id<=0){
            throw new IllegalArgumentException("Айди должен быть положительным!");
        }
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if (optionalAppointment.isEmpty()){
            throw new IllegalArgumentException("Такого приёма нет!");
        }
        Appointment appointment = optionalAppointment.get();
        appointment.changeStatus(newStatus);
        return appointmentRepository.save(appointment);
    }
    public List<Appointment> getAppointmentsByDoctorAndDate(Long doctorId, LocalDate date){
        if (doctorId<=0){
            throw new IllegalArgumentException("Айди должен быть положительным!");
        }
        LocalDateTime startDate = date.atStartOfDay();
        LocalDateTime endDate = date.plusDays(1).atStartOfDay();
        return appointmentRepository.findByDoctorIdAndDate(doctorId,startDate,endDate);

    }
    public List<Appointment> getAppointmentsByPatient(Long patientId){
        if (patientId<=0){
            throw new IllegalArgumentException("Айди должен быть положительным!");
        }
        return appointmentRepository.findByPatientId(patientId);
    }
    public List<Appointment> getAppointmentsByStatus(String status){
        if (!clinicManagementSystemUtil.isCorrectStatus(status)){
            throw new IllegalArgumentException("Неверный статус!");
        }
        return appointmentRepository.findByStatus(status);
    }
    public boolean cancelAppointment(Long appointmentId) {
        if (appointmentId<=0){
            throw new IllegalArgumentException("Айди должен быть положительным!");
        }
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        if(optionalAppointment.isEmpty()){
            throw new IllegalArgumentException("Такого приёма не было");
        }
        Appointment appointment = optionalAppointment.get();
        appointment.changeStatus("CANCELLED");
        return true;
    }
}
