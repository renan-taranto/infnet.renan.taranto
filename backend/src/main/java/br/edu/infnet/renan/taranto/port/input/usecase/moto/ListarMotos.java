package br.edu.infnet.renan.taranto.port.input.usecase.moto;

import br.edu.infnet.renan.taranto.port.input.usecase.dto.MotosResponse;
import br.edu.infnet.renan.taranto.port.output.repository.MotoRepository;
import org.springframework.stereotype.Service;

@Service
public class ListarMotos {
    private final MotoRepository motoRepository;

    public ListarMotos(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    public MotosResponse listar() {
        return new MotosResponse(motoRepository.obterTodos(), motoRepository.contarTodos());
    }

    public MotosResponse listar(String marca) {
        return new MotosResponse(motoRepository.obterPorMarca(marca), motoRepository.contarTodos());
    }
}
