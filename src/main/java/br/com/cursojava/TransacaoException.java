package br.com.cursojava;

public class TransacaoException extends Exception {
    public TransacaoException(Movimento movimento, Conta conta) {
        super(String.format("Não foi possível realizar o movimento %s no valor de R$ %,.2f devido a falta de saldo! O saldo disponível é R$ %,.2f", movimento.getDescricao(), movimento.getValor(), conta.getSaldo()));
    }
}
