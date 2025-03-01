package br.com.ms_beautique_query.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.ms_beautique_query.dtos.beautyprocedures.BeautyProcedureDTO;

public interface BeautyProcedureRepository extends MongoRepository<BeautyProcedureDTO, Long>{

    @Query("{ 'name' : { $regex: ?0, $options: 'i' } }")
    List<BeautyProcedureDTO> findByNameIgnoreCase(String name);

    @Query("{ 'description' : { $regex: ?0, $options: 'i' } }")
    List<BeautyProcedureDTO> findByDescriptionIgnoreCase(String description);}