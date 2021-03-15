package pedreira.machado.rodrigo;

public class Cliente {
    private String cliente;
    private String cpf;

    public Cliente(String cliente){
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "titular='" + cliente + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}