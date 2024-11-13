package br.edu.infnet.renan.taranto.port.output.repository;

import br.edu.infnet.renan.taranto.domain.entity.Historico;

import java.util.List;
import java.util.Optional;

public interface HistoricoRepository {
    Historico salvar(Historico historico);
    List<Historico> obterTodos();
    Optional<Historico> obterPorMotoId(int motoId);
    Optional<Historico> obterPorDespesaId(int despesaId);
    Long contarTodos();
    void remover(int id);
}
