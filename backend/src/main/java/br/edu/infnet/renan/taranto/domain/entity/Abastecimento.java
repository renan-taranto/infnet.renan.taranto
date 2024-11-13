package br.edu.infnet.renan.taranto.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("abastecimento")
public class Abastecimento extends Despesa {
    private float litrosAbastecidos;
    private String tipoCombustivel;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;

    public Abastecimento() {

    }

    public Abastecimento(LocalDate data, float valor, float litrosAbastecidos, String tipoCombustivel) {
        super(data, valor);
        this.litrosAbastecidos = litrosAbastecidos;
        this.tipoCombustivel = tipoCombustivel;
    }

    public float getLitrosAbastecidos() {
        return litrosAbastecidos;
    }

    public void setLitrosAbastecidos(float litrosAbastecidos) {
        this.litrosAbastecidos = litrosAbastecidos;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Abastecimento{" +
                "litrosAbastecidos=" + litrosAbastecidos +
                ", tipoCombustivel='" + tipoCombustivel + '\'' +
                ", endereco=" + endereco +
                "} " + super.toString();
    }
}
