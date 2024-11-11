package br.edu.infnet.renan.taranto.port.input.usecase.dto;

import br.edu.infnet.renan.taranto.domain.entity.Moto;

import java.util.List;

public class MotosResponse {
    private final List<Moto> motos;
    private final Long total;

    public MotosResponse(List<Moto> motos, Long total) {
        this.motos = motos;
        this.total = total;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public Long getTotal() {
        return total;
    }
}
