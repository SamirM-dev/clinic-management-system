package com.samir.myproject.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "appointments")
public class Appointment {
    private final static Set<String> VALID_STATUSES= Set.of("SCHEDULED", "COMPLETED", "CANCELLED", "IN_PROGRESS");
    //Поля
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne @JoinColumn(name = "patient_id") private Patient patient;
    @ManyToOne @JoinColumn(name = "doctor_id") private Doctor doctor;
    @Column(name = "appointment_date") private LocalDateTime appointmentDate;
    private String status;

    //Конструкторы
    public Appointment(){}
    public Appointment(Patient patient,Doctor doctor,LocalDateTime appointmentDate,String status){
        if (!VALID_STATUSES.contains(status)){
            throw new IllegalArgumentException("Неверный статус приёма: "+status);
        }
        this.patient=patient;
        this.doctor=doctor;
        this.appointmentDate=appointmentDate;
        this.status=status;
        patient.addAppointment(this);
        doctor.addAppointment(this);
    }

    //Сеттеры
    public void changePatient(Patient newPatient){
        patient.deleteAppointment(this);
        patient=newPatient;
        newPatient.addAppointment(this);
    }
    public void changeDoctor(Doctor newDoctor){
        doctor.deleteAppointment(this);
        doctor=newDoctor;
        newDoctor.addAppointment(this);
    }
    public void changeAppointmentDate(LocalDateTime newAppointmentDate){appointmentDate=newAppointmentDate;}
    public void changeStatus(String newStatus){
        if (!VALID_STATUSES.contains(newStatus)){
            throw new IllegalArgumentException("Неверный статус приёма: "+status);
        }
        status=newStatus;
    }

    //Геттеры
    public Patient getPatient(){return patient;}
    public Doctor getDoctor(){return doctor;}
    public LocalDateTime getAppointmentDate(){return appointmentDate;}
    public String getStatus(){return status;}
}
