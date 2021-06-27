package atividade2.models;


import atividade2.SystemDrive;
import atividade2.enums.HorariosTrabalho;
import atividade2.enums.TiposMembros;

/**
 * Classe BigBrothers, filha de Membros, implementa por heranca Apresentacao, PostarMensagem.
 *
 * Atributos:
 *              categoria;
 *              nome;
 *              email;
 *              id;
 */
public class BigBrothers extends Membro{


    /**
     * Contrutor da classe BigBrothers. Ira cadastrar um novo usuario do tipo Big Brother.
     * @param nome do usuario que sera cadastrado.
     * @param email do usuario que sera cadastrado.
     */
    public BigBrothers(String nome, String email) {
        super(nome, email);
        this.categoria = TiposMembros.BIGBROTHERS.name();
    }

    @Override
    public void apresentarResumo() {

    }

    @Override
    public void postarMensagem() {
        if(SystemDrive.getHorarioAtualTrabalho().contentEquals(HorariosTrabalho.REGULAR.name() ))  {
            System.out.println("Sempre ajudando as pessoas membros ou não S2!");
        }else if (SystemDrive.getHorarioAtualTrabalho().contentEquals(HorariosTrabalho.EXTRA.name() )){
            System.out.println("...");
        }

    }
}

