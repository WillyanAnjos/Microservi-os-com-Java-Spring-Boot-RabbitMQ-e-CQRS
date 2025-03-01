package br.com.beautique.ms_sync.services.impl;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import br.com.beautique.ms_sync.dtos.appointments.FullAppointmentDTO;
import br.com.beautique.ms_sync.dtos.beautyprocedures.BeautyProcedureDTO;
import br.com.beautique.ms_sync.dtos.customers.CustomerDTO;
import br.com.beautique.ms_sync.services.AppointmentService;
import br.com.beautique.ms_sync.services.BeautyProcedureService;
import br.com.beautique.ms_sync.services.CustomerService;
import br.com.beautique.ms_sync.services.SyncService;
import br.com.beautique.ms_sync.utils.SyncLogger;

@Service
public class SyncServiceImpl implements SyncService {

    private final AppointmentService appointmentService;
    private final CustomerService customerService;
    private final BeautyProcedureService beautyProcedureService;
    
    public SyncServiceImpl(AppointmentService appointmentService, CustomerService customerService,
            BeautyProcedureService beautyProcedureService) {
        this.appointmentService = appointmentService;
        this.customerService = customerService;
        this.beautyProcedureService = beautyProcedureService;
    }

    @Override
    public void syncCustomer(CustomerDTO customerDTO) {

        try {
            SyncLogger.info("Saving customer: " + customerDTO.getId());
            customerService.saveCustomer(customerDTO);

            SyncLogger.info("Updating appointment customer: " + customerDTO.getId());
            appointmentService.updateAppointmentCustomer(customerDTO);

        } catch (Exception e) {
            SyncLogger.error("Error saving customer: " + e.getMessage());
            SyncLogger.error(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void syncAppointment(FullAppointmentDTO fullAppointmentDTO) {
        try {
            SyncLogger.info("Saving appointment: " + fullAppointmentDTO.getId());
            appointmentService.saveAppointment(fullAppointmentDTO);

        } catch (Exception e) {
            SyncLogger.error("Error saving appointment: " + e.getMessage());
            SyncLogger.error(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void syncBeautyProcedures(BeautyProcedureDTO beautyProcedureDTO) {
        try {
            SyncLogger.info("Saving beauty procedure: " + beautyProcedureDTO.getId());
            beautyProcedureService.saveBeautyProcedure(beautyProcedureDTO);
            
            SyncLogger.info("Updating appointment beauty procedure: " + beautyProcedureDTO.getId());
            appointmentService.updateAppointmentBeautyProcedures(beautyProcedureDTO);

        } catch (Exception e) {
            SyncLogger.error("Error saving beauty procedure: " + e.getMessage());
            SyncLogger.error(Arrays.toString(e.getStackTrace()));
        }
    }

}
