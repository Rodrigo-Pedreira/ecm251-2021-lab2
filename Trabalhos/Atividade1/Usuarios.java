/** Autores:
 *      Rodrigo Machado Pedreira        18.01569-7
 *      Gabriel Gomes Bermudi Santos    18.00947-6
 */

package Trabalhos.Atividade1;

/**
 * Classe Usuarios: Guarda informacoes dos obj Usuarios.
 */

public class Usuarios {

    private String nome, senha, email; // Dados exclusivos de cada obj Usuarios.
    private Conta conta;

    public Usuarios(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public void abrirConta(double saldo) {
        if (this.conta == null) {
            this.conta = new Conta(saldo);
        } else
            System.out.println("Ja tem uma conta!");
    }

    public String getNome() {
        return nome;
    }

    public Conta getConta() {
        return this.conta;
    }

    public String getSenha() {
        return this.senha;
    }

    @Override
    public String toString() {
        return "Usuarios [conta=" + conta + ", email=" + email + ", nome=" + nome + ", senha=" + senha + "]";
    }

}
