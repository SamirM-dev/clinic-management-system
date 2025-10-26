package com.samir.myproject.Repositories;

import com.samir.myproject.Entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {
    public List<MedicalRecord> findByPatientId(Long patientId);
}
