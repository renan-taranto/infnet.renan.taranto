package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Manutencao;
import br.edu.infnet.renan.taranto.port.output.repository.ManutencaoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class ManutencaoRepositoryImpl implements ManutencaoRepository {
    private final SpringDataManutencaoRepository springDataManutencaoRepository;

    public ManutencaoRepositoryImpl(SpringDataManutencaoRepository springDataManutencaoRepository) {
        this.springDataManutencaoRepository = springDataManutencaoRepository;
    }

    @Override
    public Optional<Manutencao> buscarPorId(int id) {
        return springDataManutencaoRepository.findById(id);
    }

    @Override
    public Manutencao salvar(Manutencao manutencao) {
        return springDataManutencaoRepository.save(manutencao);
    }

    @Override
    public List<Manutencao> obterTodos(Sort by) {
        return springDataManutencaoRepository.findAll(by);
    }

    @Override
    public List<Manutencao> obterPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        return springDataManutencaoRepository.findAllByDataBetween(dataInicial, dataFinal);
    }

    @Override
    public Long contarTodos() {
        return springDataManutencaoRepository.count();
    }
}
