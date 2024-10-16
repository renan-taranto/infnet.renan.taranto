package br.edu.infnet.renan.taranto.port.output.repository;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;

import java.util.List;

public interface HistoricoDespesasRepository {
    public void incluir(HistoricoDespesas historicoDespesas);
    public List<HistoricoDespesas> obterTodos();
}
