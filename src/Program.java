import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main (String[] args) {
        Locale.setDefault(Locale.US);

        Scanner teclado = new Scanner(System.in);
        ContaBancaria contaBancaria = new ContaBancaria();

        contaBancaria = contaBancaria.LerDados(teclado);
        contaBancaria.ExibirDados();

        double valorSaque = contaBancaria.LerValorSaque(teclado);
        contaBancaria.RealizarSaque(valorSaque);

        double valorDeposito = contaBancaria.LerValorDeposito(teclado);
        contaBancaria.RealizarDeposito(valorDeposito);
    }
}
