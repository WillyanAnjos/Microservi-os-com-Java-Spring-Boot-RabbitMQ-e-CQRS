package br.com.beautique.services;

import br.com.beautique.dtos.AppointmentDTO;

public interface AppointmentsService {
    AppointmentDTO create(AppointmentDTO appointmentDTO);
    AppointmentDTO update(AppointmentDTO appointmentDTO);

    void delete(Long id);

    AppointmentDTO setCustomerToAppointment(AppointmentDTO appointment);
}
