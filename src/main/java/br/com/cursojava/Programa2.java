package br.com.cursojava;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Programa2 {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setAgencia(12);
        conta.setNumero(123456);

        Correntista correntista = new Correntista();
        correntista.setConta(conta);
        correntista.setNome("Carlos Eduardo");

        leMovimentos(correntista);
    }

    private static void leMovimentos(Correntista correntista) {

        String operacao;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Informe a operação a realizar (d - Débito, c - credito, i - imprimir extrato e s para sair)");
                operacao = scanner.nextLine().toLowerCase().trim();
                Movimento movimento = new Movimento();
                switch (operacao) {
                    case "d":
                        movimento.setTipo(Tipo.DEBITO);
                        //debito
                        break;
                    case "c":
                        //credito
                        movimento.setTipo(Tipo.CREDITO);
                        break;
                    case "i":
                        //impressão do extrato
                        imprime(correntista.getConta());
                        continue;
                    case "s":
                        //Sair do programa
                        continue;
                    default:
                        System.out.println("Operação inválida");
                        continue;
                }

                System.out.println("Informe o valor do movimento:");
                scanner = new Scanner(System.in);
                Double valor = scanner.nextDouble();
                movimento.setValor(valor);

                System.out.println("Informe a descrição do movimento:");
                scanner = new Scanner(System.in);
                String descricao = scanner.nextLine();
                movimento.setDescricao(descricao);

                Conta conta = correntista.getConta();
                List<Movimento> movimentos = conta.getMovimentos();
                movimentos.add(movimento);
            } catch (InputMismatchException e) {
                operacao = "";
                System.out.println("O valor informado é inválido! " + e.getMessage());

            } catch (Exception e) {
                operacao = "";
                System.out.println("Houve um erro ao processar sua solicitação!");
            }

        } while (!operacao.equalsIgnoreCase("s"));
        System.out.println("Saiu");
    }

    private static void imprime(Conta conta) {
        List<Movimento> movimentos = conta.getMovimentos();

        for (int i = 0; i < movimentos.size(); i++) {
            Movimento movimento = movimentos.get(i);
            System.out.printf("Movimento de %s no valor de R$ %,.2f referente a %s \n", movimento.getTipo(), movimento.getValor(), movimento.getDescricao());
        }
    }
}
