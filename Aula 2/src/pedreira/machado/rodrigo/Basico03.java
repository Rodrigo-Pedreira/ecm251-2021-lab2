package pedreira.machado.rodrigo;

import java.util.Random;

public class Basico03 {
    public static void main(String[] args) {
        int limite = 10;
        int contador;
        for(contador = 0 ; contador < limite; contador++){
            System.out.println("Contador:" + contador);
        }

        int senha = 123456;

        //Objeto que possibilita pegar numeros aleatorios
        Random sorteador = new Random();
        int chute = sorteador.nextInt (999999);
        System.out.println("Chute:" + chute);
        int tentetivas = 0;
        while (chute!=senha){
            System.out.println("Tentativa:" + tentetivas);
            chute = sorteador.nextInt(999999);
            System.out.println("Chute:" + chute);
            tentetivas++;
        }
        System.out.println("Parabens Harkerman!");
    }
}