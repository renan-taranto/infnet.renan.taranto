package br.edu.infnet.renan.taranto.adapter.loader;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class LeitorCsv {
    public List<String[]> ler(String fileName) {
        List<String[]> dados = new ArrayList<>();
        try {
            dados = csvToStringList(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dados;
    }

    private List<String[]> csvToStringList(String fileName) throws IOException {
        List<String[]> dados = new ArrayList<>();

        BufferedReader leitor = new BufferedReader(new FileReader(fileName));
        leitor.readLine(); //Ignora a primeira linha contendo os cabeçalhos do csv

        String linha;
        while ((linha = leitor.readLine()) != null) {
            dados.add(linha.split(","));
        }
        leitor.close();

        return dados;
    }
}
