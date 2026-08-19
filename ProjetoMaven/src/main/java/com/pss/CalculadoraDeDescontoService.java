package com.pss;

/**
 *
 * @author igorj
 */

import java.util.ArrayList;
import java.util.List;

class CalculadoraDeDescontoService {
    private List<IFormaDescontoTaxaEntrega> metodosDesconto;
    
    public CalculadoraDeDescontoService(){ //construtor necessario no diagrama
        metodosDesconto = new ArrayList<>();
        metodosDesconto.add(new FormaDescontoTipoItem());
        metodosDesconto.add(new FormaDescontoTaxaPorBairro());
        metodosDesconto.add(new FormaDescontoValorPedido(200));
        metodosDesconto.add(new FormaDescontoTaxaPorTipoCliente()); 
    }
    
    public List<CupomDescontoEntrega> calcularDesconto(Pedido pedido){ //mudar para void, os descontos serao aplicados e guardados com o aplicarDesconto
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
        return pedido.getCuponsDescontoEntrega();//mudar para nao precisar retornar a lista, os cupons ficarao guardados diretamente na classe de cupons, que vai ser chamada em aplicarCupom em pedido
    }
}
