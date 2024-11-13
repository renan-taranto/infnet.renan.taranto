package br.edu.infnet.renan.taranto.port.input.usecase.abastecimento;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import br.edu.infnet.renan.taranto.domain.entity.Historico;
import br.edu.infnet.renan.taranto.port.input.usecase.exception.EntidadeNaoEncontradaException;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoRepository;
import org.springframework.stereotype.Service;

@Service
public class IncluirAbastecimento {
    private final HistoricoRepository historicoRepository;

    public IncluirAbastecimento(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public void incluir(int motoId, Abastecimento abastecimento) {
        Historico historico = historicoRepository.obterPorMotoId(motoId).orElseThrow(EntidadeNaoEncontradaException::new);
        historico.adicionarDespesa(abastecimento);

        historicoRepository.salvar(historico);
    }
}
