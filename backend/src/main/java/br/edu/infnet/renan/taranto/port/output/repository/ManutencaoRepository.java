package br.edu.infnet.renan.taranto.port.output.repository;

import br.edu.infnet.renan.taranto.domain.entity.Manutencao;

import java.util.List;

public interface ManutencaoRepository {
    List<Manutencao> obterTodos();
    Long contarTodos();
}
