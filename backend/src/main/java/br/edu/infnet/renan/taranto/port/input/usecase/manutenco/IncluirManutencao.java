package br.edu.infnet.renan.taranto.port.input.usecase.manutenco;

import br.edu.infnet.renan.taranto.domain.entity.Historico;
import br.edu.infnet.renan.taranto.domain.entity.Manutencao;
import br.edu.infnet.renan.taranto.port.input.usecase.exception.EntidadeNaoEncontradaException;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoRepository;
import org.springframework.stereotype.Service;

@Service
public class IncluirManutencao {
    private final HistoricoRepository historicoRepository;

    public IncluirManutencao(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public void incluir(int motoId, Manutencao manutencao) {
        Historico historico = historicoRepository.obterPorMotoId(motoId).orElseThrow(EntidadeNaoEncontradaException::new);
        historico.adicionarDespesa(manutencao);

        historicoRepository.salvar(historico);
    }
}
