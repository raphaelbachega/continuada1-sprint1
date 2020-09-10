package com.lojainstrumentos.lojainstrumentos;

public class Guitarra extends Instrumento {

    public Guitarra(String nome, String categoria, String marca, Double preco) {
        super(nome, categoria, marca, preco);
    }

    @Override
    public Double lucroInstrumento() {
        return (this.getPreco() + (this.getPreco() * 0.2));
    }

    @Override
    public String toString() {
        return "Guitarra\n" + super.toString();
    }
}
