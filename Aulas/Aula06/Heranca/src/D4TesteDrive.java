package Aulas.Aula06.Heranca.src;

public class D4TesteDrive {
    D4TesteDrive dado = new D4TesteDrive();

    public static void main(String[] args) {
        Dado dado = new D4();
        System.out.println("Gerou dado, face atual:" + dado.getFaceAtual());
        for (int i = 0; i < 10; i++) {
            System.out.println("Gerou: " + dado.lancarDadoEExibirResultado());
            System.out.println("Confirmando: " + dado.getFaceAtual());
        }
    }    
}