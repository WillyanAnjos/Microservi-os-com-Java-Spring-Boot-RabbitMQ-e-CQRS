package br.com.ms_beautique_query.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ms_beautique_query.dtos.appointments.FullAppointmentDTO;
import br.com.ms_beautique_query.repositories.AppointmentRepository;
import br.com.ms_beautique_query.services.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<FullAppointmentDTO> listAllAppointments() {
        try {
            return appointmentRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error on list all appointments", e);
        }
    }

    @Override
    public List<FullAppointmentDTO> listAppointmentsByCustomer(Long customerId) {
        try {
            return appointmentRepository.listAppointmentByCustomerId(customerId);
        } catch (Exception e) {
            throw new RuntimeException("Error on list appointments by customer", e);
        }
    }

    @Override
    public List<FullAppointmentDTO> listAppointmentsByBeautyProcedure(Long beautyProcedureId) {
        try {
            return appointmentRepository.listAppointmentByBeautyProcedureId(beautyProcedureId);
        } catch (Exception e) {
            throw new RuntimeException("Error on list appointments by beauty procedure", e);
        }
    }

}
