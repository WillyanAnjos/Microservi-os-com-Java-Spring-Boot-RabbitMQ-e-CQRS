package br.com.beautique.ms_sync.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.beautique.ms_sync.dtos.beautyprocedures.BeautyProcedureDTO;

public interface BeautyProcedureRepository extends MongoRepository<BeautyProcedureDTO, Long>{

}
