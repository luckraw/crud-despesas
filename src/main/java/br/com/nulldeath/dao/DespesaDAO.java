package br.com.nulldeath.dao;

import br.com.nulldeath.infra.ConnectionFactory;
import br.com.nulldeath.model.Categoria;
import br.com.nulldeath.model.Despesa;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DespesaDAO implements IDespesaDAO {

    @Override
    public Despesa salvar(Despesa despesa) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO despesas (descricao, valor, data, categoria) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, despesa.getDescricao());
            preparedStatement.setDouble(2, despesa.getValor());
            preparedStatement.setDate(3, java.sql.Date.valueOf(despesa.getData()));
            preparedStatement.setString(4, despesa.getCategoria().toString());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return despesa;
    }

    @Override
    public Despesa atualizar(Despesa despesa) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE despesas SET descricao = ?, valor = ?, data = ?, categoria = ? WHERE id = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, despesa.getDescricao());
            preparedStatement.setDouble(2, despesa.getValor());
            preparedStatement.setDate(3, java.sql.Date.valueOf(despesa.getData()));
            preparedStatement.setString(4, despesa.getCategoria().toString());
            preparedStatement.setLong(5, despesa.getId());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return despesa;
    }

    @Override
    public void deletar(Long id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "DELETE from despesas WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Despesa> buscarTodos() {
        String sql = "SELECT id, descricao, valor, data, categoria FROM despesas";

        List<Despesa> despesas = new ArrayList<>();


        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String descricao = resultSet.getString("descricao");
                double valor = resultSet.getDouble("valor");
                LocalDate data = resultSet.getDate("data").toLocalDate();
                Categoria categoria = Categoria.valueOf(resultSet.getString("categoria"));

                Despesa despesa = new Despesa(id, descricao, data, valor, categoria);
                despesas.add(despesa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return despesas;
    }

    @Override
    public Optional<Despesa> buscarPorId(Long id) {
        String sql = "SELECT id, descricao, valor, data, categoria FROM despesas WHERE id = ?";

        Despesa despesa = null;

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long pkey = resultSet.getLong("id");
                String descricao = resultSet.getString("descricao");
                double valor = resultSet.getDouble("valor");
                LocalDate data = resultSet.getDate("data").toLocalDate();
                Categoria categoria = Categoria.valueOf(resultSet.getString("categoria"));

                despesa = new Despesa(pkey, descricao, data, valor, categoria);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(despesa);
    }

    @Override
    public List<Despesa> buscarPorCategoria(Categoria categoria) {
        String sql = "SELECT id, descricao, valor, data, categoria FROM despesas WHERE categoria = ?";

        List<Despesa> despesas = new ArrayList<>();


        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoria.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String descricao = resultSet.getString("descricao");
                double valor = resultSet.getDouble("valor");
                LocalDate data = resultSet.getDate("data").toLocalDate();
                Categoria cat = Categoria.valueOf(resultSet.getString("categoria"));

                Despesa despesa = new Despesa(id, descricao, data, valor, cat);
                despesas.add(despesa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return despesas;
    }
}
