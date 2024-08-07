
# Projeto de API de Pedidos

Este projeto é uma API RESTful desenvolvida em Java 17 utilizando Spring Boot. A API permite a recepção, armazenamento e consulta de pedidos de clientes. Os pedidos podem ser enviados em formato JSON ou XML e são armazenados em um banco de dados MySQL.



## Stack utilizada

**Back-end:** Java 17, Mavem e MySQL


## Configuração

Clone o repositório:

```bash
  git clone https://github.com/raphael-jesus-cntd/orderapi.git
  cd orderapi
```
Crie o banco de dados e as tabelas:

```bash
    mysql -u root -p < database.sql
```
Configure as propriedades do banco de dados:

Atualize o arquivo src/main/resources/application.properties ou src/main/resources/application.yaml com suas credenciais do MySQL

```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/orders_db
    spring.datasource.username=root
    spring.datasource.password=sua-senha
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

Construa o projeto com Maven

```bash
    mvn clean install
```

Execute a aplicação

```bash
    mvn spring-boot:run
```
## Endpoints da API

Criar Pedido

URL: '/api/orders'

Método: POST

Formato: JSON ou XML

Exemplo (JSON)

```bash
{
  "controlNumber": "12345",
  "productName": "Product A",
  "unitPrice": 100.00,
  "quantity": 10,
  "customer": {
    "id": 1
  }
}

```

Exemplo (XML):


```bash
<order>
  <controlNumber>12345</controlNumber>
  <productName>Product A</productName>
  <unitPrice>100.00</unitPrice>
  <quantity>10</quantity>
  <customer>
    <id>1</id>
  </customer>
</order>

```

Consultar Todos os Pedidos

URL: /api/orders

Método: GET

Estrutura do Projeto
src/main/java/com/example/orderapi/ - Código fonte da aplicação

model/ - Classes de modelo

repository/ - Interfaces de repositório

service/ - Classes de serviço

controller/ - Controladores REST

src/main/resources/ - Arquivos de configuração

application.properties ou application.yaml - 
Configurações da aplicação

src/test/java/com/example/orderapi/ - Testes unitários


service/ - Testes das classes de serviço

Testes
```bash
    mvn test
```

Notas Adicionais

Injeção de Dependência: Utilizamos a anotação @Autowired do Spring para injeção de dependência.

Padrões de Projeto: O projeto segue o padrão de repositório para acesso a dados e o padrão de serviço para lógica de negócios.

Descontos: A lógica de aplicação de descontos é implementada no serviço de pedidos.
