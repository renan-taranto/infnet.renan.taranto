package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.output.repository.MotoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MotoRepositoryImpl implements MotoRepository {
    private final SpringDataMotoRepository springDataMotoRepository;

    public MotoRepositoryImpl(SpringDataMotoRepository springDataMotoRepository) {
        this.springDataMotoRepository = springDataMotoRepository;
    }

    @Override
    public void salvar(Moto moto) {
        springDataMotoRepository.save(moto);
    }

    @Override
    public List<Moto> obterTodos() {
        return (List<Moto>) springDataMotoRepository.findAll();
    }

    @Override
    public Optional<Moto> buscarPorId(int id) {
        return springDataMotoRepository.findById(id);
    }
}
