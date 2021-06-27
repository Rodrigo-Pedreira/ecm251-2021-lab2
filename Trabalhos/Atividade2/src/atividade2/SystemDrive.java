package atividade2;

import atividade2.enums.HorariosTrabalho;
import atividade2.models.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import

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
     * Variavel HashMap que salva a referencia para objetos. Chave e o nome do Usuario.
     */
    private static HashMap<String, Membro> mapaMembro = new HashMap<String, Membro>();

    /**
     * Metedo static void responsavel pela execucao continua do sistema. Sera um loop.
     * Tambem imprime uma breve mensaguem de boas vindas.
     * @param runState controla o loop.
     */
    public static void runCode(boolean runState) {
        System.out.println("\n---------------- Ola, 1337 hacker! Bem vindo ao MAsK_S0c13ty. ----------------\n");
        while (runState) {
            runState = menuPrograma();
        }
    }

    /**
     * Parametro String que guarda path para uma file ("arquivo_super_Secreto_nao_abrir.csv")
     */
    private static String csvPath = "arquivo_super_Secreto_nao_abrir.csv";

    /**
     * Metodo static boolean que executa o menu boas vindas do programa e aceita um input do usuario para realizar funcoes.
     */
    private static boolean menuPrograma(){

        /**
         * Variavel int que ira controlar o menu (switch) do programa.Valor default -1 (entra no case default do switch/menu).
         */
        int caseVar;

        System.out.println("Horario de trabalho atual: " + horarioAtualTrabalho);
        System.out.println("Opcoes:\n1 - Para postar mensagem;\n2 - Para cadastrar membros;\n3 - Para remover membros;\n4 - Para exibir resumo de todos os usuarios;\n5 - Para;\n6 - Para trocar o horario de trabalho(REGULAR ou EXTRA);\n0 - Para Sair.\n\nEscolha uma opcao:");

        caseVar = scanner.nextInt();
        scanner.nextLine();

        switch (caseVar){
            case 1:     // Posta uma mensaguem que forcara todos os usuarios assinarem em baixo com suas respectivas mensagens de acordo com o horario de trabalho
                System.out.println("Digite sua mensagem: ");
                String mensagem = scanner.nextLine();
                mapaMembro.forEach((k,v) -> v.postarMensagem() );
                break;

            case 2:     // Cadastra novos Usuarios.
                cadastrarUsuarios();
                break;

            case 3:     // Remove usuarios.
                removerUsuarios();
                break;

            case 4:     // Exibi resumo de todos os usuarios.
                if (!mapaMembro.isEmpty()) {
                    mapaMembro.forEach((k, v) -> v.apresentarResumo());
                }
                else {
                    System.out.println("Nenhum membro cadastrado.");
                }
                break;

            case 5:
                //System.out.println(mapaMembro.get("123").toString());
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
     * Metodo static void que cadastra novos usuarios. Uma csv nova e criada apos novo cadastro.
     */
    private static void cadastrarUsuarios(){

        boolean loopSwitch = true;
        String nome, email;


        System.out.println("Insira o nome do Usuario:");
        nome = scanner.nextLine().trim();
        while (mapaMembro.containsKey(nome)){
            System.out.println("Nome ja cadastrado. Por favor escolha outro nome.");
            nome = scanner.nextLine().trim();
        }

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

                case 3: // Mobile Members
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
            if (!loopSwitch) {
                CsvHandler.manipularCsv(mapaMembro, csvPath);
            }
        }
    }

    /**
     * Metodo publico statico void que remove usuarios ja cadastrados no sistema.  Uma csv nova e criada apos remocao de um cadastro.
     */
    public static void removerUsuarios(){
        String nome;
            System.out.println("Insira o nome do Usuario:");
            nome = scanner.nextLine().trim();
            if (mapaMembro.containsKey(nome)) {
                Membro.removeIdSet(mapaMembro.get(nome).getId());
                mapaMembro.remove(nome);
                System.out.println("Usuario " + nome + " removido.");
                CsvHandler.manipularCsv(mapaMembro,csvPath);
            }
            else{
                System.out.println("Usuario " + nome + " nao encontrado no banco de dados.");
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
