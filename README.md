# Consumo da API ViaCEP
Repositório de uma API Rest desenvolvida com Java e Spring Boot que realiza o cadastro de um cliente e o seu endereço no banco de dados **H2**, também possui as funcionalidades de listagem de clientes, atualização e exclusão de um cliente.
Esta API também faz o consumo da API [ViaCEP](https://viacep.com.br/), que é um webservice gratuito para realizar consultas de Código de Endereçamento Postal (CEP) do Brasil.
Com o consumo desta API, pode-se obter todos os dados de endereço do cliente apenas consultando o seu CEP.

## Design Patterns
Neste projeto também tive a oportunidade explorar alguns padrões de projeto sendo eles:
- Singleton
- Strategy
- Facade

## Tecnologias utilizadas:
- Java: Linguagem de programação principal.
- Spring Boot: Framework para o desenvolvimento de aplicações Java.
- H2 Database: Banco de dados relacional para armazenar as informações de clientes e seus respectivos endereços.
- Swagger: Serviço para documentar e consumir a API.