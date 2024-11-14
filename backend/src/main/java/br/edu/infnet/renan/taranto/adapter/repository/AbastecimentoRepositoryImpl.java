package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import br.edu.infnet.renan.taranto.port.output.repository.AbastecimentoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AbastecimentoRepositoryImpl implements AbastecimentoRepository {
    private final SpringDataAbastecimentoRepository springDataAbastecimentoRepository;

    public AbastecimentoRepositoryImpl(SpringDataAbastecimentoRepository springDataAbastecimentoRepository) {
        this.springDataAbastecimentoRepository = springDataAbastecimentoRepository;
    }

    @Override
    public List<Abastecimento> obterTodos(Sort by) {
        return springDataAbastecimentoRepository.findAll(by);
    }

    @Override
    public List<Abastecimento> obterPorValor(float valorMinimo, float valorMaximo) {
        return springDataAbastecimentoRepository.findAllByValorBetween(valorMinimo, valorMaximo);
    }

    @Override
    public Optional<Abastecimento> buscarPorId(int id) {
        return springDataAbastecimentoRepository.findById(id);
    }

    @Override
    public Long contarTodos() {
        return springDataAbastecimentoRepository.count();
    }

    @Override
    public Abastecimento salvar(Abastecimento abastecimento) {
        return springDataAbastecimentoRepository.save(abastecimento);
    }
}
