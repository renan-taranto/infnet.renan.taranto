package br.edu.infnet.renan.taranto.port.input.usecase;

import br.edu.infnet.renan.taranto.port.input.usecase.dto.HistoricoResponse;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoRepository;
import org.springframework.stereotype.Service;

@Service
public class ListarHistoricos {
    private final HistoricoRepository historicoRepository;

    public ListarHistoricos(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public HistoricoResponse listar() {
        return new HistoricoResponse(
                historicoRepository.obterTodos(),
                historicoRepository.contarTodos()
        );
    }

    public HistoricoResponse listar(int motoId) {
        return new HistoricoResponse(
                historicoRepository.obterPorMotoId(motoId),
                historicoRepository.contarTodos()
        );
    }
}
