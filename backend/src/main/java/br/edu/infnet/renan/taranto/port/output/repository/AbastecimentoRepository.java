package br.edu.infnet.renan.taranto.port.output.repository;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface AbastecimentoRepository {
    List<Abastecimento> obterTodos(Sort by);
    List<Abastecimento> obterPorValor(float valorMinimo, float valorMaximo);
    Optional<Abastecimento> buscarPorId(int id);
    Long contarTodos();
    Abastecimento salvar(Abastecimento abastecimento);
}
