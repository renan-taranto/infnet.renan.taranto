package br.edu.infnet.renan.taranto.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "moto")
public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String marca;
    private String modelo;

    public Moto() {

    }

    public Moto(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Moto{" +
                "id=" + id +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
