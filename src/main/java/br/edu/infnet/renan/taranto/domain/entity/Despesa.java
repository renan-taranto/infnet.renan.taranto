package br.edu.infnet.renan.taranto.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "despesa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate data;
    private float valor;

    public Despesa() {

    }

    public Despesa(LocalDate data, float valor) {
        this.data = data;
        this.valor = valor;
    }

    public int getId() {
        return id;
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
