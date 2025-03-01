package br.com.ms_beautique_query.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ms_beautique_query.dtos.beautyprocedures.BeautyProcedureDTO;
import br.com.ms_beautique_query.repositories.BeautyProcedureRepository;
import br.com.ms_beautique_query.services.BeautyProcedureService;

@Service
public class BeautyProcedureServiceImpl implements BeautyProcedureService{

    private final BeautyProcedureRepository beautyProcedureRepository;

    public BeautyProcedureServiceImpl(BeautyProcedureRepository beautyProcedureRepository) {
        this.beautyProcedureRepository = beautyProcedureRepository;
    }

    @Override
    public List<BeautyProcedureDTO> listAllBeautyProcedures() {
        try {
            return beautyProcedureRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error on list all beauty procedures", e);
        }
    }

    @Override
    public List<BeautyProcedureDTO> listByNameIgnoreCase(String name) {
        try {
            return beautyProcedureRepository.findByNameIgnoreCase(name);
        } catch (Exception e) {
            throw new RuntimeException("Error on list beauty procedures by name", e);
        }
    }

    @Override
    public List<BeautyProcedureDTO> listByDescriptionIgnoreCase(String description) {
        try {
            return beautyProcedureRepository.findByDescriptionIgnoreCase(description);
        } catch (Exception e) {
            throw new RuntimeException("Error on list beauty procedures by description", e);
        }
    }

}
