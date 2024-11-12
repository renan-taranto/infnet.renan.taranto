package br.edu.infnet.renan.taranto.port.input.usecase.dto;

import br.edu.infnet.renan.taranto.domain.entity.Manutencao;

import java.util.List;

public class ManutencaoResponse {
    private final List<Manutencao> manutencoes;
    private final Long count;

    public ManutencaoResponse(List<Manutencao> manutencoes, Long count) {
        this.manutencoes = manutencoes;
        this.count = count;
    }

    public List<Manutencao> getManutencoes() {
        return manutencoes;
    }

    public Long getCount() {
        return count;
    }
}
