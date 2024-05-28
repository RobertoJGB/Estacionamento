import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BOX = "\u001B[51m";

    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento(5, 5);
        Scanner ler = new Scanner(System.in);

        while (true) {
            System.out.println("\n===================================================");
            System.out.print("-----------");
            System.out.print(ANSI_BOX + " Bem-vindo ao EstacioneAqui! " + ANSI_RESET);
            System.out.print("-----------");
            System.out.println("\n===================================================");
            System.out.println("\n1. Registrar entrada de veículo");
            System.out.println("2. Registrar saída de veículo");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = ler.nextInt();
            ler.nextLine();

            if (opcao == 1) {
                System.out.print("Digite a placa do veículo: ");
                String placa = ler.nextLine();

                System.out.print("Digite o CPF: ");
                String cpf = ler.nextLine();

                System.out.print("Digite o tipo do veículo (1 para carro, 2 para moto): ");
                int tipoVeiculo = ler.nextInt();

                System.out.print("Digite o tipo da vaga (1 para coberta, 2 para descoberta): ");
                int tipoVaga = ler.nextInt();

                System.out.print("Digite a hora de entrada: ");
                int horaEntrada = ler.nextInt();

                System.out.print("Digite os minutos de entrada: ");
                int minutoEntrada = ler.nextInt();
                ler.nextLine();

                Veiculo veiculo = new Veiculo(placa, cpf, tipoVeiculo);
                RegistroEntrada registro = estacionamento.registrarEntrada(veiculo, tipoVaga, horaEntrada, minutoEntrada);

                if (registro != null) {
                    System.out.println(ANSI_GREEN + "Entrada registrada com sucesso!" + ANSI_RESET);
                } else {
                    System.out.println(ANSI_RED + "Não foi possível registrar a entrada. Vaga indisponível." + ANSI_RESET);
                }
            } else if (opcao == 2) {
                System.out.print("Digite a placa do veículo: ");
                String placa = ler.nextLine();

                RegistroEntrada registro = estacionamento.encontrarRegistroPorPlaca(placa);

                if (registro != null) {
                    System.out.print("Digite a hora de saída: ");
                    int horaSaida = ler.nextInt();

                    System.out.print("Digite os minutos de saída: ");
                    int minutoSaida = ler.nextInt();
                    ler.nextLine();

                    estacionamento.registrarSaida(registro, horaSaida, minutoSaida);
                    System.out.println(ANSI_GREEN + "\nSaída registrada com sucesso!" + ANSI_RESET);
                } else {
                    System.out.println(ANSI_GREEN + "\nVeículo não encontrado." + ANSI_RESET);
                }
            } else if (opcao == 3) {
                System.out.println(ANSI_GREEN + "Saindo do sistema. Obrigado por EstacionarAqui ;)!" + ANSI_RESET);
                break;
            } else {
                System.out.println(ANSI_RED + "Opção inválida. Tente novamente." + ANSI_RESET);
            }
        }
    }
}
