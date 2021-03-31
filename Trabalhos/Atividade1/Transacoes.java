/** Autores:
 *      Rodrigo Machado Pedreira        18.01569-7
 *      Gabriel Gomes Bermudi Santos    18.00947-6
 */

package Trabalhos.Atividade1;

/**Classe Transsacoes:
 * Nao tem atributos, somente metodos para gerar os QRCode em String para cada operação.
 */

/** Toda transação deve ser composta pelo id da conta;
- A String gerada deve conter o nome do usuário que
vai receber o valor;
- A String gerada deve conter o valor da transação;
- Ela deve conter um número aleatório no intervalo
1000 e 9999, gerado por: */

import java.util.Random;

public class Transacoes {
    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    protected static String gerarQRCode(Usuarios recebedor, double valor) {
        String QRCode = recebedor.getConta().getIdConta() + ";" + recebedor.getNome().replaceAll(" ", "") + ";" + valor + ";"
                + getRandomNumberInRange(1000, 9999);
        System.out.println(QRCode);
        return QRCode;
    }

    protected static void transferirDinheiro(Usuarios pagador, Usuarios recebedor, String QRCode) {

        String[] dados = QRCode.split(";"); /* [0] = (conta) idConta ; [1] = (usuario) nome ; [2] = valor a transferido ; [3] = num random */

        // if( dados[0] != null && dados[1] != null && dados[2] != null && dados[3] !=
        // null ){ // FIXME: QR Code Invalido trava o programa. Errado ok mas se n tiver os ';' trava,

        double valor = Double.parseDouble(dados[2]);

        if (pagador.getConta().getSaldo() >= valor 
            && recebedor.getNome().replaceAll(" ", "").equals(dados[1])
            && recebedor.getConta().getIdConta().equals(dados[0])
        ) {
            pagador.getConta().setSaldo(pagador.getConta().getSaldo() - valor); /* Subtraindo saldo da conta pagadora */

            recebedor.getConta().setSaldo(
                    recebedor.getConta().getSaldo() + valor); /* Adicionando o valor para a conta do recebedor */

            System.out.println("Pagamento Realizado!");
        } else if (pagador.getConta().getSaldo() < valor) {
            System.out.println("Sem saldo para realizar esta transacao!");
        } else {
            System.out.println("QR Code invalido!");
        }

        /**
         * } else{ System.out.println("QR Code invalido!"); }
         */
    }

    @Override
    public String toString() {
        return "Transacoes []";
    }
}
