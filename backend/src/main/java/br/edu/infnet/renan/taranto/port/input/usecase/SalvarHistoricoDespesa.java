package br.edu.infnet.renan.taranto.port.input.usecase;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoDespesasRepository;
import org.springframework.stereotype.Service;

@Service
public class SalvarHistoricoDespesa {
    private final HistoricoDespesasRepository historicoDespesasRepository;

    public SalvarHistoricoDespesa(HistoricoDespesasRepository historicoDespesasRepository) {
        this.historicoDespesasRepository = historicoDespesasRepository;
    }

    public void salvar(HistoricoDespesas historicoDespesa) {
        historicoDespesasRepository.salvar(historicoDespesa);
    }
}
