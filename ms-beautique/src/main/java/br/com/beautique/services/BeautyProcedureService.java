package br.com.beautique.services;

import br.com.beautique.dtos.BeautyProcedureDTO;

public interface BeautyProcedureService {

    BeautyProcedureDTO create(BeautyProcedureDTO beautyProcedureDTO);

    void delete(Long id);

    BeautyProcedureDTO update(BeautyProcedureDTO beautyProcedureDTO);
}
