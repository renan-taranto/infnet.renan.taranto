package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Manutencao;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface SpringDataManutencaoRepository extends CrudRepository<Manutencao, Integer> {
    List<Manutencao> findAllByDataBetween(LocalDate dataInicial, LocalDate dataFinal);
}
