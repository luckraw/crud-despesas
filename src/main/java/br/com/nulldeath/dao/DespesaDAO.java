package br.com.nulldeath.dao;

import br.com.nulldeath.infra.ConnectionFactory;
import br.com.nulldeath.model.Despesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public List<Despesa> buscarTodos() {
        return null;
    }

    @Override
    public Optional<Despesa> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Despesa> buscarPorCategoria(Despesa despesa) {
        return null;
    }
}
