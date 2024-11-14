package br.edu.infnet.renan.taranto.adapter.repository;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpringDataAbastecimentoRepository extends CrudRepository<Abastecimento, Integer> {
    List<Abastecimento> findAllByValorBetween(float valorMinimo, float valorMaximo);
}
