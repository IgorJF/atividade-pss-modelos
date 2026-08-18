package com.pss;
/**
 *
 * @author igorj
 */



class CupomDescontoEntrega {
    private String nomeMetodo;
    private double valorDesconto;
    
    public CupomDescontoEntrega(String nomeMetodo, double valorDesconto){
        this.nomeMetodo = nomeMetodo;
        this.valorDesconto = valorDesconto;
    }
    
    public double getValorDesconto(){
        return valorDesconto;
    }
    
    public String getNomeMetodo(){
        return nomeMetodo;
    }
    
    @Override
    public String toString(){
        return "Nome Metodo: " + nomeMetodo + "Valor Desconto: " + valorDesconto;
    }
    
}
