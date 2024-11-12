package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import br.edu.infnet.renan.taranto.port.output.repository.AbastecimentoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AbastecimentoRepositoryImpl implements AbastecimentoRepository {
    private final SpringDataAbastecimentoRepository springDataAbastecimentoRepository;

    public AbastecimentoRepositoryImpl(SpringDataAbastecimentoRepository springDataAbastecimentoRepository) {
        this.springDataAbastecimentoRepository = springDataAbastecimentoRepository;
    }

    @Override
    public List<Abastecimento> obterTodos() {
        return (List<Abastecimento>) springDataAbastecimentoRepository.findAll();
    }

    @Override
    public Long contarTodos() {
        return springDataAbastecimentoRepository.count();
    }
}
