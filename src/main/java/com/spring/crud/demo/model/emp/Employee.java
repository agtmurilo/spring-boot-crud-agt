package com.spring.crud.demo.model.emp;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade que representa um funcionário no sistema.
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
public class Employee implements Serializable {

    /**
     * ID único do funcionário.
     * @Id - Marca o campo como chave primária
     * @GeneratedValue - Configura a geração automática de valores
     */
    @Id
    @GeneratedValue
    private int id;
    
    /**
     * Nome do funcionário.
     * @Column - Especifica o nome da coluna no banco de dados
     */
    @Column(name = "first_name")
    private String firstName;
    
    /**
     * Sobrenome do funcionário.
     */
    @Column(name = "last_name")
    private String lastName;
    
    /**
     * Idade do funcionário.
     */
    private int age;

    /**
     * Número de filhos do funcionário.
     */
    @Column(name = "no_of_children")
    private int noOfChildren;
    
    /**
     * Indica se o funcionário é casado.
     */
    private boolean spouse;

    /**
     * Endereço do funcionário.
     * @JsonManagedReference - Controla a serialização para evitar loops infinitos
     * @OneToOne - Define relacionamento um-para-um com Address
     */
    @JsonManagedReference
    @OneToOne(cascade = { 
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinColumn(name = "address")
    private Address address;

    /**
     * Lista de telefones do funcionário.
     * @JsonManagedReference - Controla a serialização para evitar loops infinitos
     * @OneToMany - Define relacionamento um-para-muitos com PhoneNumber
     */
    @JsonManagedReference
    @OneToMany(
        fetch = FetchType.LAZY, 
        mappedBy = "employee",
        cascade = { 
            CascadeType.MERGE,
            CascadeType.PERSIST
        }
    )
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    /**
     * Lista de hobbies do funcionário.
     * @ElementCollection - Indica uma coleção de elementos simples
     * @CollectionTable - Define a tabela para armazenar a coleção
     */
    @ElementCollection
    @CollectionTable(name = "hobbies", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "hobby")
    private List<String> hobbies = new ArrayList<>();
}
