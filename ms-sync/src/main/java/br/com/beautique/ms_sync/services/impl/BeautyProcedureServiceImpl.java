package br.com.beautique.ms_sync.services.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beautique.ms_sync.dtos.beautyprocedures.BeautyProcedureDTO;
import br.com.beautique.ms_sync.repositories.BeautyProcedureRepository;
import br.com.beautique.ms_sync.services.BeautyProcedureService;
import br.com.beautique.ms_sync.utils.SyncLogger;

@Service
public class BeautyProcedureServiceImpl implements BeautyProcedureService {

    @Autowired
    private BeautyProcedureRepository beautyProcedureRepository;

    @Override
    public void saveBeautyProcedure(BeautyProcedureDTO beautyProcedureDTO) {
        try {
            SyncLogger.info("Saving beauty procedure: " + beautyProcedureDTO.getId());
            beautyProcedureRepository.save(beautyProcedureDTO);
        } catch (Exception e) {
            SyncLogger.error("Error saving beauty procedure: " + beautyProcedureDTO.getId());
            SyncLogger.trace(Arrays.toString(e.getStackTrace()));
        }
    }
}
