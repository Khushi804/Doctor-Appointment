package doctor.patient.appointment.app.dto;

import java.time.LocalDateTime;

public record AppointmentDTO(Long doctorId, Long patientId, LocalDateTime appointmentDateTime) {
}
