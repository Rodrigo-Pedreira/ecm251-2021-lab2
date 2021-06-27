import enums.HorariosTrabalho;
import models.*;

import javax.swing.plaf.metal.MetalFileChooserUI;
import java.io.File;
import java.lang.reflect.Member;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;

import static java.util.Arrays.*;

/**
 * Classe SystemDrive. Controla o programa.
 */
public class SystemDrive {

    /**
     * Variavel int que ira controlar o menu (switch) do programa.Valor default -1 (entra no case default do switch/menu).
     */
    private int caseVar;

    /**
     * Varieavel boolean que contrala a execucao do sistema. Valor default true. Quando false acaba o loop e o programa finaliza.
     */
    private boolean runState;

    /**
     * Variavel String que guarda informacao do horario atual de trabalho; Default "REGULAR"
     */
    private static String horarioAtualTrabalho = HorariosTrabalho.REGULAR.name();

    /**
     * Scanner utilizado para ler input do usuario (System.in).
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * Variavel HashMap que salva a referencia para objetos. Chave e o nome o Usuario.
     */
    private HashMap<String, Membro> mapaMembro;

    /**
     * Contrutor da classe SystemDrive. Define variaveis caseVar = -1; runState = true; horarioAtualTrabalho = "REGULAR"; Cria HashMap<String, Member> como mapaMembro.
     */
    public SystemDrive() {
        this.caseVar = -1;
        this.runState = true;
        this.horarioAtualTrabalho = "REGULAR";
        mapaMembro = new HashMap<String, Membro>();
    }

    /**
     * Metedo void responsavel pela execucao continua do sistema. Sera um loop com um menu. Variavel runState controla o loop.
     */
    public void runCode() {
        System.out.println("\n---------------- Ola, 1337 hacker! Bem vindo ao MAsK_S0c13ty. ----------------\n");
        while (runState) {
            runState = menuPrograma();
        }
    }

    /**
     * Metodo boolean que executa o menu boas vindas do programa e aceita um input do usuario para realizar funcoes.
     */
    private boolean menuPrograma(){
        System.out.println("\nHorario de trabalho atual: " + horarioAtualTrabalho);
        System.out.println("Opcoes:\n1 - Para postar mensagem;\n2 - Para cadastrar os membros;\n3 - Para mostras usuarios cadastrados;\n4 - Para;\n5 - Para;\n6 - Para trocar o horario de trabalho(REGULAR ou EXTRA);\n0 - Para Sair.\n\nEscolha uma opcao:");

        caseVar = scanner.nextInt();
        scanner.nextLine();

        switch (caseVar){
            case 1:
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
     * Metodo void que cadastra novos usuarios.
     */
    private void cadastrarUsuarios(){

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
     * Metodo que retorna Horario atual de trabalho do sistema.
     * @return horarioAtualTrabalho
     */
    public String getHorarioAtualTrabalho() {
        return horarioAtualTrabalho;
    }
}
