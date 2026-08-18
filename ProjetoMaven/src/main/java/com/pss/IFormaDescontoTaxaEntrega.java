package com.pss;
/**
 *
 * @author igorj
 */

public interface IFormaDescontoTaxaEntrega {
    CupomDescontoEntrega calcularDesconto(Pedido pedido);
    boolean seAplica(Pedido pedido);
}
