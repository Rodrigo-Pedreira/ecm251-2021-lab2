package pedreira.machado.rodrigo;

public class Main {

    public static void main(String[] args) {
        //Cria uma referencia para um objeto Conta.
        Conta c1;
        //Instancia um objeto conta.
        c1 = new Conta("Fulano", 999.99);

        Conta c2 = new Conta("Beltrano", "123456789-9");

        c1.depositar(300);
        c1.sacar(250);

        System.out.println("Conta 1:" + c1.toString());
        System.out.println("Conta 2:" + c2.toString());
    }
}