package models;

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

    @Override
    public void postarMensagem() {

    }
}
