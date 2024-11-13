package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Historico;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HistoricoRepositoryImpl implements HistoricoRepository {
    private final SpringDataHistoricoRepository springDataHistoricoRepository;

    public HistoricoRepositoryImpl(SpringDataHistoricoRepository springDataHistoricoRepository) {
        this.springDataHistoricoRepository = springDataHistoricoRepository;
    }

    @Override
    public void salvar(Historico historico) {
        springDataHistoricoRepository.save(historico);
    }

    @Override
    public List<Historico> obterTodos() {
        return (List<Historico>) springDataHistoricoRepository.findAll();
    }

    @Override
    public List<Historico> obterPorMotoId(int motoId) {
        return springDataHistoricoRepository.findAllByMotoId(motoId);
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
