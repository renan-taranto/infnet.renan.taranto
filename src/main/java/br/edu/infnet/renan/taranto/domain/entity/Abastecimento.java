package br.edu.infnet.renan.taranto.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "abastecimento")
public class Abastecimento extends Despesa {
    private float litrosAbastecidos;
    private String tipoCombustivel;

    public Abastecimento() {

    }

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
