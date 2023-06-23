package com.qmclouca.springangularboilerplate.controllers;

import com.qmclouca.springangularboilerplate.model.entity.Cliente;
import com.qmclouca.springangularboilerplate.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository repository;
    @Autowired
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Cliente> getClienteByNome(@RequestParam String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser nulo ou vazio");
        }

        Cliente cliente = repository.findByNome(nome);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("O id do cliente não pode ser nulo");
        }
        Cliente cliente = repository.findById(id).orElse(null);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente clienteAtual = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado com o ID: " + id));

        if (cliente.getNome() != null) {
            clienteAtual.setNome(cliente.getNome());
        }

        if (cliente.getCpf() != null) {
            clienteAtual.setCpf(cliente.getCpf());
        }

        if (cliente.getNome() != null || cliente.getCpf() != null) {
            clienteAtual.setDataAlteracao(LocalDateTime.now());
        }
        repository.save(clienteAtual);
    }
}
