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
    public Moto salvar(Moto moto) {
        return springDataMotoRepository.save(moto);
    }

    @Override
    public List<Moto> obterTodos() {
        return (List<Moto>) springDataMotoRepository.findAll();
    }

    @Override
    public List<Moto> obterPorMarca(String marca) {
        return (List<Moto>) springDataMotoRepository.findAllByMarca(marca);
    }

    @Override
    public Optional<Moto> buscarPorId(int id) {
        return springDataMotoRepository.findById(id);
    }

    @Override
    public Long contarTodos() {
        return springDataMotoRepository.count();
    }

    @Override
    public void remover(int id) {
        springDataMotoRepository.deleteById(id);
    }
}
