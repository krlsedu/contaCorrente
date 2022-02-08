package br.com.cursojava;

public class Movimento {
    private Tipo tipo;
    private Double valor;
    private String descricao;


    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "\nMovimento de " + tipo +
                " no valor " + String.format("R$ %,.2f", valor) +
                " descrição: " + descricao;
    }
}
