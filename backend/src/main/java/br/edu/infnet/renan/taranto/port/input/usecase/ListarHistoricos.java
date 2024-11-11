package br.edu.infnet.renan.taranto.port.input.usecase;

import br.edu.infnet.renan.taranto.port.input.usecase.dto.HistoricosResponse;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoRepository;
import org.springframework.stereotype.Service;

@Service
public class ListarHistoricos {
    private final HistoricoRepository historicoRepository;

    public ListarHistoricos(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public HistoricosResponse listar() {
        return new HistoricosResponse(
                historicoRepository.obterTodos(),
                historicoRepository.contarTodos()
        );
    }

    public HistoricosResponse listar(int motoId) {
        return new HistoricosResponse(
                historicoRepository.obterPorMotoId(motoId),
                historicoRepository.contarTodos()
        );
    }
}
