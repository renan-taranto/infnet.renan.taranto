package br.edu.infnet.renan.taranto.port.output.repository;

import br.edu.infnet.renan.taranto.domain.entity.Historico;

import java.util.List;

public interface HistoricoRepository {
    void salvar(Historico historico);
    List<Historico> obterTodos();
    List<Historico> obterPorMotoId(int motoId);
    Long contarTodos();
}
