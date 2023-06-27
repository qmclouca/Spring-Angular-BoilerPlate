package com.qmclouca.springangularboilerplate.application.controllers;

import com.qmclouca.springangularboilerplate.domain.model.entities.Client;
import com.qmclouca.springangularboilerplate.infrastructure.persistence.repository.ClientRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RestController
@ComponentScan
@RequestMapping("/api/clientes")
public class ClientController {

    private final ClientRepository clienteRepository;

    @Autowired
    public ClientController(ClientRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Operation(summary = "Cria um novo cliente")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client salvar(@RequestBody Client client) {
        return clienteRepository.save(client);
    }

    @Operation(summary = "Atualiza um cliente existente")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Client> getClienteByNome(@RequestParam String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser nulo ou vazio");
        }

        Client client = clienteRepository.findByNome(nome);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @Operation(summary = "Retorna um cliente pelo seu id")
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Client>> getClienteById(@PathVariable Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("O id do cliente não pode ser nulo");
        }
        Optional<Client> client = clienteRepository.findById(id);
        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @Operation(summary="Deleta um cliente pelo seu id")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        clienteRepository.deleteById(id);
    }
}
