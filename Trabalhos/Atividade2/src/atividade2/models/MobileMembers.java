package atividade2.models;

import atividade2.SystemDrive;
import atividade2.enums.HorariosTrabalho;
import atividade2.enums.TiposMembros;

/**
 * Classe MobileMembers, filha de Membros , implementa por heranca Apresentacao, PostarMensagem.
 * <p>
 * Atributos:
 * categoria;
 * nome;
 * email;
 * id;
 */
public class MobileMembers extends Membro {

    /**
     * Contrutor da classe MobileMembers. Ira cadastrar um novo usuario do tipo Big Brother.
     *
     * @param nome  do usuario que sera cadastrado.
     * @param email do usuario que sera cadastrado.
     */
    public MobileMembers(String nome, String email) {
        super(nome, email);
        this.categoria = TiposMembros.MOBILEMEMBERS.name();
    }

    /**
     * Metodo publico void que imprime no terminal parametros da classe.
     */
    @Override
    public void apresentarResumo() {
        System.out.println(
                "Nome: " + this.nome +
                        ";\tCategoria: " + this.categoria +
                        ";\tEmail: " + this.email +
                        ";\tId: " + this.id
        );
    }

    /**
     * Posta as mensagens respectivas dos membros Mobile Members de acordo com o horario de trabalho.
     */
    @Override
    public void postarMensagem() {
        if (SystemDrive.getHorarioAtualTrabalho().contentEquals(HorariosTrabalho.REGULAR.name())) {
            System.out.println(this.categoria + " " + this.nome + ": Happy Coding!");
        } else if (SystemDrive.getHorarioAtualTrabalho().contentEquals(HorariosTrabalho.EXTRA.name())) {
            System.out.println(this.categoria + " " + this.nome + ": MAsK_S0c13ty");
        }
    }

    /**
     * Funcao toString que retorna os parametros, especificados no metodo, da classe.
     *
     * @return parametros da classe especificados pelo metodo.
     */
    @Override
    public String toString() {
        return "MobileMembers{" +
                "categoria='" + categoria + '\'' +
                ", nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
