package models;

import enums.TiposMembros;

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
        System.out.println();
    }
}
