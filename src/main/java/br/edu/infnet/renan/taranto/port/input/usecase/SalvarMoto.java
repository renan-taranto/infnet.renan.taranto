package br.edu.infnet.renan.taranto.port.input.usecase;

import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.output.repository.MotoRepository;
import org.springframework.stereotype.Service;

@Service
public class SalvarMoto {
    private final MotoRepository motoRepository;

    public SalvarMoto(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    public void salvar(Moto moto) {
        motoRepository.salvar(moto);
    }
}
