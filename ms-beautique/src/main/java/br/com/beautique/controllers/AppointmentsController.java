package br.com.beautique.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beautique.dtos.AppointmentDTO;
import br.com.beautique.services.AppointmentsService;

@RestController
@RequestMapping("/appointments")
public class AppointmentsController {

    @Autowired
    private AppointmentsService appointmentsService;

    @PostMapping
    ResponseEntity<AppointmentDTO> create(AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appointmentsService.create(appointmentDTO));
    }

    @PatchMapping
    ResponseEntity<AppointmentDTO> update(AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appointmentsService.update(appointmentDTO));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(Long id) {
        appointmentsService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    ResponseEntity<AppointmentDTO> setCustomerToAppointment(AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appointmentsService.setCustomerToAppointment(appointmentDTO));
    }
}
