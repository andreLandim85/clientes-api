package org.projeto.xpe.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.projeto.xpe.exception.ServicoException;
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

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        Cliente clienteExistente = clienteRepository.findById(id);
        if (clienteExistente == null) {
            throw new ServicoException("CLIENTE_NAO_ENCONTRADO", "Cliente não encontrado", Response.Status.NOT_FOUND);
        }
        clienteExistente.nome = clienteAtualizado.nome;
        clienteExistente.email = clienteAtualizado.email;
        clienteExistente.celular = clienteAtualizado.celular;
        clienteRepository.persist(clienteExistente);
        return clienteExistente;
    }
}