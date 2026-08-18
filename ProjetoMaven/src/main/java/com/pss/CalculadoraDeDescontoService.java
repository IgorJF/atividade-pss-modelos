package com.pss;

/**
 *
 * @author igorj
 */

import java.util.ArrayList;
import java.util.List;

class CalculadoraDeDescontoService {
    private List<IFormaDescontoTaxaEntrega> metodosDesconto;
    
    public CalculadoraDeDescontoService(){
        metodosDesconto = new ArrayList<>();
        metodosDesconto.add(new FormaDescontoTipoItem());
        metodosDesconto.add(new FormaDescontoTaxaPorBairro());
        metodosDesconto.add(new FormaDescontoValorPedido(200));
        metodosDesconto.add(new FormaDescontoTaxaPorTipoCliente());
    }
    
    public List<CupomDescontoEntrega> calcularDesconto(Pedido pedido){
        double limite = 10.00;

        for (IFormaDescontoTaxaEntrega metodo : metodosDesconto){
            if (!metodo.seAplica(pedido)) {
                continue;//se nao puder aplicar desconto, va para proximo metodo da lista, se puder vira false nao entra no if e segue para o calculo
            }
            CupomDescontoEntrega cupom = metodo.calcularDesconto(pedido);
            
            //nao precisa realizar a verificao de preco novamente

            pedido.getCuponsDescontoEntrega().add(cupom);
            pedido.aplicarDesconto(cupom.getValorDesconto());

            if (pedido.getDescontoConcedido() >= limite) {
                break;
            }
        }
        return pedido.getCuponsDescontoEntrega();
    }
}
