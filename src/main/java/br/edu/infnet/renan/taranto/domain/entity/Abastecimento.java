package br.edu.infnet.renan.taranto.domain.entity;

import java.time.LocalDate;

public class Abastecimento extends Despesa {
    private float litrosAbastecidos;

    public Abastecimento(LocalDate data, float valor, float litrosAbastecidos) {
        super(data, valor);
        this.litrosAbastecidos = litrosAbastecidos;
    }

    public float getLitrosAbastecidos() {
        return litrosAbastecidos;
    }

    @Override
    public String toString() {
        return "Abastecimento{" +
                "litrosAbastecidos=" + litrosAbastecidos +
                "} " + super.toString();
    }
}
