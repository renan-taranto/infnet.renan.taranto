package br.edu.infnet.renan.taranto.port.input.usecase.abastecimento;

import br.edu.infnet.renan.taranto.port.input.usecase.dto.AbastecimentosResponse;
import br.edu.infnet.renan.taranto.port.output.repository.AbastecimentoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ListarAbastecimentos {
    private final AbastecimentoRepository abastecimentoRepository;

    public ListarAbastecimentos(AbastecimentoRepository abastecimentoRepository) {
        this.abastecimentoRepository = abastecimentoRepository;
    }

    public AbastecimentosResponse listar() {
        return new AbastecimentosResponse(
                abastecimentoRepository.obterTodos(Sort.by(Sort.Order.desc("data"))),
                abastecimentoRepository.contarTodos()
        );
    }

    public AbastecimentosResponse listar(float valorMinimo, float valorMaximo) {
        return new AbastecimentosResponse(abastecimentoRepository.obterPorValor(valorMinimo, valorMaximo), abastecimentoRepository.contarTodos());
    }
}
