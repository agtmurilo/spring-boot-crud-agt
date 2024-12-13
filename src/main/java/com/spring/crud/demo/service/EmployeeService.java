package com.spring.crud.demo.service;

import com.spring.crud.demo.model.emp.Employee;
import java.util.List;

/**
 * Interface de serviço para operações com funcionários.
 * Esta é uma interface de exemplo contendo apenas o método de listagem.
 * Os demais métodos devem ser implementados conforme necessário.
 */
public interface EmployeeService {
    
    /**
     * Retorna a lista de todos os funcionários cadastrados.
     * Este método serve como exemplo de implementação.
     * 
     * @return Lista de funcionários
     */
    List<Employee> findAll();

    // TODO: Implementar os seguintes métodos
    // 1. Employee save(Employee employee) - Salvar novo funcionário
    // 2. Employee findById(int id) - Buscar funcionário por ID
    // 3. Employee update(int id, Employee employee) - Atualizar funcionário
    // 4. void delete(int id) - Remover funcionário
}
