package com.samir.myproject.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "medical_records")
public class MedicalRecord {
    //Поля
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne @JoinColumn(name = "patient_id") private Patient patient;
    private String diagnosis;
    private String treatment;
    @Column(name = "record_date") LocalDateTime recordDate;

    //Конструкторы
    public MedicalRecord(){}
    public MedicalRecord(Patient patient,String diagnosis){
        this.patient=patient;
        patient.addMedicalRecord(this);
        this.diagnosis=diagnosis;
        treatment="Лечение не требуется, пациент здоров!";
        recordDate=LocalDateTime.now();
    }
    public MedicalRecord(Patient patient,String diagnosis,String treatment){
        this.patient=patient;
        patient.addMedicalRecord(this);
        this.diagnosis=diagnosis;
        this.treatment=treatment;
        recordDate=LocalDateTime.now();
    }

    //Сеттеры
    public void setDiagnosis(String diagnosis){this.diagnosis=diagnosis;}
    public void setTreatment(String treatment){this.treatment=treatment;}

    //Геттеры
    public Patient getPatient(){return patient;}
    public String getDiagnosis(){return diagnosis;}
    public String getTreatment(){return treatment;}
    public LocalDateTime getRecordDate(){return recordDate;}

}
