package atividade2.models;

import atividade2.interfaces.Apresentacao;
import atividade2.interfaces.PostarMensagem;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * Classe abstrta Membros, sera classe pai dos tipos de membro(BigBrothers,HeavyLifters,MobileMembers,ScriptGuys). Implementa as Interfaces Apresentacao, PostarMensagem
 *
 * Atributos:
 *              categoria;
 *              nome;
 *              email;
 *              id;
 */
public abstract class Membro implements Apresentacao, PostarMensagem {

    /**
     * Instancia um objeto da classe Random, que ira gerar numeros aleatorios.
     */
    Random randomizer = new Random();

    /**
     * Um LinkedHashSet de strings que ira conter os ids e garantir que ele e unico. id tem 10 algarismos.
     */
    Set<String> idLinkedHashSet = new LinkedHashSet<String>();  //TODO: Lembrar de retirar id da lista quando usuario for deletado.

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
     * Contrutor da classe Membro, usado para cadastrar nomos usuarios. Cria um id unico de 10 algarismos para o usuario.
     * @param nome do membro a ser cadastrado.
     * @param email do membro a ser cadastrado
     */
    public Membro(String nome, String email) {
        this.nome = nome;
        this.email = email;
        String idTemp;
        do {
            idTemp="";
            for (int i = 0; i < 10; i++) {
                int idInteger = randomizer.nextInt(10);
                idTemp += idInteger;
            }
        }while (idLinkedHashSet.contains(idTemp));
        idLinkedHashSet.add(idTemp);
        this.id = idTemp;
    }
}
