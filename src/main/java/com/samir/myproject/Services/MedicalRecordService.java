package com.samir.myproject.Services;

import com.samir.myproject.Entity.MedicalRecord;
import com.samir.myproject.Repositories.MedicalRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class MedicalRecordService {
    MedicalRecordRepository medicalRecordRepository;
    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository){
        this.medicalRecordRepository=medicalRecordRepository;
    }

    public MedicalRecord addMedicalRecord(MedicalRecord record){
        if(record==null) {
            throw new IllegalArgumentException("Медицинской записи нет!");
        }
        return medicalRecordRepository.save(record);
    }   // Добавить мед запись
    public List<MedicalRecord> getPatientMedicalHistory(Long patientId){
        if(patientId<=0){
            throw new IllegalArgumentException("Айди должен быть положительным!");
        }
        return medicalRecordRepository.findByPatientId(patientId);
    } // История болезней пациента
    public MedicalRecord updateMedicalRecord(Long id, String diagnosis, String treatment){
        if(id<=0){
            throw new IllegalArgumentException("Айди должен быть положительным!");
        }
        if (diagnosis==null||diagnosis.trim().isEmpty()){
            throw new IllegalArgumentException("Диагноза нет!");
        }
        if (treatment==null||treatment.trim().isEmpty()){
            throw new IllegalArgumentException("Лечения нет!");
        }
        Optional<MedicalRecord> optionalMedicalRecord = medicalRecordRepository.findById(id);
        if(optionalMedicalRecord.isEmpty()){
            throw new IllegalArgumentException("Такой записи нет!");
        }
        MedicalRecord medicalRecord = optionalMedicalRecord.get();
        medicalRecord.setDiagnosis(diagnosis);
        medicalRecord.setTreatment(treatment);
        return medicalRecordRepository.save(medicalRecord);

    } // Обновить запись
}
