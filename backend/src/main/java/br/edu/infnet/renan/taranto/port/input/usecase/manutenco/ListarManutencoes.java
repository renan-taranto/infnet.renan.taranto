package br.edu.infnet.renan.taranto.port.input.usecase.manutenco;

import br.edu.infnet.renan.taranto.port.input.usecase.dto.ManutencoesResponse;
import br.edu.infnet.renan.taranto.port.output.repository.ManutencaoRepository;
import org.springframework.stereotype.Service;

@Service
public class ListarManutencoes {
    private final ManutencaoRepository manutencaoRepository;

    public ListarManutencoes(ManutencaoRepository manutencaoRepository) {
        this.manutencaoRepository = manutencaoRepository;
    }

    public ManutencoesResponse listar() {
        return new ManutencoesResponse(manutencaoRepository.obterTodos(), manutencaoRepository.contarTodos());
    }
}
