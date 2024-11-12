package br.edu.infnet.renan.taranto.port.output.repository;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;

import java.util.List;

public interface AbastecimentoRepository {
    List<Abastecimento> obterTodos();
    Long contarTodos();
}
