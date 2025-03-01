package br.com.beautique.services;

public interface BrokerService {
    public void send(String type, Object message);
}
