package br.edu.infnet.renan.taranto.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "historico_despesas")
public class HistoricoDespesas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Moto moto;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Despesa> despesas;
    private LocalDate dataCriacao;
    private boolean ativo;

    public HistoricoDespesas() {

    }

    public HistoricoDespesas(Moto moto) {
        this.moto = moto;
        this.despesas = new ArrayList<>();
        this.ativo = true;
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
        return "HistoricoDespesas{" +
                "id=" + id +
                ", moto=" + moto +
                ", despesas=" + despesas +
                ", dataCriacao=" + dataCriacao +
                ", ativo=" + ativo +
                '}';
    }
}
