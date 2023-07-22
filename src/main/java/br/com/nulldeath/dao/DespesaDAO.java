package br.com.nulldeath.dao;

import br.com.nulldeath.model.Despesa;

import java.util.List;
import java.util.Optional;

public class DespesaDAO implements IDespesaDAO{

    @Override
    public Despesa salvar(Despesa despesa) {
        return null;
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
