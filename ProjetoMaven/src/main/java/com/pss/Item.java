package com.pss;
/**
 *
 * @author igorj
 */

class Item {
    private String nome;
    private int quantidade;
    private double valorUnitario;
    private String tipo;
    
    public Item(String nome, int quantidade, double valorUnitario, String tipo){
        if (nome == null){
            throw new IllegalArgumentException("Informe um nome do item válido");
        }
        if (tipo == null){
            throw new IllegalArgumentException("Informe um tipo de item válido");
        }
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
    }
    
    public double getValorTotal(){
        return valorUnitario * quantidade;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    @Override
    public String toString(){
        return "Nome: " + nome + " | Quantidade: " + quantidade + " | Valor Unitario: " + valorUnitario + " | Tipo: " + tipo;
    }
}
