package br.com.beautique.ms_sync.services;

import br.com.beautique.ms_sync.dtos.appointments.FullAppointmentDTO;
import br.com.beautique.ms_sync.dtos.beautyprocedures.BeautyProcedureDTO;
import br.com.beautique.ms_sync.dtos.customers.CustomerDTO;

public interface AppointmentService {

    void saveAppointment(FullAppointmentDTO fullAppointmentDTO);

    void updateAppointmentCustomer(CustomerDTO customerDTO);

    void updateAppointmentBeautyProcedures(BeautyProcedureDTO beautyProcedureDTO);
    
}
