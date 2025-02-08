# Estrutura de Pastas do Projeto

Este projeto segue a arquitetura **MVC (Model-View-Controller)**, garantindo separação de responsabilidades e um código organizado e escalável.

##  Estrutura de Diretórios

```
├── src/main/java/com/empresa/api
│   ├── controller/     # Controladores REST
│   ├── model/          # Modelos/Entidades do domínio
│   ├── repository/     # Acesso ao banco de dados
│   ├── service/        # Regras de negócio
│   ├── exception/      # Tratamento de erros e exceções
│
├── src/test/java/com/empresa/api
│   ├── controller/     # Testes dos controladores
│   ├── service/        # Testes dos serviços
│   ├── repository/     # Testes do repositório
│
├── src/main/resources/
│   ├── application.properties  # Configurações do Quarkus
│   └── import.sql              # Scripts iniciais para o banco
│
└── pom.xml                     # Configurações do Maven e dependências
```

##  Explicação dos Componentes

###  **Controller (`controller/`)
- Camada responsável por expor os **endpoints da API**.
- Recebe as requisições HTTP e encaminha para a **camada de serviço**.
- Exemplo: `ClienteController.java`

###  **Model (`model/`)
- Define as **entidades** que representam os dados do domínio.
- Mapeia tabelas do banco de dados usando **JPA e Hibernate**.
- Exemplo: `Cliente.java`

###  **Repository (`repository/`)
- Camada responsável por **acessar o banco de dados**.
- Utiliza **Hibernate com Panache** para simplificar consultas.
- Exemplo: `ClienteRepository.java`

###  **Service (`service/`)
- Contém a **lógica de negócio** da aplicação.
- Faz a ponte entre o **repositório** e o **controller**.
- Exemplo: `ClienteService.java`

###  **Exception (`exception/`)
- Gerencia **exceções personalizadas** e tratamento de erros.
- Exemplo: `ServicoException.java`

---

##  **Sobre os Testes (`src/test/java/`)
- **Testes de integração** para validar os endpoints da API.
- **Testes unitários** para garantir o funcionamento dos serviços e repositórios.

### Exemplo de teste com RestAssured:
```java
@Test
public void testCriarCliente() {
    given()
        .contentType(ContentType.JSON)
        .body(new Cliente("João", "joao@email.com", "11987654321"))
        .when().post("/clientes")
        .then()
        .statusCode(201);
}
```

---

