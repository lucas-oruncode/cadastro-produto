# Cadastro de Produtos

## Descrição
Esta é uma API para gerenciamento de produtos, permitindo o cadastro, listagem, atualização e remoção de produtos. 

## Tecnologias Utilizadas
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Hibernate**
- **React**
- **Bootstrap**

## Configuração do Banco de Dados
Antes de iniciar a API, configure um banco de dados MySQL e ajuste as credenciais no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

## Como Executar o Projeto
1. Clone este repositório:
   ```sh
   git clone https://github.com/lucas-oruncode/api_produto.git
   ```
2. Acesse a pasta do projeto:
   ```sh
   cd nome-do-repositorio
   ```
3. Compile e execute a aplicação:
   ```sh
   mvn spring-boot:run
   ```

   ### Executando o Frontend 
4.  Acesse o diretório frontend:
   ```sh
   cd frontend
   ```
5.  Instalando as dependências:
   ```sh
   npm install
   ```
6.  Execute o comando:
   ```sh
   npm start
   ```

## Endpoints da API

### 1. Criar um novo produto
**POST** `/api/produtos`
#### Exemplo de requisição:
```json
{
  "nome": "Teclado",
  "marca": "Logitech"
}
```

### 2. Listar todos os produtos
**GET** `/api/produtos`

### 3. Atualizar um produto
**PUT** `/api/produtos/`
#### Exemplo de requisição:
```json
{
  "id": 1,
  "nome": "Teclado",
  "marca": "Logitech"
}
```

### 4. Remover um produto
**DELETE** `/api/produtos/{id}`
