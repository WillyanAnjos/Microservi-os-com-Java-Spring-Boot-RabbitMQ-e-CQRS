package br.com.beautique.ms_sync.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.beautique.ms_sync.dtos.appointments.FullAppointmentDTO;

public interface AppointmentRepository extends MongoRepository<FullAppointmentDTO, Long>{

}
