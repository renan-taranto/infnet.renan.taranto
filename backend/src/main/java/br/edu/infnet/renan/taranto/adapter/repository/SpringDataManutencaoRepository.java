package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Manutencao;
import org.springframework.data.repository.CrudRepository;

public interface SpringDataManutencaoRepository extends CrudRepository<Manutencao, Integer> {
}
