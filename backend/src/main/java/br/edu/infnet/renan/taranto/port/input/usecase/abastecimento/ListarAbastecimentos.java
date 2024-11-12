package br.edu.infnet.renan.taranto.port.input.usecase.abastecimento;

import br.edu.infnet.renan.taranto.port.input.usecase.dto.AbastecimentosResponse;
import br.edu.infnet.renan.taranto.port.output.repository.AbastecimentoRepository;
import org.springframework.stereotype.Service;

@Service
public class ListarAbastecimentos {
    private final AbastecimentoRepository abastecimentoRepository;

    public ListarAbastecimentos(AbastecimentoRepository abastecimentoRepository) {
        this.abastecimentoRepository = abastecimentoRepository;
    }

    public AbastecimentosResponse listar() {
        return new AbastecimentosResponse(abastecimentoRepository.obterTodos(), abastecimentoRepository.contarTodos());
    }
}
