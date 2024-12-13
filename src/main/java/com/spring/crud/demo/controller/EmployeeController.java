package com.spring.crud.demo.controller;

import com.spring.crud.demo.annotation.LogObjectAfter;
import com.spring.crud.demo.model.emp.Employee;
import com.spring.crud.demo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST responsável por gerenciar as operações de funcionários.
 * Este é um exemplo de implementação contendo apenas o endpoint de listagem.
 * Os demais endpoints (criar, atualizar, buscar por id e deletar) devem ser implementados conforme necessário.
 * 
 * @RestController - Indica que esta classe é um controlador REST
 * @RequestMapping - Define o caminho base para todas as operações
 * @Tag - Anotação do Swagger para documentação da API
 */
@RestController
@RequestMapping("/employees")
@Tag(name = "Funcionários", description = "API para gerenciamento de funcionários")
public class EmployeeController {

    private final EmployeeService service;

    /**
     * Construtor que injeta o serviço de funcionários.
     * @param service Serviço de funcionários
     */
    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    /**
     * Retorna a lista de todos os funcionários cadastrados.
     * Este endpoint serve como exemplo de implementação.
     * 
     * @Operation - Documentação Swagger da operação
     * @LogObjectAfter - Registra o objeto retornado
     * @return ResponseEntity com a lista de funcionários
     */
    @Operation(summary = "Listar todos os funcionários")
    @LogObjectAfter
    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // TODO: Implementar os seguintes endpoints
    // 1. POST /employees - Criar novo funcionário
    // 2. GET /employees/{id} - Buscar funcionário por ID
    // 3. PUT /employees/{id} - Atualizar funcionário
    // 4. DELETE /employees/{id} - Remover funcionário
}
