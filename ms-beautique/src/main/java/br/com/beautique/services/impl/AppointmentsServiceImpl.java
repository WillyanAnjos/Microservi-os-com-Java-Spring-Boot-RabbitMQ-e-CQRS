package br.com.beautique.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beautique.dtos.AppointmentDTO;
import br.com.beautique.dtos.BeautyProcedureDTO;
import br.com.beautique.dtos.CustomerDTO;
import br.com.beautique.dtos.FullAppointmentDTO;
import br.com.beautique.entities.AppointmentsEntity;
import br.com.beautique.entities.BeautyProceduresEntity;
import br.com.beautique.entities.CustomerEntity;
import br.com.beautique.repositories.AppointmentRepository;
import br.com.beautique.repositories.BeautyProcedureRepository;
import br.com.beautique.repositories.CustomerRepository;
import br.com.beautique.services.AppointmentsService;
import br.com.beautique.services.BrokerService;
import br.com.beautique.utils.ConverterUtil;

@Service
public class AppointmentsServiceImpl implements AppointmentsService {

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private BrokerService brokerService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private BeautyProcedureRepository beautyProcedureRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private final ConverterUtil<AppointmentsEntity, AppointmentDTO> converter = new ConverterUtil<>(
            AppointmentsEntity.class, AppointmentDTO.class);

    @Override
    public AppointmentDTO create(AppointmentDTO appointmentDTO) {
        AppointmentsEntity appointmentEntity = converter.convertToSource(appointmentDTO);
        AppointmentsEntity newAppointmentsEntity = appointmentRepository.save(appointmentEntity);

        sendAppointmentToQueue(newAppointmentsEntity);

        return converter.convertToTarget(newAppointmentsEntity);
    }

    @Override
    public AppointmentDTO update(AppointmentDTO appointmentDTO) {
        Optional<AppointmentsEntity> currentAppointmentEntity = appointmentRepository.findById(appointmentDTO.getId());
        if(currentAppointmentEntity.isEmpty()) {
            throw new RuntimeException("Appointment not found");
        } 

        AppointmentsEntity appointmentEntity = converter.convertToSource(appointmentDTO);
        appointmentEntity.setCreatedAt(currentAppointmentEntity.get().getCreatedAt());
        AppointmentsEntity updatedAppointmentEntity = appointmentRepository.save(appointmentEntity);

        sendAppointmentToQueue(updatedAppointmentEntity);

        return converter.convertToTarget(updatedAppointmentEntity);
    }

    private void sendAppointmentToQueue(AppointmentsEntity appointmentEntity) {
        CustomerDTO customerDTO = appointmentEntity.getCustomer() != null ? modelMapper.map(appointmentEntity.getCustomer(), CustomerDTO.class) : null;
        BeautyProcedureDTO beautyProcedureDTO = appointmentEntity.getBeautyProcedure() != null ? modelMapper.map(appointmentEntity.getBeautyProcedure(), BeautyProcedureDTO.class) : null;
    
        FullAppointmentDTO fullAppointmentDTO = new FullAppointmentDTO();
        fullAppointmentDTO.setId(appointmentEntity.getId());
        fullAppointmentDTO.setDateTime(appointmentEntity.getDateTime());
        fullAppointmentDTO.setAppointmentsOpen(appointmentEntity.getAppointmentsOpen());
        fullAppointmentDTO.setCustomer(customerDTO);
        fullAppointmentDTO.setBeautyProcedure(beautyProcedureDTO);

      
        brokerService.send("appointments", fullAppointmentDTO);
    }

    @Override
    public void delete(Long id) {
        AppointmentsEntity appointmentsEntity = appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointmentRepository.delete(appointmentsEntity);
    }

    @Override
    public AppointmentDTO setCustomerToAppointment(AppointmentDTO appointment) {
        CustomerEntity customerEntity = findCustomerById(appointment.getCustomer());
        BeautyProceduresEntity beautyProceduresEntity = findBeautyProceduresEntityById(appointment.getBeautyProcedure());

        AppointmentsEntity appointmentEntity = findAppointmentById(appointment.getId());
        appointmentEntity.setCustomer(customerEntity);
        appointmentEntity.setBeautyProcedure(beautyProceduresEntity);
        appointmentEntity.setAppointmentsOpen(false);

        AppointmentsEntity updatedAppointmentEntity = appointmentRepository.save(appointmentEntity);

        sendAppointmentToQueue(updatedAppointmentEntity);

        return buildAppointmentDTO(updatedAppointmentEntity);
    }

    private AppointmentsEntity findAppointmentById(Long id) {
        return appointmentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    private BeautyProceduresEntity findBeautyProceduresEntityById(Long id) {
        return beautyProcedureRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Beauty Procedure not found"));
    }

    private CustomerEntity findCustomerById(Long id) {
        return customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    private AppointmentDTO buildAppointmentDTO(AppointmentsEntity appointmentEntity) {

        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setId(appointmentEntity.getId());
        appointmentDTO.setBeautyProcedure(appointmentEntity.getBeautyProcedure().getId());
        appointmentDTO.setDateTime(appointmentEntity.getDateTime());
        appointmentDTO.setAppointmentsOpen(appointmentEntity.getAppointmentsOpen());
        appointmentDTO.setCustomer(appointmentEntity.getCustomer().getId());
    
        return appointmentDTO;
    }

}
