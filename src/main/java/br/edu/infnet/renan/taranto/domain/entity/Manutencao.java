package br.edu.infnet.renan.taranto.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "manutencao")
public class Manutencao extends Despesa {
    private String tipo;
    private String observacoes;

    public Manutencao() {

    }

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
