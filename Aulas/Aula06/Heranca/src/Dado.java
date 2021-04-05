package Aulas.Aula06.Heranca.src;

import java.util.Random;

public class Dado {
    private int numLados;
    private int faceAtual;
    private int[] FACES;

    public Dado(int numLados) {
        this.numLados = numLados;
        lancarDado();
        FACES[this.numLados];
        for (int i = 0; i < this.numLados; i++) {
            FACES[i] = i+1;
        }
    }

    /**
     * Metodo que realiaz lancamento do dado e atribui dentro de faceAtual o valor do lancamento
     */
    private void lancarDado() {
        Random random = new Random();
        this.faceAtual = random.nextInt(this.numLados);
    }

    /**
     * Metodo que devolve o valor da face atual do dado.
     * @return int face atual sorteada
     */
    public int getFaceAtual() {
        return FACES[this.faceAtual];
    }

    /**
     * Metodo que realiza o lancamento e devolve o valor da nava face atual
     * @return int nova face atual
     */
    public int lancarDadoEExibirResultado() {
        lancarDado();
        return getFaceAtual();
    }

}
