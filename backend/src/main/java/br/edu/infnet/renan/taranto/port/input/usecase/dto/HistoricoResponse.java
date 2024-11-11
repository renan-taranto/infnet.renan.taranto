package br.edu.infnet.renan.taranto.port.input.usecase.dto;

import br.edu.infnet.renan.taranto.domain.entity.Historico;

import java.util.List;

public class HistoricoResponse {
    private List<Historico> historicos;
    private Long total;

    public HistoricoResponse(List<Historico> historicos, Long total) {
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
