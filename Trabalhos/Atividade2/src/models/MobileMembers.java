package models;

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

    @Override
    public void postarMensagem() {

    }
}
