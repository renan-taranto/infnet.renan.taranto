package br.edu.infnet.renan.taranto.port.input.usecase.moto;

import br.edu.infnet.renan.taranto.domain.entity.Historico;
import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoRepository;
import br.edu.infnet.renan.taranto.port.output.repository.MotoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExcluirMoto {
    private final MotoRepository motoRepository;
    private final HistoricoRepository historicoRepository;

    public ExcluirMoto(MotoRepository motoRepository, HistoricoRepository historicoRepository) {
        this.motoRepository = motoRepository;
        this.historicoRepository = historicoRepository;
    }

    public boolean excluirMoto(int id) {
        Historico historico = historicoRepository.obterPorMotoId(id).get(0);
        historicoRepository.remover(historico.getId());

        motoRepository.remover(id);
        return true;
    }
}
