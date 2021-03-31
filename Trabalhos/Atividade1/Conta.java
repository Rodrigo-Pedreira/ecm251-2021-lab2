/** Autores:
 *      Rodrigo Machado Pedreira        18.01569-7
 *      Gabriel Gomes Bermudi Santos    18.00947-6
 */

package Trabalhos.Atividade1;

/**
 * Classe Conta: Guarda informacoes das contas;
 */

public class Conta {
    private String idConta; // ID exclusivo do obj conta.
    private double saldo; // Saldo exclusivo do obj conta.

    public Conta(String idConta, double saldo) {
        this.idConta = idConta;
        this.saldo = saldo;
    }

    public Conta(double saldo) {
        this.idConta = "123456789";
        this.saldo = saldo;
    }

    public String getIdConta() {
        return this.idConta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta [idConta=" + idConta + ", saldo=" + saldo + "]";
    }
}
