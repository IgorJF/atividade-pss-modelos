package com.pss;

/**
 *
 * @author igorj
 */

import java.time.LocalDateTime;
import java.util.List;

//FALTA CRIAR E TRATAR AS EXECECOES

public class ProjetoMaven {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("A", "Prata", 5.0, "Rua B", "Cidade Maravilhosa", "M");
        Pedido pedido = new Pedido(LocalDateTime.of(2026, 8, 18, 01, 12, 47), cliente);
        
        Item i1 = new Item("A", 1, 12.5, "Farmacia");
        Item i2 = new Item("B", 3, 5.75, "Farmacia");
        Item i3 = new Item("C", 2, 7, "Farmacia");
        Item i4 = new Item("D", 1, 20, "Lazer");
        Item i5 = new Item("E", 4, 2.9, "Farmacia");
        
        pedido.adicionarItem(i1);
        pedido.adicionarItem(i2);
        pedido.adicionarItem(i3);
        pedido.adicionarItem(i4);
        pedido.adicionarItem(i5);
        
        System.out.println("Valor dos itens do pedido: R$ " + pedido.getValorPedido());

        CalculadoraDeDescontoService calculadoraDescontos = new CalculadoraDeDescontoService();

        List<CupomDescontoEntrega> cupons = calculadoraDescontos.calcularDesconto(pedido);//calculadora devolve a lista de cupons usados no pedido

        for (CupomDescontoEntrega cupom : cupons) {
            System.out.println(cupom.getNomeMetodo()+ " - R$ "+ cupom.getValorDesconto());
        }

        System.out.println(pedido.getDescontoConcedido());
        
        System.out.println(pedido.getTaxaEntrega());
        
        System.out.println("Valor Final Pedido: R$ " + (pedido.getValorPedido() - pedido.getDescontoConcedido()));
    }
}
