package doctor.patient.appointment.app.Service;

import doctor.patient.appointment.app.Entity.AppointmentEntity;
import doctor.patient.appointment.app.Entity.DoctorEntity;
import doctor.patient.appointment.app.Entity.PatientEntity;
import doctor.patient.appointment.app.Repository.AppointmentRepository;
import doctor.patient.appointment.app.Repository.DoctorRepository;
import doctor.patient.appointment.app.Repository.PatientRepository;
import doctor.patient.appointment.app.dto.AppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AppointmentService {
    @Autowired private AppointmentRepository appointmentRepo;
    @Autowired private DoctorRepository doctorRepo;
    @Autowired
    private PatientRepository patientRepo;

    public AppointmentEntity bookAppointment(AppointmentDTO dto) {
        DoctorEntity doctor = doctorRepo.findById(dto.doctorId()).orElseThrow();
        PatientEntity patient = patientRepo.findById(dto.patientId()).orElseThrow();

        if (appointmentRepo.existsByDoctorAndAppointmentDateTime(doctor, dto.appointmentDateTime())) {
            throw new IllegalArgumentException("Doctor already booked for this time.");
        }

        AppointmentEntity appointment = new AppointmentEntity();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentDateTime(dto.appointmentDateTime());

        return appointmentRepo.save(appointment);
    }

    public List<AppointmentEntity> getAllAppointments() {
        return appointmentRepo.findAll();
    }


    public AppointmentEntity getAppointmentById(Long id) {
        return appointmentRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Appointment not found"));
    }


    public void cancelAppointment(Long id) {
        if (!appointmentRepo.existsById(id)) {
            throw new NoSuchElementException("Appointment not found");
        }
        appointmentRepo.deleteById(id);
    }
}
