# API Produtos

Um exercício simples de REST API com Spring Boot para gerenciamento de um catálogo de produtos. O projeto utiliza uma lista em memória para realizar operações básicas de CRUD, sem a necessidade de um banco de dados externo.

Integrantes: Patrícia e Ray Dias.

## Funcionalidades

A aplicação expõe um controlador REST mapeado para `/api/produtos`. Os endpoints disponíveis são:

* **GET `/api/produtos**`: Retorna a lista completa de produtos.
* **GET `/api/produtos/destaque**`: Filtra e retorna apenas os produtos que estão marcados como destaque.
* **GET `/api/produtos/{id}**`: Retorna um produto específico pelo seu ID numérico.
* **GET `/api/produtos/{id}/descricao**`: Retorna uma mensagem de texto simples confirmando a consulta das informações do produto especificado.
* **POST `/api/produtos**`: Adiciona um novo produto à lista e atribui a ele um ID gerado automaticamente.
* **PUT `/api/produtos/{id}**`: Atualiza o nome de um produto existente com base no ID fornecido.
* **DELETE `/api/produtos/{id}**`: Remove um produto da lista pelo seu ID.

## Modelo de Dados

A aplicação utiliza uma entidade básica definida em `Produto.java`. Cada produto é composto por:

* `id` (Integer)
* `nome` (String)
* `categoria` (String)
* `preco` (Double)
* `destaque` (boolean)

## Estrutura do Projeto

* `ApiProdutosApplication.java`: A classe principal do Spring Boot usada para inicializar o projeto.
* `ProdutoController.java`: O controlador REST responsável por lidar com as requisições HTTP e gerenciar a lista (`ArrayList`) de produtos em memória.
* `Produto.java`: O modelo de dados contendo os atributos do produto, construtores e os métodos getters/setters.

## Como Executar

1. Clone ou baixe o repositório.
2. Certifique-se de ter o Java Development Kit (JDK) instalado.
3. Execute a classe `ApiProdutosApplication.java` diretamente da sua IDE, ou inicie a aplicação via Maven usando o comando `mvn spring-boot:run`.
4. Teste os endpoints utilizando uma ferramenta como Postman, cURL ou o seu próprio navegador acessando 