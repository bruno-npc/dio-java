import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numeroConta = 0;
        int numeroAgencia = 0;
        String nomeCliente = "";
        double saldo = 0.0;

        try {
            System.out.println("Por favor, digite o número da Conta:");
            numeroConta = lerNumeroConta(scanner);

            System.out.println("Por favor, digite o número da Agência:");
            numeroAgencia = lerNumeroAgencia(scanner);

            System.out.println("Por favor, digite o nome do Cliente:");
            nomeCliente = scanner.nextLine();

            System.out.println("Por favor, digite o saldo inicial:");
            saldo = lerSaldo(scanner);

        } catch (InputMismatchException e) {
            System.out.println("Erro: O valor inserido não é válido. Por favor, insira os dados corretamente.");
        }

        exibirMensagemBoasVindas(nomeCliente, numeroAgencia, numeroConta, saldo);
        scanner.close();
    }

    private static int lerNumeroConta(Scanner scanner) {
        int numeroConta = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                numeroConta = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, insira um número inteiro válido para a Conta.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return numeroConta;
    }

    private static int lerNumeroAgencia(Scanner scanner) {
        int numeroAgencia = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                numeroAgencia = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, insira um número inteiro válido para a Agência.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return numeroAgencia;
    }

    private static double lerSaldo(Scanner scanner) {
        double saldo = 0.0;
        boolean validInput = false;
        while (!validInput) {
            try {
                saldo = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, insira um valor numérico válido para o saldo.");
                scanner.nextLine();
            }
        }
        return saldo;
    }

    private static void exibirMensagemBoasVindas(String nomeCliente, int numeroAgencia, int numeroConta, double saldo) {
        if (nomeCliente.isEmpty()) {
            System.out.println("Erro: Não foi possível criar a conta devido a dados incompletos.");
        } else {
            String mensagem = String.format("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %d, conta %d e seu saldo %.2f já está disponível para saque.", 
                                            nomeCliente, numeroAgencia, numeroConta, saldo);
            System.out.println(mensagem);
        }
    }
}
