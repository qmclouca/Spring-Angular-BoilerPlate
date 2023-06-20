package com.qmclouca.springangularboilerplate.rest;

import com.qmclouca.springangularboilerplate.model.entity.Cliente;
import com.qmclouca.springangularboilerplate.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.FOUND)
    public Cliente buscar(@RequestAttribute String nome){
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser nulo ou vazio");
        } else if (repository.findByNome(nome) == null) {
            throw new IllegalArgumentException("O cliente não foi encontrado");
        } else return repository.findByNome(nome);
    }
}
