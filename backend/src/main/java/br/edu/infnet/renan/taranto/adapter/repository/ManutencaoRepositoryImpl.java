package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Manutencao;
import br.edu.infnet.renan.taranto.port.output.repository.ManutencaoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManutencaoRepositoryImpl implements ManutencaoRepository {
    private final SpringDataManutencaoRepository springDataManutencaoRepository;

    public ManutencaoRepositoryImpl(SpringDataManutencaoRepository springDataManutencaoRepository) {
        this.springDataManutencaoRepository = springDataManutencaoRepository;
    }

    @Override
    public List<Manutencao> obterTodos() {
        return (List<Manutencao>) springDataManutencaoRepository.findAll();
    }

    @Override
    public Long contarTodos() {
        return springDataManutencaoRepository.count();
    }
}
