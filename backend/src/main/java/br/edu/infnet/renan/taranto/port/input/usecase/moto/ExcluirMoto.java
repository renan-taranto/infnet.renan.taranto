package br.edu.infnet.renan.taranto.port.input.usecase.moto;

import br.edu.infnet.renan.taranto.domain.entity.Historico;
import br.edu.infnet.renan.taranto.port.input.usecase.exception.EntidadeNaoEncontradaException;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoRepository;
import br.edu.infnet.renan.taranto.port.output.repository.MotoRepository;
import org.springframework.stereotype.Service;

@Service
public class ExcluirMoto {
    private final MotoRepository motoRepository;
    private final HistoricoRepository historicoRepository;

    public ExcluirMoto(MotoRepository motoRepository, HistoricoRepository historicoRepository) {
        this.motoRepository = motoRepository;
        this.historicoRepository = historicoRepository;
    }

    public void excluirMoto(int id) {
        motoRepository.buscarPorId(id).orElseThrow(EntidadeNaoEncontradaException::new);

        Historico historico = historicoRepository.obterPorMotoId(id).orElseThrow(EntidadeNaoEncontradaException::new);
        historicoRepository.remover(historico.getId());

        motoRepository.remover(id);
    }
}
