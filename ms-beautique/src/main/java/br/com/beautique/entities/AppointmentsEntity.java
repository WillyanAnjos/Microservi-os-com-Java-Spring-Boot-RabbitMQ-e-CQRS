package br.com.beautique.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class AppointmentsEntity extends BaseEntity{

    @Column(nullable = false, updatable = true)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private Boolean appointmentsOpen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = true)
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beauty_procedure_id", nullable = true)
    private BeautyProceduresEntity beautyProcedure;

    public AppointmentsEntity() {
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

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public BeautyProceduresEntity getBeautyProcedure() {
        return beautyProcedure;
    }

    public void setBeautyProcedure(BeautyProceduresEntity beautyProcedure) {
        this.beautyProcedure = beautyProcedure;
    }
}
