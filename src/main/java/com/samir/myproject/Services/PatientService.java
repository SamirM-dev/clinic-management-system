package com.samir.myproject.Services;

import com.samir.myproject.Entity.Patient;
import com.samir.myproject.Repositories.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @Transactional public class PatientService {
    PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository){this.patientRepository=patientRepository;}

    public Patient registerPatient(Patient patient){
        if(patient==null) throw new IllegalArgumentException("Пациента не существует!");
        if (patientRepository.findByPhone(patient.getPhone()).isPresent()) throw new IllegalArgumentException("Такой номер телефона уже есть у другого пациента!");
        return patientRepository.save(patient);
    }
    public Patient findPatientById(Long id){
        if(id<=0) throw new IllegalArgumentException("Айди должен быть положительным!");
        Optional<Patient> optionalPatient=patientRepository.findById(id);
        if (optionalPatient.isEmpty()) {
            throw new IllegalArgumentException("Такого пациента не существует!");
        }

        return optionalPatient.get();
    }
    public List<Patient> searchPatientsByName(String name){
        if(name==null||name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым!");
        }
        return patientRepository.findByNameIgnoreCase(name);
    }
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    public void deletePatient(Long id){
        if(id<=0) throw new IllegalArgumentException("Айди должен быть положительным!");
        patientRepository.deleteById(id);
    }
}
