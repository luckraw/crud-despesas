package br.com.nulldeath.dao;

import br.com.nulldeath.model.Categoria;
import br.com.nulldeath.model.Despesa;

import java.util.List;
import java.util.Optional;

public interface IDespesaDAO {

    Despesa salvar(Despesa despesa);
    Despesa atualizar(Despesa despesa);
    void deletar(Long id);
    List<Despesa> buscarTodos();
    Optional<Despesa> buscarPorId(Long id);
    List<Despesa> buscarPorCategoria(Categoria categoria);

}
