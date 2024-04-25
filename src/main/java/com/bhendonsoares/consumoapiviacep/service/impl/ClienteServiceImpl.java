package com.bhendonsoares.consumoapiviacep.service.impl;

import com.bhendonsoares.consumoapiviacep.model.Cliente;
import com.bhendonsoares.consumoapiviacep.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Override
    public Iterable<Cliente> buscarClientes() {
        return null;
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return null;
    }

    @Override
    public void inserirCliente(Cliente cliente) {

    }

    @Override
    public void atualizarCliente(Long id, Cliente cliente) {

    }

    @Override
    public void deletarCliente(Long id) {

    }
}
