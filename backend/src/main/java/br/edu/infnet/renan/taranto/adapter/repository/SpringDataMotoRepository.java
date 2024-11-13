package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Moto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpringDataMotoRepository extends CrudRepository<Moto, Integer> {
    List<Moto> findAllByMarca(String marca);
}
