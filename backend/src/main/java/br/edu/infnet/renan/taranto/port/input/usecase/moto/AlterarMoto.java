package br.edu.infnet.renan.taranto.port.input.usecase.moto;

import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.input.usecase.exception.EntidadeNaoEncontradaException;
import br.edu.infnet.renan.taranto.port.output.repository.MotoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlterarMoto {
    private final MotoRepository motoRepository;

    public AlterarMoto(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    public Moto alterar(int id, Moto moto) {
        Moto motoExistente = motoRepository.buscarPorId(id).orElseThrow(EntidadeNaoEncontradaException::new);

        motoExistente.setMarca(moto.getMarca());
        motoExistente.setModelo(moto.getModelo());

        return motoRepository.salvar(motoExistente);
    }
}
