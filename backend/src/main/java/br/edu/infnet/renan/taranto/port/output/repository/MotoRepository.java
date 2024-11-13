package br.edu.infnet.renan.taranto.port.output.repository;

import br.edu.infnet.renan.taranto.domain.entity.Moto;

import java.util.List;
import java.util.Optional;

public interface MotoRepository {
    Moto salvar(Moto moto);
    List<Moto> obterTodos();
    List<Moto> obterPorMarca(String marca);
    Optional<Moto> buscarPorId(int id);
    Long contarTodos();
    void remover(int id);
}
