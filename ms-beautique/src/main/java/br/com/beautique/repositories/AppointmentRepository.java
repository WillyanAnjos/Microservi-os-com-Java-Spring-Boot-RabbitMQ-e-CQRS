package br.com.beautique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.beautique.entities.AppointmentsEntity;

public interface AppointmentRepository extends JpaRepository<AppointmentsEntity, Long>{

}
