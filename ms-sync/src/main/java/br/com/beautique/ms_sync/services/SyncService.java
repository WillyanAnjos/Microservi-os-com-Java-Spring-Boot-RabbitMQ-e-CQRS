package br.com.beautique.ms_sync.services;

import br.com.beautique.ms_sync.dtos.appointments.FullAppointmentDTO;
import br.com.beautique.ms_sync.dtos.beautyprocedures.BeautyProcedureDTO;
import br.com.beautique.ms_sync.dtos.customers.CustomerDTO;

public interface SyncService {
    void syncCustomer(CustomerDTO customerDTO);
    void syncAppointment(FullAppointmentDTO fullAppointmentDTO);
    void syncBeautyProcedures(BeautyProcedureDTO beautyProcedureDTO);
}
