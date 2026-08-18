package com.pss;
/**
 *
 * @author igorj
 */

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Pedido {
    private double taxaEntrega = 10.0;
    private Cliente cliente;
    private List<Item> itens = new ArrayList<>();
    private LocalDateTime data;
    private double valorTotalItens = 0;
    private double descontoTotal = 0;
    private List<CupomDescontoEntrega> cupons = new ArrayList<>();
    
    public Pedido(LocalDateTime data, Cliente cliente){
        if (data == null){
            throw new IllegalArgumentException("Data inválida. Informe uma data válida.");
        }
        if (cliente == null){
            throw new NullPointerException("Informe um cliente válido");
        }
        this.data = data;
        this.cliente = cliente;
        this.itens = new ArrayList<>();//inicializar lista
        this.cupons = new ArrayList<>();//inicializar lista
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public List<Item> getItens(){
        return itens;
    }
    
    public double getTaxaEntrega(){
        return taxaEntrega;
    }
    
    public void adicionarItem(Item item){
        this.itens.add(item);
        valorTotalItens += item.getValorTotal();
    }
    
    public List<CupomDescontoEntrega> getCuponsDescontoEntrega(){
        return cupons;
    }
    
    public void aplicarDesconto(double desconto){
        double limite = 10.0;
        double concedido = getDescontoConcedido();
        
        double disponivel = limite - concedido;
        
        if(desconto > disponivel){
            desconto = disponivel;
        }
        
        taxaEntrega -= desconto;
    }
    
    public double getDescontoConcedido(){
        for (CupomDescontoEntrega cupom : cupons){
            descontoTotal += cupom.getValorDesconto();
        }
        return descontoTotal;
    }
    
    public double getValorPedido(){
        return valorTotalItens;
    }
    
    @Override
    public String toString(){
        return "Cliente: " + cliente.getNome() + "Data: " + data +"Valor Pedido: " + getValorPedido();
    }
}
