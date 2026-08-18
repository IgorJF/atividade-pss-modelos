package com.pss;
/**
 *
 * @author igorj
 */

public class FormaDescontoValorPedido implements IFormaDescontoTaxaEntrega {
    private double limiteValorPedido;
    private double VALOR_DESCONTO = 5.00;
    
    public FormaDescontoValorPedido(double limiteValorPedido) {
        this.limiteValorPedido = limiteValorPedido;
    }
    
    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido){
        CupomDescontoEntrega cupom = new CupomDescontoEntrega("Valor Pedido", VALOR_DESCONTO);
        return cupom;
    }
    
    @Override
    public boolean seAplica(Pedido pedido){
        if(pedido.getValorPedido() > limiteValorPedido){
            return true;
        }
        return false;
    }
}
