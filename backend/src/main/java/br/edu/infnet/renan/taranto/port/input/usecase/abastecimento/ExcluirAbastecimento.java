package br.edu.infnet.renan.taranto.port.input.usecase.abastecimento;

import br.edu.infnet.renan.taranto.domain.entity.Historico;
import br.edu.infnet.renan.taranto.port.input.usecase.exception.EntidadeNaoEncontradaException;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoRepository;
import org.springframework.stereotype.Service;

@Service
public class ExcluirAbastecimento {
    private final HistoricoRepository historicoRepository;

    public ExcluirAbastecimento(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public void excluirAbastecimento(int id) {
        Historico historico = historicoRepository.obterPorDespesaId(id).orElseThrow(EntidadeNaoEncontradaException::new);
        historico.removerDespesa(id);
        historicoRepository.salvar(historico);
    }
}
