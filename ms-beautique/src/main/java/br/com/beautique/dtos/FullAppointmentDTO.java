package br.com.beautique.dtos;

import java.time.LocalDateTime;

public class FullAppointmentDTO {

    private Long id;
    private LocalDateTime dateTime;
    private Boolean appointmentsOpen;

    private CustomerDTO customer;
    private BeautyProcedureDTO beautyProcedure;

    public FullAppointmentDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
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

    public BeautyProcedureDTO getBeautyProcedure() {
        return beautyProcedure;
    }

    public void setBeautyProcedure(BeautyProcedureDTO beautyProcedure) {
        this.beautyProcedure = beautyProcedure;
    }
}
