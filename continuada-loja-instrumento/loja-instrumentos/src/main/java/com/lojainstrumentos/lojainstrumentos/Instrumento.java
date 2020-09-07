package com.lojainstrumentos.lojainstrumentos;

public abstract class Instrumento {

    private String nome;
    private String categoria;
    private String marca;
    private Double preco;

    public Instrumento(String nome, String categoria, String marca, Double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.marca = marca;
        this.preco = preco;
    }

    public abstract Double lucroInstrumento();

    @Override
    public String toString() {
        return "Instrumento{" +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", marca='" + marca + '\'' +
                ", preco=" + preco +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public Double getPreco() {
        return preco;
    }
}
