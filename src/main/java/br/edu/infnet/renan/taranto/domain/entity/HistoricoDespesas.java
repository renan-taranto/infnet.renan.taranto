package br.edu.infnet.renan.taranto.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class HistoricoDespesas {
    private Moto moto;
    private List<Despesa> despesas;

    public HistoricoDespesas(Moto moto) {
        this.moto = moto;
        this.despesas = new ArrayList<>();
    }

    public Moto getMoto() {
        return moto;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void adicionarDespesa(Despesa despesa) {
        this.despesas.add(despesa);
    }

    @Override
    public String toString() {
        return "HistoricoDespesas{" +
                "moto=" + moto +
                ", despesas=" + despesas +
                '}';
    }
}
