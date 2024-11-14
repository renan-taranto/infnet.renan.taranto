package br.edu.infnet.renan.taranto.port.input.usecase.historico;

import br.edu.infnet.renan.taranto.domain.entity.Historico;
import br.edu.infnet.renan.taranto.port.input.usecase.dto.HistoricosResponse;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ListarHistoricos {
    private final HistoricoRepository historicoRepository;

    public ListarHistoricos(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public HistoricosResponse listar() {
        return new HistoricosResponse(
                historicoRepository.obterTodos(Sort.by(Sort.Order.desc("dataCriacao"))),
                historicoRepository.contarTodos()
        );
    }

    public HistoricosResponse listar(int motoId) {
        return new HistoricosResponse(
                historicoRepository.obterPorMotoId(motoId).map(Collections::singletonList).orElse(Collections.emptyList()),
                historicoRepository.contarTodos()
        );
    }
}
