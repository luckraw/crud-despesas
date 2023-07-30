# Gerenciamento de Despesas

Este é um projeto de gerenciamento de despesas desenvolvido em Java que permite realizar operações básicas de persistência (criação, atualização, exclusão e busca) relacionadas a despesas e categorias em um banco de dados. Neste projeto, é utilizado um banco de dados relacional para armazenar informações sobre as despesas, como descrição, valor, data e categoria.

### Tecnologias Utilizadas

As principais tecnologias utilizadas neste projeto são:

- Java: A linguagem de programação principal utilizada para desenvolver o projeto.
- SQL: Utilizado para executar consultas e operações no banco de dados relacional.
- JDBC (Java Database Connectivity): Biblioteca Java que fornece uma API para conexão e execução de consultas em bancos de dados.

### Como Utilizar

Para utilizar o projeto DespesaDAO, siga os seguintes passos:

- Certifique-se de ter o Java Development Kit (JDK) instalado em seu computador.
- Importe o projeto para sua IDE preferida (por exemplo, Eclipse, IntelliJ, NetBeans).
- Certifique-se de ter um banco de dados relacional configurado e funcionando, como MySQL, PostgreSQL, ou outro compatível.
- Verifique as configurações de conexão com o banco de dados no arquivo ConnectionFactory.java na pasta br.com.nulldeath.infra.
- Crie uma tabela chamada despesas em seu banco de dados com as colunas id (chave primária), descricao, valor, data, e categoria.
- Utilize as classes e interfaces disponíveis no pacote br.com.nulldeath.dao para realizar as operações de persistência no banco de dados.

- Aqui está um exemplo de como salvar uma nova despesa:
```java
DespesaDAO despesaDAO = new DespesaDAO();
Despesa despesa = new Despesa("Compra de Material", LocalDate.of(2023, 7, 23), 150.0, Categoria.ALIMENTACAO);
despesaDAO.salvar(despesa);
```
- Exemplo de atualizar uma despesa existente:
```java
DespesaDAO despesaDAO = new DespesaDAO();
long despesaId = 1; // Supondo que o ID da despesa a ser atualizada é 1
Despesa despesa = despesaDAO.buscarPorId(despesaId).orElse(null);
if (despesa != null) {
    despesa.setDescricao("Compra de Livros");
    despesa.setValor(200.0);
    despesaDAO.atualizar(despesa);
} else {
    System.out.println("Despesa não encontrada.");
}
```
- Exemplo de deletar uma despesa existente:
```java
DespesaDAO despesaDAO = new DespesaDAO();
long despesaId = 1; // Supondo que o ID da despesa a ser deletada é 1
despesaDAO.deletar(despesaId);
```
- Exemplo de buscar todas as despesas cadastradas:
```java
DespesaDAO despesaDAO = new DespesaDAO();
List<Despesa> todasDespesas = despesaDAO.buscarTodos();
for (Despesa despesa : todasDespesas) {
    System.out.println(despesa);
}
```
- Exemplo de buscar uma despesa por ID:
```java
DespesaDAO despesaDAO = new DespesaDAO();
long despesaId = 1; // Supondo que o ID da despesa a ser buscada é 1
Optional<Despesa> optionalDespesa = despesaDAO.buscarPorId(despesaId);
if (optionalDespesa.isPresent()) {
    Despesa despesaEncontrada = optionalDespesa.get();
    System.out.println(despesaEncontrada);
} else {
    System.out.println("Despesa não encontrada.");
}
```
- Exemplo de buscar despesas por categoria:
```java
DespesaDAO despesaDAO = new DespesaDAO();
Categoria categoria = Categoria.TRANSPORTE; // Supondo que queremos buscar despesas da categoria "TRANSPORTE"
List<Despesa> despesasPorCategoria = despesaDAO.buscarPorCategoria(categoria);
for (Despesa despesa : despesasPorCategoria) {
    System.out.println(despesa);
}
```

Você pode utilizar os demais métodos disponíveis na classe `DespesaDAO` para atualizar, deletar e buscar despesas no banco de dados.
