package br.edu.infnet.renan.taranto.port.input.usecase.dto;

import br.edu.infnet.renan.taranto.domain.entity.Despesa;

import java.util.List;

public class DespesasResponse {
    private final List<Despesa> despesas;
    private final Long total;

    public DespesasResponse(List<Despesa> despesas, Long total) {
        this.despesas = despesas;
        this.total = total;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public Long getTotal() {
        return total;
    }
}
