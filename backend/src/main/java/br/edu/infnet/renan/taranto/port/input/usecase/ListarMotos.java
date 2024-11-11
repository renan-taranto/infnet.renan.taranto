package br.edu.infnet.renan.taranto.port.input.usecase;

import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.output.repository.MotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarMotos {
    private MotoRepository motoRepository;

    public ListarMotos(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    public List<Moto> listar() {
        return motoRepository.obterTodos();
    }
}
