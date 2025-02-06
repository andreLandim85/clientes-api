package controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.projeto.xpe.model.Cliente;
import static io.restassured.RestAssured.given;

import static com.google.common.base.Predicates.equalTo;

@QuarkusTest
public class ClienteControllerTest {

    @Test
    public void testCriarCliente() {
        Cliente cliente = new Cliente();
        cliente.nome = "João";
        cliente.email = "joao@email.com";
        cliente.celular = "11987654321";

        given()
                .contentType(ContentType.JSON)
                .body(cliente)
                .when().post("/clientes")
                .then()
                .statusCode(201);
    }

    @Test
    public void testListarClientes() {
        given()
                .when().get("/clientes")
                .then()
                .statusCode(200);
    }
}
