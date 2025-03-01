package br.com.ms_beautique_query.services;

import java.util.List;

import br.com.ms_beautique_query.dtos.appointments.FullAppointmentDTO;

public interface AppointmentService {

    List<FullAppointmentDTO> listAllAppointments();
    List<FullAppointmentDTO> listAppointmentsByCustomer(Long customerId);
    List<FullAppointmentDTO> listAppointmentsByBeautyProcedure(Long beautyProcedureId);
}
