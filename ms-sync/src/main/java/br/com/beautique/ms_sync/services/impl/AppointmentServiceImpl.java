package br.com.beautique.ms_sync.services.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import br.com.beautique.ms_sync.dtos.appointments.FullAppointmentDTO;
import br.com.beautique.ms_sync.dtos.beautyprocedures.BeautyProcedureDTO;
import br.com.beautique.ms_sync.dtos.customers.CustomerDTO;
import br.com.beautique.ms_sync.repositories.AppointmentRepository;
import br.com.beautique.ms_sync.services.AppointmentService;
import br.com.beautique.ms_sync.utils.SyncLogger;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveAppointment(FullAppointmentDTO fullAppointmentDTO) {
        try {
            SyncLogger.info("Saving appointment" + fullAppointmentDTO.getId());
            appointmentRepository.save(fullAppointmentDTO);

        } catch (Exception e) {
            SyncLogger.error("Error saving appointment" + e.getMessage());
            SyncLogger.trace(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void updateAppointmentCustomer(CustomerDTO customerDTO) {
        try {
            SyncLogger.info("Updating appointment customer" + customerDTO.getId());
            
            Query query = new Query(Criteria.where("customer.id").is(customerDTO.getId()));
            
            Update update = new Update().set("customer", customerDTO);
            
            mongoTemplate.updateMulti(query, update, FullAppointmentDTO.class);

        } catch (Exception e) {
            SyncLogger.error("Error updating appointment customer" + e.getMessage());
            SyncLogger.trace(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void updateAppointmentBeautyProcedures(BeautyProcedureDTO beautyProcedureDTO) {
        try {
            SyncLogger.info("Updating appointment beauty procedures" + beautyProcedureDTO.getId());

            Query query = new Query(Criteria.where("beautyProcedure.id").is(beautyProcedureDTO.getId()));
            
            Update update = new Update()
                    .set("beautyProcedure.name", beautyProcedureDTO.getName())
                    .set("beautyProcedure.description", beautyProcedureDTO.getDescription());

            mongoTemplate.updateMulti(query, update, FullAppointmentDTO.class);
        } catch (Exception e) {
            SyncLogger.error("Error updating appointment beauty procedures" + e.getMessage());
            SyncLogger.trace(Arrays.toString(e.getStackTrace()));
        }
    }
}
