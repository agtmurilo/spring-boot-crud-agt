package com.spring.crud.demo.model.emp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidade que representa o endereço de um funcionário.
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
public class Address implements Serializable {

    /**
     * ID único do endereço.
     * @Id - Marca o campo como chave primária
     * @GeneratedValue - Configura a geração automática de valores
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * Endereço da rua.
     * @Column - Especifica o nome da coluna no banco de dados
     */
    @Column(name = "street_address")
    private String streetAddress;
    
    /**
     * Cidade.
     */
    private String city;

    /**
     * Estado.
     */
    private String state;

    /**
     * País.
     */
    private String country;

    /**
     * Código postal.
     */
    @Column(name = "postal_address")
    private String postalCode;

    /**
     * Funcionário associado a este endereço.
     * @JsonBackReference - Controla a serialização para evitar loops infinitos
     * @OneToOne - Define relacionamento um-para-um com Employee
     */
    @JsonBackReference
    @OneToOne(mappedBy = "address", 
        cascade = { 
            CascadeType.MERGE,
            CascadeType.PERSIST
        })
    private Employee employee;
}