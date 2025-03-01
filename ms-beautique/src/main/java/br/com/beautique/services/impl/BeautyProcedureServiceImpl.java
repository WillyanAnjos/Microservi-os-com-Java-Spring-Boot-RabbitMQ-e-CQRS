package br.com.beautique.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beautique.dtos.BeautyProcedureDTO;
import br.com.beautique.entities.BeautyProceduresEntity;
import br.com.beautique.repositories.BeautyProcedureRepository;
import br.com.beautique.services.BeautyProcedureService;
import br.com.beautique.services.BrokerService;
import br.com.beautique.utils.ConverterUtil;

@Service
public class BeautyProcedureServiceImpl implements BeautyProcedureService {

    @Autowired
    private BeautyProcedureRepository  beautyProcedureRepository;

    @Autowired
    private BrokerService brokenService;

    private final ConverterUtil<BeautyProceduresEntity, BeautyProcedureDTO> converter = 
    new ConverterUtil<>(BeautyProceduresEntity.class, BeautyProcedureDTO.class);

    @Override
    public BeautyProcedureDTO create(BeautyProcedureDTO beautyProcedureDTO) {
        BeautyProceduresEntity beautyProcedureEntity = converter.convertToSource(beautyProcedureDTO);        
        BeautyProceduresEntity newBeautyProcedureEntity = beautyProcedureRepository.save(beautyProcedureEntity);

        // Send beauty procedure to queue
        sendBeautyProcedureToQueue(newBeautyProcedureEntity);

        return converter.convertToTarget(newBeautyProcedureEntity);
    }

    @Override
    public void delete(Long id) {
        Optional<BeautyProceduresEntity> beautyProcedureEntity = beautyProcedureRepository.findById(id);

        if (beautyProcedureEntity.isEmpty()) {
            throw new RuntimeException("Beauty procedure not found");
        }

        beautyProcedureRepository.deleteById(id);
    }

    @Override
    public BeautyProcedureDTO update(BeautyProcedureDTO beautyProcedureDTO) {
        Optional<BeautyProceduresEntity> beautyProcedureEntity = beautyProcedureRepository.findById(beautyProcedureDTO.getId());

        if (beautyProcedureEntity.isEmpty()) {
            throw new RuntimeException("Beauty procedure not found");
        }

        BeautyProceduresEntity beautyProcedureEntityToUpdate = converter.convertToSource(beautyProcedureDTO);
        beautyProcedureEntityToUpdate.setAppointments(beautyProcedureEntity.get().getAppointments());
        beautyProcedureEntityToUpdate.setCreatedAt(beautyProcedureEntity.get().getCreatedAt());

        BeautyProceduresEntity updatedBeautyProcedureEntity = beautyProcedureRepository.save(beautyProcedureEntityToUpdate);

        sendBeautyProcedureToQueue(updatedBeautyProcedureEntity);

        return converter.convertToTarget(updatedBeautyProcedureEntity);
    }

    private void sendBeautyProcedureToQueue(BeautyProceduresEntity beautyProcedureEntity) {
        BeautyProcedureDTO beautyProcedureDTO = converter.convertToTarget(beautyProcedureEntity);

        brokenService.send("beautyProcedures", beautyProcedureDTO);

    }

}
