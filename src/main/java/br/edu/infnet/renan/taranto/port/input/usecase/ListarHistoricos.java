package br.edu.infnet.renan.taranto.port.input.usecase;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoDespesasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarHistoricos {
    private HistoricoDespesasRepository historicoDespesasRepository;

    public ListarHistoricos(HistoricoDespesasRepository historicoDespesasRepository) {
        this.historicoDespesasRepository = historicoDespesasRepository;
    }

    public List<HistoricoDespesas> listar() {
        return historicoDespesasRepository.obterTodos();
    }
}
