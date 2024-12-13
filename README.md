# Desafio Técnico AGT

Este é um projeto Spring Boot que demonstra operações CRUD (Create, Read, Update, Delete) utilizando JPA com banco de dados H2 em memória.

## Desafio

Desenvolver uma API REST com as seguintes funcionalidades:

1. Implementar endpoints para operações CRUD:
   - Criar novo registro (json body)
   - Consultar registros (by id)
   - Atualizar registro existente (by id)
   - Deletar registro (by id)

2. Utilizar:
   - Spring Boot
   - JPA para persistência de dados
   - Banco de dados H2 em memória
   - Documentação da API com Swagger

## Como Executar o Projeto

1. Clone o repositório
2. Execute o projeto usando Maven:
   ```bash
   mvn spring-boot:run
   ```
3. O servidor será iniciado na porta 9010

## Documentação da API (Swagger)

A documentação completa da API está disponível através do Swagger UI:

- URL: http://localhost:9010/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

Através do Swagger UI, você pode:
- Visualizar todos os endpoints disponíveis
- Testar as operações diretamente pela interface
- Ver os modelos de dados e parâmetros necessários
- Executar requisições e ver as respostas

## Banco de Dados

O projeto utiliza o banco de dados H2 em memória. As configurações podem ser encontradas no arquivo `application.properties`.

- Console do H2: http://localhost:9010/h2-console
- JDBC URL: jdbc:h2:mem:sampledb
- Usuário: sa
- Senha: password
