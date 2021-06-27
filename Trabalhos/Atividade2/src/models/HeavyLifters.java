package models;

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

    }
}
