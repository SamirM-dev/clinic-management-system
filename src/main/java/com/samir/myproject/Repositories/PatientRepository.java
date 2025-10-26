package com.samir.myproject.Repositories;

import com.samir.myproject.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository public interface PatientRepository extends JpaRepository<Patient, Long> {
    public List<Patient> findByNameIgnoreCase(String name);
    public Optional<Patient> findByPhone(String phone);
}
