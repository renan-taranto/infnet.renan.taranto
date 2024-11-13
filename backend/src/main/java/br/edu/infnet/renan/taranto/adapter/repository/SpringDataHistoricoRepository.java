package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataHistoricoRepository extends JpaRepository<Historico, Integer> {
    Optional<Historico> findByMotoId(Integer id);
    Optional<Historico> findByDespesasId(int despesaId);
}
