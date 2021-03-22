package Aulas.Aula04.src.pedreira.machado.rodrigo;

public class Cliente {

    public Cliente(String nome) {
        this.nome = nome;
    }

    private String nome;
    private String cpf;

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}