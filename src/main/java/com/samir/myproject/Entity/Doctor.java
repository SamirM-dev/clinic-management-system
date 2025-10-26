package com.samir.myproject.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors") public class Doctor {
    //Поля
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String name;
    private String specialization;
    private String phone;
    private String email;
    @OneToMany(mappedBy = "doctor") private List<Appointment> appointments=new ArrayList<>();

    //Конструкторы
    public Doctor(){}
    public Doctor(String name,String specialization,String phone,String email){
        this.name=name;
        this.specialization=specialization;
        this.phone=phone;
        this.email=email;
    }

    //Сеттеры
    public void setName(String name){
        this.name=name;
    }
    public void setSpecialization(String specialization){
        this.specialization=specialization;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setEmail(String email){
        this.email=email;
    }
    protected void addAppointment(Appointment appointment){
        if(appointments.contains(appointment)){
            System.out.println("ОШИБКА...Эта встреча уже назначена!");
            return;
        }
        appointments.add(appointment);
    }
    protected void deleteAppointment(Appointment appointment){
        if (!appointments.contains(appointment)){
            System.out.println("ОШИБКА...Такой приём не был назначен!");
            return;
        }
        appointments.remove(appointment);
    }


    //Геттеры
    public long getId(){return id;}
    public String getName(){return name;}
    public String getSpecialization(){return specialization;}
    public String getPhone(){return phone;}
    public String getEmail(){return email;}
    public List<Appointment> getListOfAppointments(){
        if(appointments.isEmpty()) return List.of();
        return appointments;
    }
}
