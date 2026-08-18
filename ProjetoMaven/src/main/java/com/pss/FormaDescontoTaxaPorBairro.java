package com.pss;
/**
 *
 * @author igorj
 */

public class FormaDescontoTaxaPorBairro implements IFormaDescontoTaxaEntrega {
    public String bairroCliente;
    
    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido){
        double descontoTotal = 0;
        bairroCliente = pedido.getCliente().getBairro();
        
        if(bairroCliente.equals("Centro")){
            descontoTotal = 2;
        }
        else if(bairroCliente.equals("Cidade Maravilhosa")){
            descontoTotal = 1.5;
        }
        else if(bairroCliente.equals("Bela Vista")){
            descontoTotal = 3;
        }
        //se nao for nenhum desses permanece e passa o 0 como parametro
        CupomDescontoEntrega cupom = new CupomDescontoEntrega("Bairro", descontoTotal);
        
        return cupom;
    }
    
    @Override
    public boolean seAplica(Pedido pedido){
        bairroCliente = pedido.getCliente().getBairro();
        if(bairroCliente.equals("Centro")){
            return true;
        }
        else if(bairroCliente.equals("Cidade Maravilhosa")){
            return true;
        }
        else if(bairroCliente.equals("Bela Vista")){
            return true;
        }
        else{
            return false;
        }
    }
    
}
