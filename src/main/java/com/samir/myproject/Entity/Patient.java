package com.samir.myproject.Entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
public class Patient {
    //Поля
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
    private String name;
    private String phone;
    private String email;
    @Column(name = "date_of_birth") private LocalDate dateOfBirth;

    //Конструкторы
    public Patient(){}
    public Patient(String name,String specialization,String phone,String email,LocalDate dateOfBirth){
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.dateOfBirth=dateOfBirth;
    }
    public Patient(String name,String specialization,String phone,LocalDate dateOfBirth){
        this.name=name;
        this.phone=phone;
        this.dateOfBirth=dateOfBirth;
        email="none";
    }

    //Сеттеры
    public void setName(String name){
        this.name=name;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setDateOfBirth(LocalDate dateOfBirth){this.dateOfBirth=dateOfBirth;}

    //Геттеры
    public long getId(){return id;}
    public String getName(){return name;}
    public String getPhone(){return phone;}
    public String getEmail(){return email;}
    public LocalDate getSpecialization(){return dateOfBirth;}
}
