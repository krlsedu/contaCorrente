package br.com.cursojava;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private Integer agencia;
    private Integer numero;
    private Double saldo;
    private List<Movimento> movimentos;

    public Conta(){
        this.saldo = 0D;
        this.movimentos = new ArrayList<>();
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<Movimento> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(List<Movimento> movimentos) {
        this.movimentos = movimentos;
    }

    @Override
    public String toString() {
        return "Agencia:" + agencia +
                ", Número da conta:" + numero +
                "\nSaldo atual:" + String.format("R$ %,.2f",saldo) +
                "\nMovimentos:" + movimentos ;
    }
}
