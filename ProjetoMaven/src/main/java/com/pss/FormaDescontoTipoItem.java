package com.pss;
/**
 *
 * @author igorj
 */

import java.util.HashMap;
import java.util.Map;

class FormaDescontoTipoItem implements IFormaDescontoTaxaEntrega{
    private Map<String, Double> descontosPorTipoItem;
    
    public FormaDescontoTipoItem() {
        descontosPorTipoItem = new HashMap<>();//para nao manter ordem especifica e ter relacao chave-valor
        descontosPorTipoItem.put("Alimentacao", 5.00);
        descontosPorTipoItem.put("Educacao", 2.00);
        descontosPorTipoItem.put("Lazer", 1.50);
    } 
    
    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido){
        double descontoTotal = 0;
        
        for(Item item : pedido.getItens()){
            String tipo = item.getTipo();
            if(descontosPorTipoItem.containsKey(tipo)){
                descontoTotal += descontosPorTipoItem.get(tipo);
            }
        }
        
        CupomDescontoEntrega cupom = new CupomDescontoEntrega("Item", descontoTotal);
        
        return cupom;
    }
    
    @Override
    public boolean seAplica(Pedido pedido){
        for(Item item : pedido.getItens()){
            if(descontosPorTipoItem.containsKey(item.getTipo())){
                return true; 
                //nao conhecia essa abordagem com containsKey
                //metodo Map que verifica se existe uma determinada chave dentro da estrutura
            }    
        }
        return false;
    }  
}
