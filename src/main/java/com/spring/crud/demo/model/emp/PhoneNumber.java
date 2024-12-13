package com.spring.crud.demo.model.emp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidade que representa um número de telefone de um funcionário.
 * 
 * @Entity - Indica que esta classe é uma entidade JPA
 * @Table - Define o nome da tabela no banco de dados
 * @Getter @Setter - Gera automaticamente getters e setters via Lombok
 * @NoArgsConstructor - Gera construtor sem argumentos via Lombok
 * @AllArgsConstructor - Gera construtor com todos os argumentos via Lombok
 * @Builder - Implementa o padrão Builder via Lombok
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class PhoneNumber implements Serializable {

    /**
     * ID único do número de telefone.
     * @Id - Marca o campo como chave primária
     * @GeneratedValue - Configura a geração automática de valores
     */
    @Id
    @GeneratedValue
    private int id;
    
    /**
     * Tipo do telefone (ex: residencial, celular, comercial).
     */
    private String type;

    /**
     * Número do telefone.
     */
    private String number;

    /**
     * Funcionário associado a este número de telefone.
     * @JsonBackReference - Controla a serialização para evitar loops infinitos
     * @ManyToOne - Define relacionamento muitos-para-um com Employee
     */
    @JsonBackReference
    @ManyToOne(cascade = { 
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinColumn(name="employee_id")
    private Employee employee;
}