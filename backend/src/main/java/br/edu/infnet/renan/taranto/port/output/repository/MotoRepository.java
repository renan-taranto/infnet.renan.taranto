package br.edu.infnet.renan.taranto.port.output.repository;

import br.edu.infnet.renan.taranto.domain.entity.Moto;

import java.util.List;
import java.util.Optional;

public interface MotoRepository {
    void salvar(Moto moto);
    List<Moto> obterTodos();
    Optional<Moto> buscarPorId(int id);
}
