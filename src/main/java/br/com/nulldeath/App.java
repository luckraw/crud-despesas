package br.com.nulldeath;

import br.com.nulldeath.dao.DespesaDAO;
import br.com.nulldeath.model.Despesa;

import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {

        DespesaDAO dao = new DespesaDAO();

        Optional<Despesa> despesaOptional = dao.buscarPorId(2L);
        despesaOptional.ifPresent(despesa -> {
            System.out.println("ID: " + despesa.getId());
            System.out.println("Descricao: " + despesa.getDescricao());
            System.out.println("Valor: " + despesa.getValor());
        });
    }
}
