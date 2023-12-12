package com.medical.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.model.Patient;
import com.medical.repository.PatientRepository;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void deletePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Other methods...
}
