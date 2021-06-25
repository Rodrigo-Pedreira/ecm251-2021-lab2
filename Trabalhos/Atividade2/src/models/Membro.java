package models;

import interfaces.Apresentacao;
import interfaces.PostarMensagem;

/**
 * Classe abstrta dos Membros, sera classe pai dos tipos de membro. Implementa as Interfaces Apresentacao, PostarMensagem
 */
abstract class Membro implements Apresentacao, PostarMensagem {

    /**
     * Catergoria/Tipo do membro.
     */
    protected String categoria;

    /**
     * Nome do membro.
     */
    protected String nome;

    /**
     * Id do membro.
     */
    protected String id;

    /**
     * E-mail do membro.
     */
    protected String email;

    /**
     * Contrutor da classe Membro, usado para cadastrar nomos usuarios.
     * @param nome do membro a ser cadastrado.
     * @param email do membro a ser cadastrado
     */
    public Membro(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }



}
