package br.edu.infnet.renan.taranto.domain.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("manutencao")
public class Manutencao extends Despesa {
    @NotBlank(message = "Este valor não pode ser vazio.")
    @Size(max = 50, message = "Este valor ter no máximo 50 caracteres.")
    private String tipo;

    @NotBlank(message = "Este valor não pode ser vazio.")
    @Size(max = 250, message = "Este valor ter no máximo 250 caracteres.")
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Manutencao{" +
                "tipo='" + tipo + '\'' +
                ", observacoes='" + observacoes + '\'' +
                "} " + super.toString();
    }
}
