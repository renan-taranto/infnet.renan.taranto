package br.edu.infnet.renan.taranto.port.input.usecase.dto;

import br.edu.infnet.renan.taranto.domain.entity.Historico;

import java.util.List;

public class HistoricosResponse {
    private final List<Historico> historicos;
    private final Long total;

    public HistoricosResponse(List<Historico> historicos, Long total) {
        this.historicos = historicos;
        this.total = total;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public Long getTotal() {
        return total;
    }
}
