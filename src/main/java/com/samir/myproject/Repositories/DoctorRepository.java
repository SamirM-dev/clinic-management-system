package com.samir.myproject.Repositories;

import com.samir.myproject.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    public List<Doctor> findBySpecializationIgnoreCase(String specialization);
    public Optional<Doctor> findByPhone(String phone);
    public Optional<Doctor> findByEmail(String email);
    @Query("SELECT d FROM Doctor d  WHERE d.id NOT IN (SELECT a.doctor.id FROM Appointment a WHERE a.status='IN_PROGRESS')") public List<Doctor> findAvailableDoctors();
}
