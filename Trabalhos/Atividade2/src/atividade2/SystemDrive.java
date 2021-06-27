package atividade2;

import atividade2.enums.HorariosTrabalho;
import atividade2.models.*;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Classe atividade2.SystemDrive. Controla o programa.
 */
public abstract class SystemDrive {

    /**
     * Variavel String que guarda informacao do horario atual de trabalho; Default "REGULAR"
     */
    private static String horarioAtualTrabalho = HorariosTrabalho.REGULAR.name();

    /**
     * Scanner utilizado para ler input do usuario (System.in).
     */
    private static Scanner  scanner = new Scanner(System.in);

    /**
     * Variavel HashMap que salva a referencia para objetos. Chave e o nome o Usuario.
     */
    private static HashMap<String, Membro> mapaMembro = new HashMap<String, Membro>();

    /**
     * Contrutor da classe atividade2.SystemDrive. Define variaveis caseVar = -1; runState = true; horarioAtualTrabalho = "REGULAR"; Cria HashMap<String, Member> como mapaMembro.
     */
//    public SystemDrive() {
//        this.caseVar = -1;
//        this.runState = true;
//        horarioAtualTrabalho = "REGULAR";
//        mapaMembro = new HashMap<String, Membro>();
//    }

    /**
     * Metedo static void responsavel pela execucao continua do sistema. Sera um loop.
     * @param runState controla o loop.
     */
    public static void runCode(boolean runState) {
        System.out.println("\n---------------- Ola, 1337 hacker! Bem vindo ao MAsK_S0c13ty. ----------------\n");
        while (runState) {
            runState = menuPrograma();
        }
    }

    /**
     * Metodo static boolean que executa o menu boas vindas do programa e aceita um input do usuario para realizar funcoes.
     */
    private static boolean menuPrograma(){

        /**
         * Variavel int que ira controlar o menu (switch) do programa.Valor default -1 (entra no case default do switch/menu).
         */
        int caseVar;

        System.out.println("\nHorario de trabalho atual: " + horarioAtualTrabalho);
        System.out.println("Opcoes:\n1 - Para postar mensagem;\n2 - Para cadastrar os membros;\n3 - Para mostras usuarios cadastrados;\n4 - Para;\n5 - Para;\n6 - Para trocar o horario de trabalho(REGULAR ou EXTRA);\n0 - Para Sair.\n\nEscolha uma opcao:");

        caseVar = scanner.nextInt();
        scanner.nextLine();

        switch (caseVar){
            case 1:     // Posta uma mensaguem que forcara todos os usuarios assinarem em baixo com suas respectivas mensagens de acordo com o horario de trabalho
                System.out.println("Digite sua mensagem: ");
                String mensagem = scanner.nextLine();
                System.out.println(mensagem);
                //TODO: Postar assinaturas de todos. (foreach mapa?)
                break;

            case 2:     // Cadastra novos Usuarios.
                cadastrarUsuarios();
                break;

            case 3:
                break;

            case 4:

                break;

            case 5:
                break;

            case 6:     // Toggle no horarioAtualTrabalho REGULAR, EXTRA
                if (horarioAtualTrabalho.contentEquals(HorariosTrabalho.REGULAR.name())) {
                    horarioAtualTrabalho = "EXTRA";
                }
                else if (horarioAtualTrabalho.contentEquals(HorariosTrabalho.EXTRA.name())){
                    horarioAtualTrabalho = "REGULAR";
                }
                System.out.println("Novo horario de trabalho definido. Horario atual de trabalho: " + horarioAtualTrabalho);
                break;

            case 0:
                return false; // Para a execucao do programa, runState = falso.

            default:    // Printa erro e escolhe nova caseVar.
                System.out.println("Entrada invalida! Tente novamente.");
                break;
        }
        return true; // Continua a execucao do programa, runState = true.
    }

    /**
     * Metodo static void que cadastra novos usuarios.
     */
    private static void cadastrarUsuarios(){

        boolean loopSwitch = true;
        String nome, email;

        System.out.println("Insira o nome do Usuario:");
        nome = scanner.nextLine().trim();

        System.out.println("Insira o email do Usuario:");
        email = scanner.nextLine().trim();

        while(loopSwitch) {
            System.out.println("Categorias:\n1 - Big Brothers;\n2 - Heavy Lifters;\n3 - Mobile Members;\n4 - Script Guys.\nEscolha uma categoria:");
            int switchCase = scanner.nextInt();
            scanner.nextLine();
            switch (switchCase) {

                case 1: // Big Brothers
                    mapaMembro.putIfAbsent(nome,new BigBrothers(nome,email));
                    loopSwitch = false;
                    break;

                case 2: //Heavy Lifters
                    mapaMembro.putIfAbsent(nome,new HeavyLifters(nome,email));
                    loopSwitch = false;
                    break;

                case 3: // Heavy Lifters
                    mapaMembro.putIfAbsent(nome,new MobileMembers(nome,email));
                    loopSwitch = false;
                    break;

                case 4: // Script Guys
                    mapaMembro.putIfAbsent(nome,new ScriptGuys(nome,email));
                    loopSwitch = false;
                    break;

                default:
                    System.out.println("Opacao Invalida! Digite novamente.");
                    break;
            }
        }
    }

    /**
     * Metodo static que retorna Horario atual de trabalho do sistema.
     * @return horarioAtualTrabalho
     */
    public static String getHorarioAtualTrabalho() {
        return horarioAtualTrabalho;
    }
}
