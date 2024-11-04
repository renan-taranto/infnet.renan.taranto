package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoDespesasRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HistoricoDespesasRepositoryImpl implements HistoricoDespesasRepository {
    private final SpringDataHistoricoDespesasRepository springDataHistoricoDespesasRepository;

    public HistoricoDespesasRepositoryImpl(SpringDataHistoricoDespesasRepository springDataHistoricoDespesasRepository) {
        this.springDataHistoricoDespesasRepository = springDataHistoricoDespesasRepository;
    }

    @Override
    public void salvar(HistoricoDespesas historicoDespesas) {
        springDataHistoricoDespesasRepository.save(historicoDespesas);
    }

    @Override
    public List<HistoricoDespesas> obterTodos() {
        return (List<HistoricoDespesas>) springDataHistoricoDespesasRepository.findAll();
    }

    @Override
    public Optional<HistoricoDespesas> obterPorMotoId(int motoId) {
        return springDataHistoricoDespesasRepository.findByMotoId(motoId);
    }
}
