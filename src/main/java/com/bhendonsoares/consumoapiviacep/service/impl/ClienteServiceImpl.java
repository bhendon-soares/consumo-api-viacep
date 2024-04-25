package com.bhendonsoares.consumoapiviacep.service.impl;

import com.bhendonsoares.consumoapiviacep.model.Cliente;
import com.bhendonsoares.consumoapiviacep.model.Endereco;
import com.bhendonsoares.consumoapiviacep.repository.ClienteRepository;
import com.bhendonsoares.consumoapiviacep.repository.EnderecoRepository;
import com.bhendonsoares.consumoapiviacep.service.ClienteService;
import com.bhendonsoares.consumoapiviacep.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserirCliente(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizarCliente(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if(clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        //Verificar se o endereço do cliente já existe pelo CEP, caso contrário cria um novo endereço
        String cep = cliente.getEndereco().getCep();

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
           Endereco novoEndereco = viaCepService.consultarCep(cep);
           enderecoRepository.save(novoEndereco);
           return novoEndereco;
        });

        cliente.setEndereco(endereco);

        //Salva o cliente no banco de dados vinculando o novo endereço (novo ou já existente)
        clienteRepository.save(cliente);
    }
}
