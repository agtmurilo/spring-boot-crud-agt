package com.spring.crud.demo.utils;

import com.spring.crud.demo.model.emp.Address;
import com.spring.crud.demo.model.emp.Employee;
import com.spring.crud.demo.model.emp.PhoneNumber;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class UtilityHelper {

    private UtilityHelper() {
    }

    public static Supplier<List<Employee>> employeeSupplier = () -> {
        Employee carlos = Employee.builder()
                .id(1)
                .firstName("Carlos")
                .lastName("Silva")
                .age(30)
                .noOfChildren(0)
                .spouse(true)
                .address(Address.builder()
                        .id(1)
                        .streetAddress("Avenida Paulista")
                        .city("São Paulo")
                        .state("São Paulo")
                        .country("Brasil")
                        .postalCode("01310-000")
                        .build()
                )
                .hobbies(Arrays.asList("Viagens", "Esportes"))
                .build();

        PhoneNumber carlosNumber = PhoneNumber.builder()
                .id(1)
                .type("Celular")
                .number("912345678")
                .employee(carlos)
                .build();

        carlos.setPhoneNumbers(Arrays.asList(carlosNumber));

        Employee renato = Employee.builder()
                .id(2)
                .firstName("Renato")
                .lastName("Mendes")
                .age(28)
                .noOfChildren(0)
                .spouse(true)
                .address(Address.builder()
                        .id(2)
                        .streetAddress("Rua das Palmeiras")
                        .city("Rio de Janeiro")
                        .state("Rio de Janeiro")
                        .country("Brasil")
                        .postalCode("20021-140")
                        .build()
                )
                .hobbies(Arrays.asList("Dança", "Futebol"))
                .build();

        PhoneNumber renatoNumber = PhoneNumber.builder()
                .id(2)
                .type("Celular")
                .number("999111555")
                .employee(renato)
                .build();

        renato.setPhoneNumbers(Arrays.asList(renatoNumber));

        return Arrays.asList(carlos, renato);
    };
}
