package br.edu.infnet.renan.taranto.port.input.usecase;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoDespesasRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarHistoricoDespesas {
    private final HistoricoDespesasRepository historicoDespesasRepository;

    public BuscarHistoricoDespesas(HistoricoDespesasRepository historicoDespesasRepository) {
        this.historicoDespesasRepository = historicoDespesasRepository;
    }

    public Optional<HistoricoDespesas> buscarPorMotoId(int motoId) {
        return historicoDespesasRepository.obterPorMotoId(motoId);
    }
}
