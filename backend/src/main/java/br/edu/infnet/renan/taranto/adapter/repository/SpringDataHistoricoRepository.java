package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Historico;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpringDataHistoricoRepository extends CrudRepository<Historico, Integer> {
    List<Historico> findAllByMotoId(Integer id);
}
