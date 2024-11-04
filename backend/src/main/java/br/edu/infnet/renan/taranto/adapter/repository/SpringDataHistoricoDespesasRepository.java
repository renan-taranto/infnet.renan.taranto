package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpringDataHistoricoDespesasRepository extends CrudRepository<HistoricoDespesas, Integer> {
    Optional<HistoricoDespesas> findByMotoId(Integer id);
}
