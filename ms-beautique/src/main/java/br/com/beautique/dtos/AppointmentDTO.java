package br.com.beautique.dtos;

import java.time.LocalDateTime;

public class AppointmentDTO {

    private Long id;

    private LocalDateTime dateTime;

    private Boolean appointmentsOpen;

    private Long customer;
    private Long beautyProcedure;

    public AppointmentDTO() {
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
    public Long getCustomer() {
        return customer;
    }
    public void setCustomer(Long customer) {
        this.customer = customer;
    }
    public Long getBeautyProcedure() {
        return beautyProcedure;
    }
    public void setBeautyProcedure(Long beautyProcedure) {
        this.beautyProcedure = beautyProcedure;
    }


}
