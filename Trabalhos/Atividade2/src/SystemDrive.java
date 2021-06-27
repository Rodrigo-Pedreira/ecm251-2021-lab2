import enums.HorariosTrabalho;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
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
    private String horarioAtualTrabalho;

    /**
     * Scanner utilizado para ler input do usuario (System.in).
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * Contrutor da classe SystemDrive. Define variaveis caseVar = -1; runState = true; horarioAtualTrabalho = "REGULAR"
     */
    public SystemDrive() {
        this.caseVar = -1;
        this.runState = true;
        this.horarioAtualTrabalho = "REGULAR";
    }

    /**
     * Metedo responsavel pela execucao continua do sistema. Sera um loop com um menu. Variavel runState controla o loop.
     */
    public void runCode() {
        System.out.println("\n---------------- Ola, 1337 hacker! Bem vindo ao MAsK_S0c13ty. ----------------\n");
        while (runState) {
            runState = menuPrograma();
        }
    }

    /**
     * Metodo que executa o menu boas vindas do programa e aceita um input do usuario para realizar funcoes.
     */
    private boolean menuPrograma(){
        System.out.println("\nHorario de trabalho atual: " + horarioAtualTrabalho);
        System.out.println("Opcoes:\n1 - Para;\n2 - Para;\n3 - Para;\n4 - Para;\n5 - Para;\n6 - Para trocar o horario de trabalho(REGULAR ou EXTRA);\n0 - Para Sair.\n\nEscolha uma opcao:");
        caseVar = scanner.nextInt();

        switch (caseVar){
            case 1:
                break;

            case 2:
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
}
