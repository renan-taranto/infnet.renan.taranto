package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import org.springframework.data.repository.CrudRepository;

public interface SpringDataAbastecimentoRepository extends CrudRepository<Abastecimento, Integer> {
}
