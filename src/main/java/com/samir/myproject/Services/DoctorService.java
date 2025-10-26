package com.samir.myproject.Services;

import com.samir.myproject.Entity.Doctor;
import com.samir.myproject.Repositories.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @Transactional public class DoctorService {
    DoctorRepository doctorRepository;
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }

    public Doctor addDoctor(Doctor doctor){
        if(doctor==null)throw  new IllegalArgumentException("Доктора не существует!");
        if(doctorRepository.findByPhone(doctor.getPhone()).isPresent()) throw new IllegalArgumentException("Такой номер уже есть у другого доктора!");
        if(doctorRepository.findByEmail(doctor.getEmail()).isPresent()) throw new IllegalArgumentException("Такая почта уже есть у другого доктора!");
        return doctorRepository.save(doctor);
    }
    public List<Doctor> findDoctorsBySpecialization(String specialization){
        if(specialization==null||specialization.trim().isEmpty()) throw new IllegalArgumentException("Нет такой специализации!");
        return doctorRepository.findBySpecializationIgnoreCase(specialization);
    }
    public List<Doctor> getAllDoctors(){return doctorRepository.findAll();}
    public Doctor findDoctorById(Long id){
        if (id<=0) throw new IllegalArgumentException("Айди должно быть положительным!");
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if(optionalDoctor.isEmpty()){
            throw new IllegalArgumentException("Доктора с таким айди нет!");
        }
        return optionalDoctor.get();
    }
    public List<Doctor> findAvailableDoctors(){ return doctorRepository.findAvailableDoctors();}

}
