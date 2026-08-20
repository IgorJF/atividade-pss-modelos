package com.pss;

/**
 *
 * @author igorj
 */

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

class Pedido {

    private double taxaEntrega = 10.0;
    private Cliente cliente;
    private List<Item> itens = new ArrayList<>();
    private LocalDateTime data;
    private double valorTotalItens = 0;
    private List<CupomDescontoEntrega> cupons = new ArrayList<>();

    public Pedido(LocalDateTime data, Cliente cliente) {
        if (data == null) {
            throw new IllegalArgumentException("Data inválida. Informe uma data válida.");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("Informe um cliente válido");//nullpointerexecetion nao é o ideal por que cliente eh instaciado
        }
        this.data = data;
        this.cliente = cliente;
        this.itens = new ArrayList<>();//inicializar lista
        this.cupons = new ArrayList<>();//inicializar lista
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
        valorTotalItens += item.getValorTotal();
    }

    public List<CupomDescontoEntrega> getCuponsDescontoEntrega() {
        return cupons;
    }

    //mudar para todo desconto ser aplicado diretamente na taxa de entrega
    public void aplicarDesconto(double desconto) {
        double limite = 10.0;
        double concedido = getDescontoConcedido();

        double disponivel = limite - concedido;

        if (desconto > disponivel) {
            desconto = disponivel;
        }

        taxaEntrega -= desconto;
    }

    //mudar para mostrar apenas para mostrar total de desconto concedido
    public double getDescontoConcedido() {
        return 10 - taxaEntrega;
    }

    //mudar retornar o valor total do pedido já com o desconto
    public double getValorPedido() {
        return valorTotalItens - getDescontoConcedido();
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente +
                "\nData: " + data +
                "\nItens: " + itens +
                "\nValor dos Itens: R$ " + valorTotalItens +
                "\nCupons Utilizados: " + cupons +
                "\nDesconto Concedido: R$ " + getDescontoConcedido() +
                "\nTaxa de Entrega: R$ " + taxaEntrega +
                "\nValor Final do Pedido: R$ " + getValorPedido() +
                "\n";
    }
}
