package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Moto;
import org.springframework.data.repository.CrudRepository;

public interface SpringDataMotoRepository extends CrudRepository<Moto, Integer> {
}
