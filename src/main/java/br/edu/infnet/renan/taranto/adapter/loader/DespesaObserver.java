package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;

public interface DespesaObserver {
    void criarDespesa(String[] dados, HistoricoDespesas historicoDespesas);
}
