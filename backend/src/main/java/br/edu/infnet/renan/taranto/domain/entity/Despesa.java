package br.edu.infnet.renan.taranto.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

@Entity
@Table(name = "despesa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entity_type")
public abstract class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Este valor não pode ser nulo.")
    private LocalDate data;

    @NotNull(message = "Este valor não pode ser nulo.")
    @PositiveOrZero(message = "Este valor deve ser maior ou igual a zero.")
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

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "data=" + data +
                ", valor=" + valor +
                '}';
    }
}
