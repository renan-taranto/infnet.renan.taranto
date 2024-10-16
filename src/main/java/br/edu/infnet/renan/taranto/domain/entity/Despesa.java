package br.edu.infnet.renan.taranto.domain.entity;

import java.time.LocalDate;

public abstract class Despesa {
    private LocalDate data;
    private float valor;

    public Despesa(LocalDate data, float valor) {
        this.data = data;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "data=" + data +
                ", valor=" + valor +
                '}';
    }
}
