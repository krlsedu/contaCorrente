package br.com.cursojava;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setAgencia(1);
        conta.setNumero(12345);

        Correntista correntista = new Correntista(conta);
        correntista.setNome("Carlos Eduardo");

        leInformacoes(correntista);
    }

    private static void leInformacoes(Correntista correntista) {

        Scanner scanner = new Scanner(System.in);
        int operacao;
        do {
            try {
                System.out.println("Digite: 0 para sair, 1 para adicionar saldo, 2 para retirar saldo ou 3 para imprimir o extrato");
                operacao = scanner.nextInt();
                Movimento movimento = new Movimento();
                switch (operacao) {
                    case 0:
                        continue;
                    case 1:
                        System.out.println("Digite o saldo a acrescentar:");
                        movimento.setTipo(Tipo.CREDITO);
                        break;
                    case 2:
                        System.out.println("Digite o valor a retirar:");
                        movimento.setTipo(Tipo.DEBITO);
                        break;
                    case 3:
                        imprime(correntista);
                        continue;
                    default:
                        System.out.println("O valor informado é invalido!");
                        continue;

                }

                Double valor = scanner.nextDouble();
                movimento.setValor(valor);

                System.out.println("Digite descrição do movimento:");
                String descricao = scanner.next();
                movimento.setDescricao(descricao);
                movimenta(correntista, movimento);
            } catch (Exception e) {
                operacao = -1;
                scanner = new Scanner(System.in);
                System.out.println("O valor informado é invalido!");
            }

        } while (operacao != 0);

        System.out.println("Você saiu!");
    }

    private static void movimenta(Correntista correntista, Movimento movimento) {
//        Double saldo = correntista.getConta().getSaldo();
//        if (movimento.getTipo().equals(Tipo.DEBITO)) {
//            saldo -= movimento.getValor();
//        } else {
//            saldo += movimento.getValor();
//        }
//        correntista.getConta().setSaldo(saldo);
        correntista.getConta().getMovimentos().add(movimento);
    }

    private static void imprime(Correntista correntista) {
        System.out.println(correntista.getConta());
    }
}
