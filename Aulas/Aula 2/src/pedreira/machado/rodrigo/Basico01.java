package pedreira.machado.rodrigo;

import javax.imageio.stream.ImageInputStream;

public class Basico01 {
    //Tipos primitivos
    public static void main(String[] args) {
        int hp;
        boolean megaEvolui;
        float atk;
        double satk;
        String nome;

        // Atribuicoes
        hp = 100;
        megaEvolui = true;
        atk = 50.0f;
        satk = 55.0;
        nome = "Gengar";
        System.out.println("Nome:" + nome);
        System.out.println("megaEvolui?" + megaEvolui);
        System.out.println("Atk:" + atk + "\nAtk Especial:" + satk);


    }
}
