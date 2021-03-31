/** Autores:
 *      Rodrigo Machado Pedreira        18.01569-7
 *      Gabriel Gomes Bermudi Santos    18.00947-6
 */

package Trabalhos.Atividade1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Atividade1: Controla o sistema, unico ponto de I/O, todas as interacoes entre classes ocorrem aqui.
 */

public class Atividade1 {

    private Scanner scanner;
    private Map<String, Usuarios> mapaUsuarios;
    private boolean boolExecutarSistema;

    public Atividade1() {
        this.scanner = new Scanner(System.in);
        mapaUsuarios = new TreeMap<String, Usuarios>();
        this.boolExecutarSistema = true;
    }

    public void executar() {
        // private int i = 0;
        int keyMenu;

        while (boolExecutarSistema) {
            exibirMenu();
            keyMenu = Integer.parseInt(scanner.nextLine().replaceAll(" ", "")); // FIXME: Se nao for numero trava
                                                                                // programa.
            executarMenu(keyMenu);
        }
    }

    private void executarMenu(int switchKey) {

        String nome, senha, email, recebedor, pagador, QRCode;
        double valor;

        switch (switchKey) {
        case 1: /* Criar novo Usuario e uma nova Conta para este Usuario */
            System.out.println("Insira o nome do Usuario:");
            nome = scanner.nextLine().trim();

            System.out.println("Insira uma senha:");
            senha = scanner.nextLine();

            System.out.println("Insira o email do Usuario:");
            email = scanner.nextLine().trim();

            mapaUsuarios.put(nome, new Usuarios(nome, senha, email));

            System.out.println("Digite saldo inicial");
            valor = Double.parseDouble(scanner.nextLine().replaceAll(" ", ""));
            mapaUsuarios.get(nome).abrirConta(valor);

            break;

        case 2: /* Gerar QRCode */
            System.out.println("Insira o nome do Usuario:");
            recebedor = scanner.nextLine().trim();

            if (mapaUsuarios.get(recebedor) != null) {
                System.out.println("Insira o valor:");
                valor = Double.parseDouble(scanner.nextLine().replaceAll(" ", ""));
                Transacoes.gerarQRCode(mapaUsuarios.get(recebedor), valor);
            } else {
                System.out.println("Usuario nao existe.");
            }
            break;

        case 3: /* Efutar um pagamento */
            System.out.println("Digite o Usuario que realizara a trasnferencia:");
            pagador = scanner.nextLine().trim();

            System.out.println("Digite o Usuario que recebera a trasnferencia:");
            recebedor = scanner.nextLine().trim();

            if (mapaUsuarios.get(pagador) != null && mapaUsuarios.get(recebedor) != null) {
                System.out.println("Digite o QR Code:");
                QRCode = scanner.nextLine().trim();
                Transacoes.transferirDinheiro(mapaUsuarios.get(pagador), mapaUsuarios.get(recebedor), QRCode);
            } else {
                System.out.println(
                        "Usuarios nao constam no banco de dados. Verifique se digitou corretamente e tente novamente.");
            }
            break;

        case 4: /* Mostrar o saldo (necessita login) */
            System.out.println("Insira o nome do Usuario:");
            nome = scanner.nextLine().trim();

            if (mapaUsuarios.get(nome) != null) {
                System.out.println("Insira sua senha:");
                senha = scanner.nextLine();

                if (mapaUsuarios.get(nome).getSenha().equals(senha)) {
                    System.out.println("Nome Usuario: " + mapaUsuarios.get(nome).getNome() + "  - Saldo: "
                            + mapaUsuarios.get(nome).getConta().getSaldo());
                } else {
                    System.out.println("Senha incorreta!");
                }
            } else {
                System.out.println(
                        "Usuarios nao constam no banco de dados. Verifique se digitou corretamente e tente novamente.");
            }
            break;

        case 0: /* Finalizar o Programa */
            System.out.println("Obrigado por escolher MauaBank, até logo.");
            scanner.close();
            this.boolExecutarSistema = false;
            break;

        default:
            System.out.println("Tente digitar novamente.");
            break;
        }
    }

    private void exibirMenu() {
        System.out.println("Bem vindo ao MauaBank");
        System.out.println("1 - Cadastrar Novo Usuario.");
        System.out.println("2 - Criar um QR Code para receber pagamentos.");
        System.out.println("3 - Realizar pagamento com QR Code");
        System.out.println("4 - Exibir dados da sua conta");
        System.out.println("0 - sair");
    }

    @Override
    public String toString() {
        return "Atividade1 [boolExecutarSistema=" + boolExecutarSistema + ", mapaUsuarios=" + mapaUsuarios
                + ", scanner=" + scanner + "]";
    }

}