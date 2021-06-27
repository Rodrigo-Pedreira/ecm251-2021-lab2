package atividade2.models;

import atividade2.SystemDrive;
import atividade2.enums.HorariosTrabalho;
import atividade2.enums.TiposMembros;

/**
 * Classe BigBrothers, filha de Membros, implementa por heranca Apresentacao, PostarMensagem.
 * <p>
 * Atributos:
 * categoria;
 * nome;
 * email;
 * id;
 */
public class BigBrothers extends Membro {

    /**
     * Contrutor da classe BigBrothers. Ira cadastrar um novo usuario do tipo Big Brother.
     *
     * @param nome  do usuario que sera cadastrado.
     * @param email do usuario que sera cadastrado.
     */
    public BigBrothers(String nome, String email) {
        super(nome, email);
        this.categoria = TiposMembros.BIGBROTHERS.name();
    }

    /**
     * Metodo publico void que imprime no terminal parametros da classe.
     */
    @Override
    public void apresentarResumo() {
        System.out.println(
                "Nome:" + this.nome +
                ";   Categoria: " + this.categoria +
                ";   Email: " + this.email +
                ";   Id: " + this.id
        );
    }

    /**
     * Posta as mensagens respectivas dos membros Big Brothers de acordo com o horario de trabalho.
     */
    @Override
    public void postarMensagem() {
        if (SystemDrive.getHorarioAtualTrabalho().contentEquals(HorariosTrabalho.REGULAR.name())) {
            System.out.println("O "+ this.categoria +" "+ this.nome + " disse: Sempre ajudando as pessoas membros ou não S2!");
        } else if (SystemDrive.getHorarioAtualTrabalho().contentEquals(HorariosTrabalho.EXTRA.name())) {
            System.out.println("O "+ this.categoria +" "+ this.nome + " disse: ...");
        }
    }

    /**
     * Funcao toString que retorna os parametros, especificados no metodo, da classe.
     * @return parametros da classe especificados pelo metodo.
     */
    @Override
    public String toString() {
        return "BigBrothers{" +
                "categoria='" + categoria + '\'' +
                ", nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

