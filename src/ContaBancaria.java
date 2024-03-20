import java.util.Scanner;

public class ContaBancaria {

    public  String numConta;
    public  String cpfDonoConta;
    public  double saldo;
    public  double limite;


    /**
     * Construtor para classe Conta Bancaria.
     * @param numConta Numero da conta do usuário.
     * @param cpfDonoConta CPF do usuário.
     * @param saldo Saldo do usuário.
     * @param limite Limite do usuário (Serve para sacar um dinheiro a mais caso você não queira utilizar o
     *               débito ou não tenha no momento).
     */
    public ContaBancaria (String numConta, String cpfDonoConta, double saldo, double limite) {
        this.numConta = numConta;
        this.cpfDonoConta = cpfDonoConta;
        this.saldo = saldo;
        this.limite = limite;
    }

    /**
     * Construtor vazio para a classe Conta Bancaria
     */
    public ContaBancaria () {

    }

    /**
     * Método para ler os dados da conta do usuário.
     * @param teclado Scanner utilizado para pegar os dados digitados pelo usuário.
     */
    public ContaBancaria LerDados (Scanner teclado) {
        System.out.print("Digite o numero da sua conta: ");
        String numConta = teclado.nextLine();
        if(numConta.length() == 5) {
            System.out.print("Digite o cpf da conta: ");
            String cpfConta = teclado.nextLine();
            System.out.print("Qual o saldo inicial? ");
            double saldo = Double.parseDouble(teclado.nextLine());
            System.out.print("Qual o limite da sua conta? ");
            double limite = Double.parseDouble(teclado.nextLine());

            return new ContaBancaria(numConta,cpfConta,saldo,limite);
        }
        else {
            return new ContaBancaria();
        }
    }

    /**
     * Método utilizado para exibir os dados do usuário.
     */
    public void ExibirDados() {
          if (this.numConta != null) {
              System.out.println("----------------------------------------------------------");
              System.out.println("NUMERO DA CONTA: " + numConta);
              System.out.println("CPF: " + cpfDonoConta);
              System.out.printf("SALDO ATUAL: %.2f$ %n", saldo);
              System.out.printf("LIMITE: %.2f$ %n ", limite);
              System.out.println("----------------------------------------------------------");
          }
          else {
              System.out.println("----------------------------------------------------------");
              System.out.println("ERRO");
              System.out.println("O numero da conta precisa ter 5 digitos");
              System.out.println("----------------------------------------------------------");
              System.exit(0);
          }
         }

    /**
     * Método para ler o valor que o usuário deseja sacar.
     *
     * @param teclado Scanner utilizado para salvar os dados digitados pelo usuário.
     * @return Double com o valor que o usuário irá sacar.
     */
    public double LerValorSaque(Scanner teclado) {
        System.out.print("Qual valor deseja sacar? ");

        return Double.parseDouble(teclado.nextLine());
    }

    /**
     * Método utilizado para somar o saldo e o limite, resultando no máximo que o usuário consiga sacar.
     * @param saldo Valor na conta do usuário.
     * @param limite Limite do usuário (Serve para sacar um dinheiro a mais caso você não queira utilizar o
     *               débito ou até não tenha o dinheiro na conta no momento.
     * @return Double com o maior valor que o usuário consegue sacar.
     */
    public double possivelSaque(double saldo, double limite) {
        return saldo + limite;
    }

    /**
     * Método utilizado para processar o saque do usuário. É verificado se o valorSaque <= que a soma do
     * seu saldo + limite e se o valorSaque > 0. Sendo assim, o saque é efetuado com sucesso.
     *
     * @param valorSaque Valor que o usuário deseja sacar.
     */
    public void RealizarSaque(double valorSaque) {
        if (valorSaque > 0.0) {

            if (valorSaque <= possivelSaque(saldo, limite)) {
                saldo -= valorSaque;
                System.out.printf("Saque realizado com sucesso --- [Saldo atual: %.2f$] %n",saldo);
                System.out.println("----------------------------------------------------------");
            } else {
                System.out.println("O valor de saque desejado não está de acordo com as possibilidades do sistema");
                System.out.println("----------------------------------------------------------");
            }

        }
        else {
            System.out.println("O valor de saque desejado não está de acordo com as possibilidades do sistema");
            System.out.println("----------------------------------------------------------");
        }
    }

    /**
     * Método para ler o valor que o usuário deseja depositar.
     * @param teclado Scanner utilizado para salvar os dados digitados pelo usuário.
     * @return Double com o valor que o usuário irá depositar.
     */
    public double LerValorDeposito (Scanner teclado) {
        System.out.print("Qual valor deseja depositar? ");

        return Double.parseDouble(teclado.nextLine());
    }

    /**
     * Método utilizado para processar o depósito do usuário. Se o saldo atual < 0, o depósito vem com uma taxa
     * de 3% em relação ao valor negativo.
     * @param valorDeposito Valor que o usuário deseja depositar em sua conta.
     */
    public void RealizarDeposito (double valorDeposito) {

        if (valorDeposito > 0.0) if (saldo > 0) {
            saldo += valorDeposito;
            System.out.println();
            System.out.printf("Deposito realizado com sucesso --- [Saldo atual: %.2f$] ",saldo);
            System.out.println();
            System.out.println("----------------------------------------------------------");
        } else {
            saldo += valorDeposito + (saldo * 0.03);
            System.out.println("Devido a utilização do seu limite no ultimo saque, será cobrado uma taxa de 3% em relação ao valor que está em débito.");
            System.out.printf("Deposito realizado com sucesso --- [Saldo atual: %.2f$] ",saldo);
            System.out.println();
            System.out.println("----------------------------------------------------------");

        }
        else {
            System.out.println("Não é possível depositar um valor negativo");
            System.out.println("----------------------------------------------------------");
        }
    }

}
