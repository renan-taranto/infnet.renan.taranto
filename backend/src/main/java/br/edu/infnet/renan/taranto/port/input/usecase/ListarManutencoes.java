package br.edu.infnet.renan.taranto.port.input.usecase;

import br.edu.infnet.renan.taranto.port.input.usecase.dto.ManutencaoResponse;
import br.edu.infnet.renan.taranto.port.output.repository.ManutencaoRepository;
import org.springframework.stereotype.Service;

@Service
public class ListarManutencoes {
    private final ManutencaoRepository manutencaoRepository;

    public ListarManutencoes(ManutencaoRepository manutencaoRepository) {
        this.manutencaoRepository = manutencaoRepository;
    }

    public ManutencaoResponse listar() {
        return new ManutencaoResponse(manutencaoRepository.obterTodos(), manutencaoRepository.contarTodos());
    }
}
