package br.com.ms_beautique_query.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.ms_beautique_query.dtos.appointments.FullAppointmentDTO;

public interface AppointmentRepository extends MongoRepository<FullAppointmentDTO, Long>{

    @Query("{ 'customerId' : ?0 }")
    List<FullAppointmentDTO> listAppointmentByCustomerId(Long customerId);
    
    @Query("{ 'beautyProcedureId' : ?0 }")
    List<FullAppointmentDTO> listAppointmentByBeautyProcedureId(Long beautyProcedureId);
}
