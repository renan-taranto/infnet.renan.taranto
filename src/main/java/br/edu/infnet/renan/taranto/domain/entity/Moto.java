package br.edu.infnet.renan.taranto.domain.entity;

public class Moto {
    private int id;

    public Moto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "id=" + id +
                '}';
    }
}
