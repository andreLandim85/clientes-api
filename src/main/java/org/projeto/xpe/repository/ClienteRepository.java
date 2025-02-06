package org.projeto.xpe.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.projeto.xpe.model.Cliente;

import java.util.List;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {
    public List<Cliente> buscarPorNome(String nome) {
        return find("nome", nome).list();
    }
}