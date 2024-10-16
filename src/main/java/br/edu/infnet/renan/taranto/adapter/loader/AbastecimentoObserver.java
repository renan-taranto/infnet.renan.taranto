package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class AbastecimentoObserver implements DespesaObserver {

    @Override
    public void criarDespesa(String[] dados, HistoricoDespesas historicoDespesas) {
        String tipoDespesa = dados[2];
        if ("Abastecimento".equalsIgnoreCase(tipoDespesa)) {
            Abastecimento abastecimento = new Abastecimento(
                    LocalDate.parse(dados[1], DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    Float.parseFloat(dados[3]),
                    Float.parseFloat(dados[5])
            );

            historicoDespesas.adicionarDespesa(abastecimento);
        }
    }
}
