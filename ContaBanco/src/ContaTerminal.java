import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Banco banco = new Banco();
        banco.setContas(new ArrayList<>());

        boolean criarConta;
        do {
            Cliente cliente = cadastrarCliente(scanner);
            Conta conta = criarConta(scanner, cliente);

            banco.getContas().add(conta);

            System.out.println("Olá " + cliente.getNome()
                    + ", obrigado por criar uma conta em nosso banco, sua agência é "
                    + conta.getAgencia() + ", conta " + conta.getNumero()
                    + " e seu saldo é R$ "
                    + String.format(Locale.US, "%.2f", conta.getSaldo()));

            gerenciarTransacoes(scanner, banco.getContas(), conta);
            criarConta = confirmar(scanner, "Deseja criar uma nova conta? (S/N)");
        } while (criarConta);

        System.out.println("\n=== Clientes e contas cadastrados ===");
        for (Conta conta : banco.getContas()) {
            Cliente cliente = conta.getCliente();
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Profissão: " + cliente.getProfissao());
            conta.imprimirExtrato();
            System.out.println();
        }

        scanner.close();
    }

    private static Cliente cadastrarCliente(Scanner scanner) {
        Cliente cliente = new Cliente();

        System.out.println("\nPor favor, digite o nome do cliente:");
        cliente.setNome(scanner.nextLine());
        System.out.println("Por favor, digite o CPF do cliente:");
        cliente.setCpf(scanner.nextLine());
        System.out.println("Por favor, digite a profissão do cliente:");
        cliente.setProfissao(scanner.nextLine());

        return cliente;
    }

    private static Conta criarConta(Scanner scanner, Cliente cliente) {
        System.out.println("Selecione o tipo de conta:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");

        Conta conta;
        int tipoConta = lerInteiro(scanner);
        if (tipoConta == 2) {
            conta = new ContaPoupanca(cliente);
        } else {
            conta = new ContaCorrente(cliente);
        }

        System.out.println("Por favor, digite o saldo inicial da conta:");
        double saldoInicial = lerValorPositivo(scanner);
        conta.depositar(saldoInicial);
        return conta;
    }

    private static void gerenciarTransacoes(Scanner scanner, List<Conta> contas, Conta contaAtual) {
        boolean continuar;
        do {
            System.out.println("\nDeseja efetuar alguma transação?");
            System.out.println("1 - Depósito");
            System.out.println("2 - Saque");
            System.out.println("3 - Transferência");
            System.out.println("4 - Encerrar transações desta conta");

            int opcao = lerInteiro(scanner);
            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor do depósito:");
                    contaAtual.depositar(lerValorPositivo(scanner));
                    break;
                case 2:
                    System.out.println("Digite o valor do saque:");
                    realizarSaque(scanner, contaAtual);
                    break;
                case 3:
                    Conta contaDestino = selecionarContaDestino(scanner, contas, contaAtual);
                    if (contaDestino != null) {
                        System.out.println("Digite o valor da transferência:");
                        realizarTransferencia(scanner, contaAtual, contaDestino);
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            continuar = opcao != 4;
        } while (continuar);
    }

    private static Conta selecionarContaDestino(Scanner scanner, List<Conta> contas, Conta contaAtual) {
        System.out.println("Selecione a conta de destino:");
        boolean existeContaDestino = false;
        for (Conta conta : contas) {
            if (conta != contaAtual) {
                System.out.println(conta.getNumero() + " - Conta " + conta.getNumero());
                existeContaDestino = true;
            }
        }

        if (!existeContaDestino) {
            System.out.println("Ainda não existe outra conta cadastrada.");
            return null;
        }

        int numeroDestino = lerInteiro(scanner);
        for (Conta conta : contas) {
            if (conta != contaAtual && conta.getNumero() == numeroDestino) {
                return conta;
            }
        }

        System.out.println("Conta de destino não encontrada.");
        return null;
    }

    private static void realizarSaque(Scanner scanner, Conta conta) {
        double valor = lerValorPositivo(scanner);
        if (valor <= conta.getSaldo()) {
            conta.sacar(valor);
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    private static void realizarTransferencia(Scanner scanner, Conta contaOrigem, Conta contaDestino) {
        double valor = lerValorPositivo(scanner);
        if (valor <= contaOrigem.getSaldo()) {
            contaOrigem.transferir(valor, contaDestino);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    private static boolean confirmar(Scanner scanner, String mensagem) {
        System.out.println(mensagem);
        return scanner.nextLine().trim().equalsIgnoreCase("S");
    }

    private static int lerInteiro(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private static double lerDecimal(Scanner scanner) {
        return Double.parseDouble(scanner.nextLine().trim());
    }

    private static double lerValorPositivo(Scanner scanner) {
        double valor;
        do {
            valor = lerDecimal(scanner);
            if (valor <= 0) {
                System.out.println("O valor deve ser maior que zero. Digite novamente:");
            }
        } while (valor <= 0);
        return valor;
    }

}
