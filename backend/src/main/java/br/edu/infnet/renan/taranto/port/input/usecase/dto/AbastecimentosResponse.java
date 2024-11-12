package br.edu.infnet.renan.taranto.port.input.usecase.dto;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;

import java.util.List;

public class AbastecimentosResponse {
    private final List<Abastecimento> abastecimentos;
    private final Long total;

    public AbastecimentosResponse(List<Abastecimento> abastecimentos, Long total) {
        this.abastecimentos = abastecimentos;
        this.total = total;
    }

    public List<Abastecimento> getAbastecimentos() {
        return abastecimentos;
    }

    public Long getTotal() {
        return total;
    }
}
