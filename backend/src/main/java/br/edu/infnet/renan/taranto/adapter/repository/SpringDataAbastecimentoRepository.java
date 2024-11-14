package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataAbastecimentoRepository extends JpaRepository<Abastecimento, Integer> {
    List<Abastecimento> findAllByValorBetween(float valorMinimo, float valorMaximo);
}
