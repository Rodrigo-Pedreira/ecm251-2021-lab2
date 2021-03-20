package Aula03.src.pedreira.machado.rodrigo;

public class Conta {
    //Atributos.
    Cliente cliente;
    int numero;
    double saldo;

    //Metodos.
    void visualizarSaldo() {
        System.out.println("Valdor do saldo: R$" + this.saldo);
        // this. -> Auto-referencia. this.isso -> isso é do objeto. Pega o valor da instancia/atributo (nao de variaveis locais)
    }

    boolean sacar(double valor) {
        if(this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    void depositar(double valor) {
        this.saldo += valor;
    }

    boolean transferirDinheiro(Conta destino, double valor ) {
        if(this.sacar(valor)){
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "cliente=" + cliente.toString() +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
