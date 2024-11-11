package br.edu.infnet.renan.taranto.port.input.usecase;

import br.edu.infnet.renan.taranto.domain.entity.Historico;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoRepository;
import org.springframework.stereotype.Service;

@Service
public class SalvarHistorico {
    private final HistoricoRepository historicoRepository;

    public SalvarHistorico(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public void salvar(Historico historico) {
        historicoRepository.salvar(historico);
    }
}
