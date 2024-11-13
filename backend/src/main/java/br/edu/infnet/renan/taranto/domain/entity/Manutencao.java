package br.edu.infnet.renan.taranto.domain.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("manutencao")
public class Manutencao extends Despesa {
    private String tipo;
    private String observacoes;

    public Manutencao() {

    }

    public Manutencao(LocalDate data, float valor, String tipo, String observacoes) {
        super(data, valor);
        this.tipo = tipo;
        this.observacoes = observacoes;
    }

    public String getTipo() {
        return tipo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    @Override
    public String toString() {
        return "Manutencao{" +
                "tipo='" + tipo + '\'' +
                ", observacoes='" + observacoes + '\'' +
                "} " + super.toString();
    }
}
