package br.edu.infnet.renan.taranto.port.input.usecase.manutenco;

import br.edu.infnet.renan.taranto.domain.entity.Manutencao;
import br.edu.infnet.renan.taranto.port.input.usecase.exception.EntidadeNaoEncontradaException;
import br.edu.infnet.renan.taranto.port.output.repository.ManutencaoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlterarManutencao {
    private final ManutencaoRepository manutencaoRepository;

    public AlterarManutencao(ManutencaoRepository manutencaoRepository) {
        this.manutencaoRepository = manutencaoRepository;
    }

    public Manutencao alterar(int id, Manutencao manutencao) {
        Manutencao manutencaoExistente = manutencaoRepository.buscarPorId(id).orElseThrow(EntidadeNaoEncontradaException::new);

        manutencaoExistente.setTipo(manutencao.getTipo());
        manutencaoExistente.setObservacoes(manutencao.getObservacoes());
        manutencaoExistente.setValor(manutencao.getValor());
        manutencaoExistente.setData(manutencao.getData());

        return manutencaoRepository.salvar(manutencaoExistente);
    }
}
