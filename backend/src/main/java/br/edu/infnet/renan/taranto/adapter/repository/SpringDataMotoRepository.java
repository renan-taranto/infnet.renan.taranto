package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataMotoRepository extends JpaRepository<Moto, Integer> {
    List<Moto> findAllByMarca(String marca);
}
