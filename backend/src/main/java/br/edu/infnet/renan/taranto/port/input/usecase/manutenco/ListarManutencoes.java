package br.edu.infnet.renan.taranto.port.input.usecase.manutenco;

import br.edu.infnet.renan.taranto.port.input.usecase.dto.ManutencoesResponse;
import br.edu.infnet.renan.taranto.port.output.repository.ManutencaoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ListarManutencoes {
    private final ManutencaoRepository manutencaoRepository;

    public ListarManutencoes(ManutencaoRepository manutencaoRepository) {
        this.manutencaoRepository = manutencaoRepository;
    }

    public ManutencoesResponse listar() {
        return new ManutencoesResponse(
                manutencaoRepository.obterTodos(Sort.by(Sort.Order.desc("data"))),
                manutencaoRepository.contarTodos()
        );
    }

    public ManutencoesResponse listar(LocalDate dataInicial, LocalDate dataFinal) {
        return new ManutencoesResponse(manutencaoRepository.obterPorPeriodo(dataInicial, dataFinal), manutencaoRepository.contarTodos());
    }
}
