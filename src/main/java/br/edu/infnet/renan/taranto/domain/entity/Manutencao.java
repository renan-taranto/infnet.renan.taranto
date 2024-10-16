package br.edu.infnet.renan.taranto.domain.entity;

import java.time.LocalDate;

public class Manutencao extends Despesa {
    private String tipo;

    public Manutencao(LocalDate data, float valor, String tipo) {
        super(data, valor);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Manutencao{" +
                "tipo='" + tipo + '\'' +
                "} " + super.toString();
    }
}
