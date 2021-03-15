package pedreira.machado.rodrigo;

import java.util.Scanner;

public class Sistema {

    private boolean executarSistema;
    private Scanner scanner;
    private Conta conta;

    public Sistema() {
        this.executarSistema = true;
        this.scanner = new Scanner(System.in);
        this.conta = new Conta("Luigi", 1235, 1000);
    }

    public void executar() {
        int opcao;
        while (executarSistema) {
            exibirMenu();
            opcao = scanner.nextInt();
            avaliarOpcao(opcao);
        }
    }

    private void avaliarOpcao(int opcao){
        switch(opcao){
            case 0:
                System.out.println("Obrigado, ate a proxima.");
                this.executarSistema = false;
                break;
            case 1:
                System.out.println("Saldo: R$" + this.conta.getSaldo());
                break;
            case 2:
                System.out.println("Depositar quanto?");
                double valorParaDepositar = scanner.nextDouble();
                this.conta.depositar(valorParaDepositar);
                System.out.println("Depositou com sucesso.");
                break;
            case 3:
                System.out.println("Sacar quanto?");
                double valorParaSacar = scanner.nextDouble();
                if(this.conta.sacar(valorParaSacar)) {
                    System.out.println("Sacar sucesso.");
                }
                else {
                    System.out.println("Nao sacou.");
                }
                break;
            case 4:
                System.out.println("Nao tem 4 ainda.");
                break;
            case 5:
                System.out.println("Nome do Titulo a pagar:");
                String nomeTitulo = scanner.next();
                System.out.println("Valor do titulo:");
                double valorTitulo = scanner.nextDouble();
                System.out.println("Valor do juros por dia:");
                double valorJurosPorDia = scanner.nextDouble();
                System.out.println("informe a data (aaaa-mm-dd):");
                String dataVencimentoTitulo = scanner.next();
                Titulo titulo = new Titulo(valorTitulo, nomeTitulo, valorJurosPorDia,dataVencimentoTitulo);
                if(this.conta.sacar(titulo.getValorPagamento())) {
                    System.out.println("Titulo Pago");
                }
                else {
                    System.out.println("Nao pagou");
                }
                break;
            default:
                System.out.println("Opcao ainda nao implementada!");
                break;
        }
    }

    private void exibirMenu() {
        System.out.println("Bem vindo ao MauaBank");
        System.out.println("1 - Visualiszar Saldo");
        System.out.println("2 - Depositar dinheiro");
        System.out.println("3 - Sacar dinheiro");
        System.out.println("4 - Transferir dinheiro");
        System.out.println("5 - Pagar conta (título)");
        System.out.println("0 - Encerrar Sistema");
    }
}