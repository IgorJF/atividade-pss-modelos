package com.pss;

/**
 *
 * @author igorj
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//https://github.com/IgorJF/atividade-pss-modelos

public class ProjetoMaven {

    public static void main(String[] args) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        
        try{
            Cliente cliente = new Cliente("A", "Ouro", 5.0, "Rua B", "Cidade Maravilhosa", "M");
            Cliente cliente2 = new Cliente("B", "Prata", 3.5, "Avenida C", "Guararema", "F");
            Cliente cliente3 = new Cliente("C", "Bronze", 8.0, "Rua D", "Centro", "M");
            Pedido pedido1 = new Pedido(LocalDateTime.of(2026, 8, 18, 01, 12, 47), cliente);
            Item i1 = new Item("A", 1, 12.5, "Farmacia");
            Item i2 = new Item("B", 3, 5.75, "Farmacia");
            Item i3 = new Item("C", 2, 7, "Farmacia");
            Item i4 = new Item("D", 1, 20, "Lazer");
            Item i5 = new Item("E", 4, 2.9, "Farmacia");
            pedido1.adicionarItem(i1);
            pedido1.adicionarItem(i2);
            pedido1.adicionarItem(i3);
            pedido1.adicionarItem(i4);
            pedido1.adicionarItem(i5);

            Pedido pedido2 = new Pedido(LocalDateTime.of(2026, 8, 18, 10, 30, 15), cliente2);
            Item i6 = new Item("F", 2, 15.0, "Alimentacao");
            Item i7 = new Item("G", 1, 35.5, "Lazer");
            pedido2.adicionarItem(i6);
            pedido2.adicionarItem(i7);

            Pedido pedido3 = new Pedido(LocalDateTime.of(2026, 8, 18, 14, 20, 30), cliente3);
            Item i8 = new Item("J", 1, 200, "Eletronicos");
            Item i9 = new Item("K", 2, 12.5, "Educacao");
            Item i10 = new Item("L", 3, 6.75, "Alimentacao");
            pedido3.adicionarItem(i8);
            pedido3.adicionarItem(i9);
            pedido3.adicionarItem(i10);
            Pedido pedido4 = new Pedido(LocalDateTime.of(2026, 8, 18, 16, 45, 10), cliente3);
            Item i13 = new Item("M", 1, 75.0, "Educacao");
            pedido4.adicionarItem(i13);
            
            //Pedido pedidoTeste = new Pedido(null, cliente);

            pedidos.add(pedido1);
            pedidos.add(pedido2);
            pedidos.add(pedido3);
            pedidos.add(pedido4);
            //pedidos.add(pedidoTeste);//puxa erro de data invalida
            
        }
        catch(IllegalArgumentException iaex){
            System.out.println("Erro: " + iaex.getMessage());
        }

        int i = 1;
        
        //mudar for para apenas chamar o toString do pedido e mostrar tudo
        try{
            for (Pedido pedido : pedidos){
                CalculadoraTaxaDeDescontoService calculaDesconto = new CalculadoraTaxaDeDescontoService();
                calculaDesconto.calcularDesconto(pedido);
                System.out.println("Pedido - " + i);
                System.out.println(pedido);
                i++;
                //calculaDesconto.calcularDesconto(null); //da o erro de informe um pedido valido
            }
        }
        catch(IllegalArgumentException iaex){
            System.out.println("Erro: " + iaex.getMessage());
        }
    }
}
