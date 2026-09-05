import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        ContaTerminal conta = new ContaTerminal();

        System.out.println("Por favor, digite o número da conta:");
        conta.numero = Integer.parseInt(scanner.nextLine());
        System.out.println("Por favor, digite o número da agência:");
        conta.agencia = scanner.nextLine();
        System.out.println("Por favor, digite o nome do cliente:");
        conta.nomeCliente = scanner.nextLine();
        System.out.println("Por favor, digite o saldo da conta:");
        conta.saldo = Double.parseDouble(scanner.nextLine());

        System.out.println("Olá " + conta.nomeCliente
                + ", obrigado por criar uma conta em nosso banco, sua agência é "
                + conta.agencia + ", conta " + conta.numero + " e seu saldo "
                + conta.saldo + " já está disponível para saque");

        scanner.close();
    }

}
