package org.projeto.xpe.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.projeto.xpe.model.Cliente;
import org.projeto.xpe.service.ClienteService;

import java.util.List;
import java.util.Optional;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteController {

    @Inject
    ClienteService clienteService;

    @GET
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Optional<Cliente> cliente = clienteService.buscarPorId(id);
        return cliente.map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @GET
    @Path("/nome/{nome}")
    public List<Cliente> buscarPorNome(@PathParam("nome") String nome) {
        return clienteService.buscarPorNome(nome);
    }

    @GET
    @Path("/contar")
    public long contarClientes() {
        return clienteService.contarClientes();
    }

    @POST
    public Response salvar(Cliente cliente) {
        Cliente novoCliente = clienteService.salvar(cliente);
        return Response.status(Response.Status.CREATED).entity(novoCliente).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean deletado = clienteService.deletar(id);
        return deletado ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarCliente(@PathParam("id") Long id, Cliente clienteAtualizado) {
        Cliente cliente = clienteService.atualizarCliente(id, clienteAtualizado);
        return Response.ok(cliente).build();
    }
}

