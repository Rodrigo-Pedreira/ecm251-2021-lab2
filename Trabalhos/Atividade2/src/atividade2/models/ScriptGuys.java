package atividade2.models;

import atividade2.SystemDrive;
import atividade2.enums.HorariosTrabalho;
import atividade2.enums.TiposMembros;

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

    /**
     * Contrutor da classe ScriptGuys. Ira cadastrar um novo usuario do tipo Big Brother.
     *
     * @param nome  do usuario que sera cadastrado.
     * @param email do usuario que sera cadastrado.
     */
    public ScriptGuys(String nome, String email) {
        super(nome, email);
        this.categoria = TiposMembros.SCRIPTGUYS.name();
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
     * Posta as mensagens respectivas dos membros Mobile Members de acordo com o horario de trabalho.
     */
    @Override
    public void postarMensagem() {
        if(SystemDrive.getHorarioAtualTrabalho().contentEquals(HorariosTrabalho.REGULAR.name()))  {
            System.out.println("O "+ this.categoria +" "+ this.nome + " disse: Prazer em ajudar novos amigos de codigo!");
        }
        else if (SystemDrive.getHorarioAtualTrabalho().contentEquals(HorariosTrabalho.EXTRA.name())){
            System.out.println("O "+ this.categoria +" "+ this.nome + " disse: QU3Ro_S3us_r3curs0s.py");
        }
    }

    /**
     * Funcao toString que retorna os parametros, especificados no metodo, da classe.
     * @return parametros da classe especificados pelo metodo.
     */
    @Override
    public String toString() {
        return "ScriptGuys{" +
                "categoria='" + categoria + '\'' +
                ", nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
