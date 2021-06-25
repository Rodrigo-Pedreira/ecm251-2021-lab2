package models;

import interfaces.Apresentacao;
import interfaces.PostarMensagem;

abstract class Membro implements Apresentacao, PostarMensagem {

    protected String categoria;
    protected String nome;
    protected String id;
    protected String email;




}
