package br.edu.infnet.renan.taranto.port.input.usecase.dto;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;

import java.util.List;

public class AbastecimentosResponse {
    private final List<Abastecimento> abastecimentos;
    private final Long count;

    public AbastecimentosResponse(List<Abastecimento> abastecimentos, Long count) {
        this.abastecimentos = abastecimentos;
        this.count = count;
    }

    public List<Abastecimento> getAbastecimentos() {
        return abastecimentos;
    }

    public Long getCount() {
        return count;
    }
}
