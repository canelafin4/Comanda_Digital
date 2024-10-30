package com.ibeus.Comanda.Digital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibeus.Comanda.Digital.model.Cliente;
import com.ibeus.Comanda.Digital.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(int id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setUserId((long) id);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public void delete(int id) {
        clienteRepository.deleteById(id);
    }
}