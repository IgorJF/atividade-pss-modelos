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
        metodosDesconto.add(new FormaDescontoValorPedido());
        metodosDesconto.add(new FormaDescontoTaxaPorTipoCliente());
    }
    
    public List<CupomDescontoEntrega> calcularDesconto(Pedido pedido){
        
    }
}
