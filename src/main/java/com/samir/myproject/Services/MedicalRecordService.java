package com.samir.myproject.Services;

import com.samir.myproject.Entity.MedicalRecord;
import com.samir.myproject.Repositories.MedicalRecordRepository;

import java.util.List;

public class MedicalRecordService {
    MedicalRecordRepository medicalRecordRepository;
    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository){
        this.medicalRecordRepository=medicalRecordRepository;
    }

    public MedicalRecord addMedicalRecord(MedicalRecord record){

    }   // Добавить мед запись
    public List<MedicalRecord> getPatientMedicalHistory(Long patientId){

    } // История болезней пациента
    public MedicalRecord updateMedicalRecord(Long id, String diagnosis, String treatment){
        gi
    } // Обновить запись
}
