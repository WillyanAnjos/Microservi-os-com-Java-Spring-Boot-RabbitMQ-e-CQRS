package br.com.beautique.ms_sync.listeners;

public interface ListenerConfig {

    void listenToCustomerQueue(String message);

    void listenToAppointmentQueue(String message);
    
    void listenToBeautyProcedureQueue(String message);
}
