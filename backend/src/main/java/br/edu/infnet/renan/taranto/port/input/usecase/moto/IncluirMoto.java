package br.edu.infnet.renan.taranto.port.input.usecase.moto;

import br.edu.infnet.renan.taranto.domain.entity.Historico;
import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoRepository;
import br.edu.infnet.renan.taranto.port.output.repository.MotoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class IncluirMoto {
    private final MotoRepository motoRepository;
    private final HistoricoRepository historicoRepository;

    public IncluirMoto(MotoRepository motoRepository, HistoricoRepository historicoRepository) {
        this.motoRepository = motoRepository;
        this.historicoRepository = historicoRepository;
    }

    public void incluir(Moto moto, LocalDate dataCriacaoHistorico) {
        motoRepository.salvar(moto);
        historicoRepository.salvar(new Historico(moto, dataCriacaoHistorico)); // Sempre que uma moto é incluída, um histórico para ela é criado.
    }
}
