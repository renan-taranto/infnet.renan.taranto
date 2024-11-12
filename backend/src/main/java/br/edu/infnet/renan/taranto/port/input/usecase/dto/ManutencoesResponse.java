package br.edu.infnet.renan.taranto.port.input.usecase.dto;

import br.edu.infnet.renan.taranto.domain.entity.Manutencao;

import java.util.List;

public class ManutencoesResponse {
    private final List<Manutencao> manutencoes;
    private final Long total;

    public ManutencoesResponse(List<Manutencao> manutencoes, Long total) {
        this.manutencoes = manutencoes;
        this.total = total;
    }

    public List<Manutencao> getManutencoes() {
        return manutencoes;
    }

    public Long getTotal() {
        return total;
    }
}
