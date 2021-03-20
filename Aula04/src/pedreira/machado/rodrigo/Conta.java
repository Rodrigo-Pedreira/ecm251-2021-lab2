package Aula04.src.pedreira.machado.rodrigo;

public class Conta {
    //Atributos.
    private Cliente cliente;
    private int numero;
    private double saldo;

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

//Metodos

    //Construtor da classe
    public Conta(String nomeCliente, double saldoInicial) {
        this.saldo = saldoInicial;
        this.cliente = new Cliente(nomeCliente);
        this.numero = 1234;
    }

    public Conta(String nomeCliente, String cpf) {
        this.cliente = new Cliente(nomeCliente);
    }

    public void visualizarSaldo() {
        System.out.println("Valdor do saldo: R$" + this.saldo);
        // this. -> Auto-referencia. this.isso -> isso é do objeto.
        // Pega o valor da instancia/atributo (nao de variaveis locais)
    }

    public boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean transferirDinheiro(Conta destino, double valor) {
        if (this.sacar(valor)) {
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
                ", saldo_disponivel=" + saldo +
                '}';
    }
}
