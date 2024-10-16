package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoricoDespesasRepository implements br.edu.infnet.renan.taranto.port.output.repository.HistoricoDespesasRepository {
    private List<HistoricoDespesas> historicos = new ArrayList<>();

    @Override
    public void incluir(HistoricoDespesas historicoDespesas) {
        historicos.add(historicoDespesas);
    }

    @Override
    public List<HistoricoDespesas> obterTodos() {
        return historicos;
    }
}
