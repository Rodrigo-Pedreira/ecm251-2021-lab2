package Aula05.src.pedreira.machado.rodrigo;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Titulo {
    private double valor;
    private double jurosPorDia;
    private LocalDate dataPagamento;

    public Titulo(double valor, String nome, double jurosPorDia, String dataPagamento) {
        this.valor = valor;
        this.jurosPorDia = jurosPorDia;
        this.dataPagamento = LocalDate.parse(dataPagamento);
    }

    public double getValorPagamento() {
        if(!contaAtrasada()){
            return this.valor;
        }
        else{
            return calcularValorComJuros();
        }
    }

    private boolean contaAtrasada() {
        return LocalDate.now().isAfter(dataPagamento);
    }

    private double calcularValorComJuros() {
        return this.valor + this.valor * this.jurosPorDia * dataPagamento.until(LocalDate.now(),DAYS);
    }
}
