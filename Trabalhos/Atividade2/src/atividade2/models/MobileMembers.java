package atividade2.models;

import atividade2.SystemDrive;
import atividade2.enums.HorariosTrabalho;

/**
 * Classe MobileMembers, filha de Membros , implementa por heranca Apresentacao, PostarMensagem.
 *
 * Atributos:
 *              categoria;
 *              nome;
 *              email;
 *              id;
 */
public class MobileMembers extends Membro{
    public MobileMembers(String nome, String email) {
        super(nome, email);
    }

    @Override
    public void apresentarResumo() {

    }
    /**
     * Posta as mensagens respectivas dos membros Mobile Members de acordo com o horario de trabalho.
     */
    @Override
    public void postarMensagem() {
        if(SystemDrive.getHorarioAtualTrabalho().contentEquals(HorariosTrabalho.REGULAR.name() )){
            System.out.println("Happy Coding!");
        }
        else if (SystemDrive.getHorarioAtualTrabalho().contentEquals(HorariosTrabalho.EXTRA.name() )){
            System.out.println("MAsK_S0c13ty");
        }
    }
}
