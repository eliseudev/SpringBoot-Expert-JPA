package io.github.eliseudev.model;

public class Cliente {
    public Cliente() {
    }

    public Cliente(String nomeCliente) {
        NomeCliente = nomeCliente;
    }

    public Cliente(Integer id, String nomeCliente) {
        this.id = id;
        NomeCliente = nomeCliente;
    }

    private Integer id;
    private String NomeCliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }
}
