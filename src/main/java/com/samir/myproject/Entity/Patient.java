package com.samir.myproject.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {
    //Поля
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String name;
    private String phone;
    private String email;
    @Column(name = "date_of_birth") private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "patient") private List<Appointment> listOfAppointments=new ArrayList<>();
    @OneToMany(mappedBy = "patient") private List<MedicalRecord> medicalRecords=new ArrayList<>();

    //Конструкторы
    public Patient(){}
    public Patient(String name,String phone,String email,LocalDate dateOfBirth){
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.dateOfBirth=dateOfBirth;
    }
    public Patient(String name,String phone,LocalDate dateOfBirth){
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
    protected void addAppointment(Appointment appointment){
        if(listOfAppointments.contains(appointment)){
            System.out.println("ОШИБКА...Эта встреча уже назначена!");
            return;
        }
        listOfAppointments.add(appointment);
    }
    protected void deleteAppointment(Appointment appointment){
        if (!listOfAppointments.contains(appointment)){
            System.out.println("ОШИБКА...Такой приём не был назначен!");
            return;
        }
        listOfAppointments.remove(appointment);
    }
    protected void addMedicalRecord(MedicalRecord medicalRecord){
        if(medicalRecords.contains(medicalRecord)){
            System.out.println("ОШИБКА...Такая запись уже имеется!");
            return;
        }
        medicalRecords.add(medicalRecord);
    }
    protected void deleteMedicalRecord(MedicalRecord medicalRecord){
        if(!medicalRecords.contains(medicalRecord)){
            System.out.println("ОШИБКА...Такой записи не существует!");
            return;
        }
        medicalRecords.remove(medicalRecord);
    }

    //Геттеры
    public long getId(){return id;}
    public String getName(){return name;}
    public String getPhone(){return phone;}
    public String getEmail(){return email;}
    public LocalDate getDateOfBirth(){return dateOfBirth;}
    public List<Appointment> getListOfAppointments(){
        if(listOfAppointments.isEmpty()) return List.of();
        return listOfAppointments;
    }
    public List<MedicalRecord> getMedicalRecord(){return medicalRecords;}
}
