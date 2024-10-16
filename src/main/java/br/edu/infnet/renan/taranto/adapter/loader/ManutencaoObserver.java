package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import br.edu.infnet.renan.taranto.domain.entity.Manutencao;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ManutencaoObserver implements DespesaObserver {

    @Override
    public void criarDespesa(String[] dados, HistoricoDespesas historicoDespesas) {
        String tipoDespesa = dados[2];
        if ("Manutencao".equalsIgnoreCase(tipoDespesa)) {
            Manutencao manutencao = new Manutencao(
                    LocalDate.parse(dados[1], DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    Float.parseFloat(dados[3]),
                    dados[4]
            );

            historicoDespesas.adicionarDespesa(manutencao);
        }
    }
}
