
---

# Projeto de API REST para Registro de Atendimentos

Este projeto é uma API REST desenvolvida em Spring Boot 3.3 e Java 17, utilizando MySQL como banco de dados e Docker para containerização. O sistema é destinado ao registro de atendimentos realizados por empresas que prestam serviços via chamada telefônica, além de gerenciar usuários, clientes, contratos e fila de espera.

## Tecnologias Utilizadas

- **Spring Boot 3.3**
- **Java 17**
- **MySQL**
- **Docker**
- **Gradle**

## Funcionalidades

- Gerenciamento de Usuários
- Gerenciamento de Clientes
- Gerenciamento de Contratos
- Gerenciamento de Fila de Espera
- Registro de Atendimentos

## Requisitos

- Java 17
- Gradle
- Docker
- Docker Compose

## Instalação

1. Clone o repositório:
    ```bash
    git clone https://github.com/pabloMlima/suport_hub_service_api.git
    ```
2. Navegue até o diretório do projeto:
    ```bash
    cd suport_hub_service
    ```
3. Construa o projeto usando Gradle:
    ```bash
    ./gradlew build
    ```

## Configuração do Banco de Dados

Certifique-se de ter o MySQL instalado e em execução. Crie um banco de dados com o nome `suport_hub_service` e configure as credenciais de acesso no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/suport_hub_service
spring.datasource.username=suport_user
spring.datasource.password=suport_pass
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
```

## Executando a Aplicação com Docker

1. Construa a imagem Docker:
    ```bash
    docker build -t suport_hub_service .
    ```
2. Inicie os containers usando Docker Compose:
    ```bash
    docker-compose up
    ```

## Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas alterações (`git commit -am 'Adiciona nova feature'`)
4. Faça o push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

[linkedin](linkedin.com/in/pablo-machado-lima-42820a194)

Link do Projeto: [https://github.com/pabloMlima/suport_hub_service_api](https://github.com/pabloMlima/suport_hub_service_api)

---

