package br.edu.infnet.renan.taranto.port.output.repository;

import br.edu.infnet.renan.taranto.domain.entity.Moto;

import java.util.Optional;

public interface MotoRepository {
    public void salvar(Moto moto);
    public Optional<Moto> buscarPorId(int id);
}
