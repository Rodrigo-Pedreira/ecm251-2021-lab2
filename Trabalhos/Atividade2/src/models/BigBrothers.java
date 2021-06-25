package models;

import enums.TiposMembros;

/**
 * Classe de um membro Big Brothers.
 */
public class BigBrothers extends Membro{
    /**
     * Contrutor da classe BigBrothers. Ira cadastrar um novo usuario
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
        System.out.println();
    }
}
