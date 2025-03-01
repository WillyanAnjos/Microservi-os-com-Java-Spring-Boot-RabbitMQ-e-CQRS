package br.com.ms_beautique_query.dtos.appointments;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.ms_beautique_query.dtos.beautyprocedures.BeautyProcedureDTO;
import br.com.ms_beautique_query.dtos.customers.CustomerDTO;

@Document(collection = "appointments")
public class FullAppointmentDTO {

    private Long id;
    private LocalDate dateTime;
    private Boolean appointmentsOpen;

    private CustomerDTO customer;
    private BeautyProcedureDTO beautyProcedureDTO;

    public FullAppointmentDTO() {}

    public FullAppointmentDTO(Long id, LocalDate dateTime, Boolean appointmentsOpen, CustomerDTO customer, BeautyProcedureDTO beautyProcedureDTO) {
        this.id = id;
        this.dateTime = dateTime;
        this.appointmentsOpen = appointmentsOpen;
        this.customer = customer;
        this.beautyProcedureDTO = beautyProcedureDTO;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }
    public Boolean getAppointmentsOpen() {
        return appointmentsOpen;
    }
    public void setAppointmentsOpen(Boolean appointmentsOpen) {
        this.appointmentsOpen = appointmentsOpen;
    }
    public CustomerDTO getCustomer() {
        return customer;
    }
    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
    public BeautyProcedureDTO getBeautyProcedureDTO() {
        return beautyProcedureDTO;
    }
    public void setBeautyProcedureDTO(BeautyProcedureDTO beautyProcedureDTO) {
        this.beautyProcedureDTO = beautyProcedureDTO;
    }
}
