# Penumper API - Gerenciamento de Usuários

Esta é uma API REST desenvolvida em Java com Spring Boot para o gerenciamento simplificado de usuários. O projeto foi construído seguindo rigorosamente os princípios de **SOLID**, **Clean Code** e **TDD**.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.2**
- **Lombok** (Redução de boilerplate)
- **Spring Validation** (Validação de dados)
- **JUnit 5 & Mockito** (Testes Unitários)
- **Maven** (Gerenciamento de dependências)

## 🏗️ Arquitetura e Boas Práticas

O projeto está organizado em camadas para garantir a separação de responsabilidades:
- **Controller**: Exposição dos endpoints REST e tratamento de DTOs.
- **Service**: Implementação das regras de negócio (ex: unicidade de e-mail).
- **Model**: Entidades de domínio.
- **Repository**: Abstração da camada de dados (Interface Segregation).
- **DTO**: Objetos de transferência de dados para validação e segurança.
- **Exception**: Tratamento global de erros e exceções customizadas.

## 🛠️ Como Executar

### Pré-requisitos
- Java 17 instalado
- Maven instalado (ou use o `./mvnw` incluso)

### Passos
1. Clone o repositório ou baixe os arquivos.
2. Navegue até a pasta raiz do projeto:
   ```bash
   cd penumper
   ```
3. Execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```
   A API estará disponível em `http://localhost:8080`.

## 📡 Endpoints da API

### 1. Cadastrar Usuário
- **URL**: `POST /usuarios`
- **Body**:
  ```json
  {
    "nome": "João Silva",
    "email": "joao@email.com"
  }
  ```
- **Sucesso**: `201 Created`
- **Erro**: `400 Bad Request` (validação) ou `409 Conflict` (e-mail duplicado)

### 2. Listar Usuários
- **URL**: `GET /usuarios`
- **Sucesso**: `200 OK` (Retorna lista de usuários)

### 3. Buscar por ID
- **URL**: `GET /usuarios/{id}`
- **Sucesso**: `200 OK`
- **Erro**: `404 Not Found`

## 🧪 Executando Testes

Para rodar os testes unitários e verificar a integridade da aplicação:
```bash
./mvnw test
```

---
Desenvolvido com foco em qualidade e escalabilidade.
