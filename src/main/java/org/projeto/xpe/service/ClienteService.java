package org.projeto.xpe.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.projeto.xpe.model.Cliente;
import org.projeto.xpe.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.listAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findByIdOptional(id);
    }

    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.buscarPorNome(nome);
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        clienteRepository.persist(cliente);
        return cliente;
    }

    public boolean deletar(Long id) {
        return clienteRepository.deleteById(id);
    }

    public long contarClientes() {
        return clienteRepository.count();
    }
}