# Microserviços com Java, Spring Boot, RabbitMQ e CQRS

Este repositório apresenta uma arquitetura baseada em microserviços utilizando Java, Spring Boot e RabbitMQ, seguindo o padrão CQRS (Command Query Responsibility Segregation). O objetivo é otimizar a performance e escalabilidade da aplicação ao separar as operações de escrita e leitura em diferentes serviços.

## Tecnologias Utilizadas
- **Java 22+**
- **Spring Boot**
- **RabbitMQ** (Mensageria e comunicação entre serviços)
- **MongoDB** (Banco de dados NoSQL para leitura)
- **PostgreSQL** (Banco de dados relacional para escrita)
- **Flyway** (Versionamento e migração de banco de dados)
- **ModelMapper** (Mapeamento de objetos DTO para entidades)

## Arquitetura CQRS
O projeto é dividido em três microserviços principais:

### 1. `ms-beautique` - Command Service
- Responsável pelo cadastro e manipulação dos dados no **PostgreSQL**.
- Publica eventos no **RabbitMQ** após uma operação de escrita.

### 2. `ms-sync` - Data Synchronization Service
- Escuta as mensagens enviadas pelo **RabbitMQ**.
- Replica os dados recebidos para o **MongoDB**.

### 3. `ms-beautique-query` - Query Service
- Consome os dados diretamente do **MongoDB**, otimizando a performance de leitura.

## Configuração do Ambiente
Antes de iniciar os serviços, crie as seguintes pastas no servidor para armazenamento de dados:
```
mkdir rabbitmq-data rabbitmq-log db-beautique db-mongodb
```

## Motivação para a Utilização do MongoDB para Leitura
A separação entre PostgreSQL (escrita) e MongoDB (leitura) segue os princípios do **CQRS**, trazendo vantagens como:
- **Melhor desempenho em consultas**, uma vez que o MongoDB permite acessar os dados sem necessidade de complexos joins.
- **Escalabilidade**, facilitando a distribuição da carga de leitura e escrita.
- **Segregação de responsabilidades**, garantindo que cada banco de dados seja utilizado de acordo com suas melhores capacidades.