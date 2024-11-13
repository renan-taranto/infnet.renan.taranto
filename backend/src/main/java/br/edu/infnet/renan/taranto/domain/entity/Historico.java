package br.edu.infnet.renan.taranto.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "historico")
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(orphanRemoval = true)
    private Moto moto;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Despesa> despesas;
    private LocalDate dataCriacao;
    private boolean ativo;

    public Historico() {

    }

    public Historico(Moto moto, LocalDate dataCriacao) {
        this.moto = moto;
        this.despesas = new ArrayList<>();
        this.dataCriacao = dataCriacao;
        this.ativo = true;
    }

    public int getId() {
        return id;
    }

    public Moto getMoto() {
        return moto;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void adicionarDespesa(Despesa despesa) {
        this.despesas.add(despesa);
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    @Override
    public String toString() {
        return "Historico{" +
                "id=" + id +
                ", moto=" + moto +
                ", despesas=" + despesas +
                ", dataCriacao=" + dataCriacao +
                ", ativo=" + ativo +
                '}';
    }
}
