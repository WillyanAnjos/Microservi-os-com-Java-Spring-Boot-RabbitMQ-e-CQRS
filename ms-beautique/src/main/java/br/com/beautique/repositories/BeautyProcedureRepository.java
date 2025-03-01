package br.com.beautique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.beautique.entities.BeautyProceduresEntity;

@Repository
public interface BeautyProcedureRepository extends JpaRepository<BeautyProceduresEntity, Long> {}
