package doctor.patient.appointment.app.Service;


import doctor.patient.appointment.app.Entity.PatientEntity;
import doctor.patient.appointment.app.Repository.PatientRepository;
import doctor.patient.appointment.app.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientDTO addPatient(PatientDTO dto) {
        PatientEntity patient = new PatientEntity();
        patient.setName(dto.name());
        patient.setEmail(dto.email());
        PatientEntity saved = patientRepository.save(patient);
        return new PatientDTO(saved.getId(), saved.getName(), saved.getEmail());
    }

    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(p -> new PatientDTO(p.getId(), p.getName(), p.getEmail()))
                .toList();
    }

    public PatientDTO getPatientById(Long id) {
        PatientEntity p = patientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Patient not found"));
        return new PatientDTO(p.getId(), p.getName(), p.getEmail());
    }

    public PatientDTO updatePatient(Long id, PatientDTO dto) {
        PatientEntity p = patientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Patient not found"));
        p.setName(dto.name());
        p.setEmail(dto.email());
        PatientEntity updated = patientRepository.save(p);
        return new PatientDTO(updated.getId(), updated.getName(), updated.getEmail());
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}

