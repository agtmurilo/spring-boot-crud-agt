package com.spring.crud.demo;

import com.spring.crud.demo.model.emp.Employee;
import com.spring.crud.demo.repository.EmployeeRepository;
import com.spring.crud.demo.utils.UtilityHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

/**
 * Classe principal da aplicação Spring Boot de gerenciamento de funcionários.
 * 
 * @SpringBootApplication - Anotação que combina:
 * - @Configuration: Define a classe como fonte de definições de beans
 * - @EnableAutoConfiguration: Habilita a configuração automática do Spring Boot
 * - @ComponentScan: Habilita a varredura de componentes no pacote atual
 */
@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class SpringBootH2CRUDApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootH2CRUDApplication.class, args);
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Bean
    CommandLineRunner runner() {
        return args -> {
            List<Employee> employees = employeeRepository.findAll();
            if (employees.isEmpty()) {
                log.info("******* Inserting Employees to DB *******");
                employeeRepository.saveAll(UtilityHelper.employeeSupplier.get());
            } else {
                log.info("******* Employees stored in DB Size :: {}", employees.size());
                log.info("******* Employees stored in DB :: {}", employees);
            }
        };
    }
}
