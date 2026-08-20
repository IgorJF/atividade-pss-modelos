package com.pss;

/**
 *
 * @author igorj
 */

import java.util.ArrayList;
import java.util.List;

class CalculadoraTaxaDeDescontoService {
    private List<IFormaDescontoTaxaEntrega> metodosDesconto;
    
    public CalculadoraTaxaDeDescontoService(){ //construtor necessario no diagrama
        metodosDesconto = new ArrayList<>();
        metodosDesconto.add(new FormaDescontoTipoItem());
        metodosDesconto.add(new FormaDescontoTaxaPorBairro());
        metodosDesconto.add(new FormaDescontoValorPedido(200));
        metodosDesconto.add(new FormaDescontoTaxaPorTipoCliente()); 
    }
    
    public void calcularDesconto(Pedido pedido){ //mudar para void, os descontos serao aplicados e guardados com o aplicarDesconto
        if(pedido == null){
            throw new IllegalArgumentException("Informe um pedido valido");
        }
        for (IFormaDescontoTaxaEntrega metodo : metodosDesconto){
            if(metodo.seAplica(pedido)){
                CupomDescontoEntrega cupom = metodo.calcularDesconto(pedido);
                pedido.aplicarDesconto(cupom.getValorDesconto());
                pedido.getCuponsDescontoEntrega().add(cupom);
            }
        }
        //mudar para nao precisar retornar a lista, os cupons ficarao guardados diretamente na classe de cupons, que vai ser chamada em aplicarCupom em pedido
    }
}
