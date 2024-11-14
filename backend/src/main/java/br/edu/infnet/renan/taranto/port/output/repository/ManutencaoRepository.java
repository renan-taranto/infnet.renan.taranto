package br.edu.infnet.renan.taranto.port.output.repository;

import br.edu.infnet.renan.taranto.domain.entity.Manutencao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ManutencaoRepository {
    List<Manutencao> obterTodos();
    List<Manutencao> obterPorPeriodo(LocalDate dataInicial, LocalDate dataFinal);
    Optional<Manutencao> buscarPorId(int id);
    Long contarTodos();
    Manutencao salvar(Manutencao manutencao);
}
