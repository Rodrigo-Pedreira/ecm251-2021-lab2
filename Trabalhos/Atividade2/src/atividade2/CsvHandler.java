package atividade2;

import atividade2.models.Membro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * Classe publica abstrata que sera responsavel por manipular a csv file.
 */
public abstract class CsvHandler {

    /**
     * Metodo publico statico void que sera responsavel por criar uma nova csv e escrever os parametros categoria, nome, id dos membros cadastrados, referencia aos objetos Membros esta contida no mapa.
     * @param mapa HashMap<String, Membro> usado para acessar membros cadastrados.
     * @param filePath String que especifica a path para file de interesse.
     */
    public static void manipularCsv(HashMap<String, Membro> mapa, String filePath){
        prepararCsv(filePath);
        escreverCsv(mapa,filePath);
    }

    /**
     * Metodo private static void que deleta e cria uma nova file.
     * Trata exceptions internamente
     * @param filePath String que expecifica o path da file.
     */
    private static void prepararCsv(String filePath){
        try {
            File fileCsv = new File(filePath);
            fileCsv.delete();
            fileCsv.createNewFile();
            // System.out.println(filePath + " file criada com sucesso.");
        }
        catch (Exception e){
            System.out.println("Uoh! Erro ao manipular file " + filePath);
            e.printStackTrace();
        }
    }

    /**
     * Metodo private static void que ira escrever na file especificada os parametros categoria, nome, id dos membros cadastrados, referencia aos objetos Membros esta contida no mapa
     * Formato: "categoria;nome;id"
     * Trata exceptions internamente
     * @param mapa HashMap<String, Membro> que contem um nome do usuario cadastrado e a referencia para seu respectivo objeto.
     * @param filePath String que dita o path para a file em que sera realizada a escrita.
     */
    private static void escreverCsv(HashMap<String, Membro> mapa, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            mapa.forEach((k,v) -> {
                try {
                    fileWriter.write(v.getCategoria()+';'+v.getNome()+';'+v.getId());
                } catch (IOException e) {
                    System.out.println("Uoh! Erro ao tentar escrever na file " + filePath);
                    e.printStackTrace();
                }
            });
            fileWriter.close();
            // System.out.println("Informacoes escritas na file " + filePath + " com sucesso.");
        }
        catch (Exception e){
            System.out.println("Uoh! Erro ao tentar escrever na file " + filePath);
            e.printStackTrace();
        }
    }
}
