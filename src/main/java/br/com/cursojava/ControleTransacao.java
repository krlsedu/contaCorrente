package br.com.cursojava;

import java.util.List;

public class ControleTransacao {
    private final Conta conta;

    public ControleTransacao(Conta conta) {
        this.conta = conta;
    }

    public void validaTransacao(Movimento movimento) throws TransacaoException {
        Tipo tipo = movimento.getTipo();
        if (Tipo.DEBITO.equals(tipo)) {
            Double saldoDisponivel = conta.getSaldo() + conta.getLimiteChequeEspecial();
            if (saldoDisponivel < movimento.getValor()) {
                throw new TransacaoException(movimento, conta);
            }
        }
    }

    public void movimenta(Movimento movimento) {
        Double saldo = conta.getSaldo();
        if (movimento.getTipo().equals(Tipo.DEBITO)) {
            saldo -= movimento.getValor();
        } else {
            saldo += movimento.getValor();
        }
        conta.setSaldo(saldo);
        List<Movimento> movimentos = conta.getMovimentos();
        movimentos.add(movimento);
    }
}
