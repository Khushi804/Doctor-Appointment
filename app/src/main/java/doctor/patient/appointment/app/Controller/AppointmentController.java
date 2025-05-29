package doctor.patient.appointment.app.Controller;

import doctor.patient.appointment.app.Entity.AppointmentEntity;
import doctor.patient.appointment.app.Service.AppointmentService;
import doctor.patient.appointment.app.dto.AppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/create-appointment")
    public ResponseEntity<?> book(@RequestBody  AppointmentDTO dto) {
        return ResponseEntity.ok(appointmentService.bookAppointment(dto));
    }

    @GetMapping("/all-appointments")
    public List<AppointmentEntity> getAll() {
        return ResponseEntity.ok(appointmentService.getAllAppointments()).getBody();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentEntity> getAppointmentById(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @DeleteMapping("/{id}")
    public void cancel(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
    }


}

