package com.lojainstrumentos.lojainstrumentos;

public class Bateria extends Instrumento {

    public Bateria(String nome, String categoria, String marca, Double preco) {
        super(nome, categoria, marca, preco);
    }

    @Override
    public Double lucroInstrumento() {
        return (this.getPreco() + (this.getPreco() * 0.15));
    }

    @Override
    public String toString() {
        return "Bateria{} " + super.toString() + lucroInstrumento();
    }
}
