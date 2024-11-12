package br.edu.infnet.renan.taranto.port.input.usecase.moto;

import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.output.repository.MotoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarMoto {
    private final MotoRepository motoRepository;

    public BuscarMoto(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    public Optional<Moto> buscarPorId(int id) {
        return motoRepository.buscarPorId(id);
    }
}
