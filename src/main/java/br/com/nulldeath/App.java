package br.com.nulldeath;

import br.com.nulldeath.dao.DespesaDAO;
import br.com.nulldeath.model.Categoria;
import br.com.nulldeath.model.Despesa;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        DespesaDAO dao = new DespesaDAO();
        Despesa despesa = new Despesa();
        Despesa despesa1 = new Despesa();

        despesa.setDescricao("Compra do mes");
        despesa.setCategoria(Categoria.ALIMENTACAO);
        despesa.setValor(1.000);
        despesa.setData(LocalDate.of(2023, 07, 22));

        dao.salvar(despesa);

    }
}
