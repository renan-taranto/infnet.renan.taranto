package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Historico;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HistoricoRepositoryImpl implements HistoricoRepository {
    private final SpringDataHistoricoRepository springDataHistoricoRepository;

    public HistoricoRepositoryImpl(SpringDataHistoricoRepository springDataHistoricoRepository) {
        this.springDataHistoricoRepository = springDataHistoricoRepository;
    }

    @Override
    public Historico salvar(Historico historico) {
        return springDataHistoricoRepository.save(historico);
    }

    @Override
    public List<Historico> obterTodos() {
        return springDataHistoricoRepository.findAll();
    }

    @Override
    public Optional<Historico> obterPorMotoId(int motoId) {
        return springDataHistoricoRepository.findByMotoId(motoId);
    }

    @Override
    public Optional<Historico> obterPorDespesaId(int despesaId) {
        return springDataHistoricoRepository.findByDespesasId(despesaId);
    }

    @Override
    public Long contarTodos() {
        return springDataHistoricoRepository.count();
    }

    @Override
    public void remover(int id) {
        springDataHistoricoRepository.deleteById(id);
    }
}
