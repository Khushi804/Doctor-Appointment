package doctor.patient.appointment.app.Repository;

import doctor.patient.appointment.app.Entity.AppointmentEntity;
import doctor.patient.appointment.app.Entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
    boolean existsByDoctorAndAppointmentDateTime(DoctorEntity doctor, LocalDateTime time);
}
