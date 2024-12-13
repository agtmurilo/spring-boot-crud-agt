package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.model.emp.Employee;
import com.spring.crud.demo.repository.EmployeeRepository;
import com.spring.crud.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementação do serviço de funcionários.
 * Esta é uma implementação de exemplo contendo apenas o método de listagem.
 * Os demais métodos devem ser implementados conforme necessário.
 * 
 * @Service - Indica que esta classe é um serviço Spring
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    /**
     * Retorna a lista de todos os funcionários cadastrados.
     * Este método serve como exemplo de implementação.
     * 
     * @return Lista de funcionários
     */
    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    // TODO: Implementar os seguintes métodos
    // 1. Employee save(Employee employee) - Salvar novo funcionário
    // 2. Employee findById(int id) - Buscar funcionário por ID
    // 3. Employee update(int id, Employee employee) - Atualizar funcionário
    // 4. void delete(int id) - Remover funcionário
}
