package br.com.ms_beautique_query.services;

import java.util.List;

import br.com.ms_beautique_query.dtos.beautyprocedures.BeautyProcedureDTO;

public interface BeautyProcedureService {

    List<BeautyProcedureDTO> listAllBeautyProcedures();
    List<BeautyProcedureDTO> listByNameIgnoreCase(String name);
    List<BeautyProcedureDTO> listByDescriptionIgnoreCase(String description);

}
