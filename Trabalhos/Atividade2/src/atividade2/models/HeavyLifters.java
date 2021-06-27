package atividade2.models;

import atividade2.SystemDrive;
import atividade2.enums.HorariosTrabalho;

/**
 * Classe HeavyLifters, filha de Membros, implementa por heranca Apresentacao, PostarMensagem.
 *
 * Atributos:
 *              categoria;
 *              nome;
 *              email;
 *              id;
 */
public class HeavyLifters extends Membro {
    public HeavyLifters(String nome, String email) {
        super(nome, email);
    }

    @Override
    public void apresentarResumo() {

    }

    @Override
    public void postarMensagem() {
        if(SystemDrive.getHorarioAtualTrabalho().contentEquals(HorariosTrabalho.REGULAR.name() ))  {
            System.out.println("Podem contar conosco!");
        }else if (SystemDrive.getHorarioAtualTrabalho().contentEquals(HorariosTrabalho.EXTRA.name() )){
            System.out.println("N00b_qu3_n_Se_r3pita.bat");
        }
    }
}
