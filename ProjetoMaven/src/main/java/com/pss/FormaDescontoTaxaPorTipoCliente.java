package com.pss;
/**
 *
 * @author igorj
 */

import java.util.HashMap;
import java.util.Map;

public class FormaDescontoTaxaPorTipoCliente implements IFormaDescontoTaxaEntrega {
    private Map<String, Double> descontosPorTipoCliente;
    private String tipoCliente;
    
    public FormaDescontoTaxaPorTipoCliente() {
        descontosPorTipoCliente = new HashMap<>();
        descontosPorTipoCliente.put("Ouro", 3.00);
        descontosPorTipoCliente.put("Prata", 2.00);
        descontosPorTipoCliente.put("Bronze", 1.00);
    }
    
    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido){
        double descontoTotal = 0;
        tipoCliente = pedido.getCliente().getTipo();
        
        descontoTotal = descontosPorTipoCliente.get(tipoCliente);//o metodo get vem do proprio Map e busca o valor atraves da chave passada
        
        CupomDescontoEntrega cupom = new CupomDescontoEntrega("Cliente", descontoTotal);
        
        return cupom;
    }
    
    @Override
    public boolean seAplica(Pedido pedido){
        if(descontosPorTipoCliente.containsKey(pedido.getCliente().getTipo())){
            return true; 
        }    
        return false;
    }
    
}
