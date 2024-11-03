package br.edu.infnet.renan.taranto.port.output.repository;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;

import java.util.List;
import java.util.Optional;

public interface HistoricoDespesasRepository {
    public void salvar(HistoricoDespesas historicoDespesas);
    public List<HistoricoDespesas> obterTodos();
    public Optional<HistoricoDespesas> obterPorMotoId(int motoId);
}
