package br.com.ms_beautique_query.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ms_beautique_query.dtos.appointments.FullAppointmentDTO;
import br.com.ms_beautique_query.services.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    ResponseEntity<List<FullAppointmentDTO>> listAllAppointments() {
        return ResponseEntity.ok(appointmentService.listAllAppointments());
    }

    @GetMapping("/customer/{customerId}")
    ResponseEntity<List<FullAppointmentDTO>> listAppointmentsByCustomer(Long customerId) {
        return ResponseEntity.ok(appointmentService.listAppointmentsByCustomer(customerId));
    }

    @GetMapping("/beauty-procedure/{beautyProcedureId}")
    ResponseEntity<List<FullAppointmentDTO>> listAppointmentsByBeautyProcedure(Long beautyProcedureId) {
        return ResponseEntity.ok(appointmentService.listAppointmentsByBeautyProcedure(beautyProcedureId));
    }

}
