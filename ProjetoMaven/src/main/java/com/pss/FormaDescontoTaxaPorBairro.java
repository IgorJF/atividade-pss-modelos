package com.pss;
/**
 *
 * @author igorj
 */

import java.util.HashMap;
import java.util.Map;

public class FormaDescontoTaxaPorBairro implements IFormaDescontoTaxaEntrega {
    private Map<String, Double> bairroCliente;
    
    public FormaDescontoTaxaPorBairro() {
        bairroCliente = new HashMap<>();
        bairroCliente.put("Centro", 2.00);
        bairroCliente.put("Cidade Maravilhosa", 1.50);
        bairroCliente.put("Bela Vista", 3.00);
    } 
    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido){
        double descontoTotal = 0;
        descontoTotal = bairroCliente.get(pedido.getCliente().getBairro());
        CupomDescontoEntrega cupom = new CupomDescontoEntrega("Bairro", descontoTotal);
        return cupom;
    }
    
    @Override
    public boolean seAplica(Pedido pedido){
        if (bairroCliente.containsKey(pedido.getCliente().getBairro())){
            return true;
        }
        return false;
    }
    
}
