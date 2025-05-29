package doctor.patient.appointment.app.Service;

import doctor.patient.appointment.app.Entity.DoctorEntity;
import doctor.patient.appointment.app.Repository.DoctorRepository;
import doctor.patient.appointment.app.dto.DoctorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorDTO addDoctor(DoctorDTO dto) {
        DoctorEntity doctor = new DoctorEntity();
        doctor.setName(dto.name());
        doctor.setSpecialization(dto.specialization());
        DoctorEntity saved = doctorRepository.save(doctor);
        return new DoctorDTO(saved.getId(), saved.getName(), saved.getSpecialization());
    }

    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(doc -> new DoctorDTO(doc.getId(), doc.getName(), doc.getSpecialization()))
                .toList();
    }

    public DoctorDTO getDoctorById(Long id) {
        DoctorEntity doc = doctorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Doctor not found"));
        return new DoctorDTO(doc.getId(), doc.getName(), doc.getSpecialization());
    }

    public DoctorDTO updateDoctor(Long id, DoctorDTO dto) {
        DoctorEntity doc = doctorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Doctor not found"));
        doc.setName(dto.name());
        doc.setSpecialization(dto.specialization());
        DoctorEntity updated = doctorRepository.save(doc);
        return new DoctorDTO(updated.getId(), updated.getName(), updated.getSpecialization());
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}

