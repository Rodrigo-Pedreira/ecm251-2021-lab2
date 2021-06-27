package atividade2.models;

import atividade2.SystemDrive;
import atividade2.enums.HorariosTrabalho;

/**
 * Classe ScriptGuys, filha de Membros, implementa por heranca Apresentacao, PostarMensagem.
 *
 * Atributos:
 *              categoria;
 *              nome;
 *              email;
 *              id;
 */
public class ScriptGuys extends Membro {
    public ScriptGuys(String nome, String email) {
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
        if(SystemDrive.getHorarioAtualTrabalho().contentEquals(HorariosTrabalho.REGULAR.name()))  {
            System.out.println("Prazer em ajudar novos amigos de codigo!");
        }else if (SystemDrive.getHorarioAtualTrabalho().contentEquals(HorariosTrabalho.EXTRA.name())){
            System.out.println("QU3Ro_S3us_r3curs0s.py");
        }
    }
}
