package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.Manutencao;
import br.edu.infnet.renan.taranto.port.input.usecase.manutenco.IncluirManutencao;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(3)
public class ManutencaoLoader implements EntityLoader {
    private final LeitorCsv leitorCsv;
    private final IncluirManutencao incluirManutencao;

    public ManutencaoLoader(LeitorCsv leitorCsv, IncluirManutencao incluirManutencao) {
        this.leitorCsv = leitorCsv;
        this.incluirManutencao = incluirManutencao;
    }

    @Override
    public void load() {
        List<String[]> dados = leitorCsv.ler("files/despesas.csv");
        for (String[] linha : dados) {
            if (!linha[0].equalsIgnoreCase("manutencao")) {
                continue;
            }

            Manutencao manutencao = new Manutencao(
                    LocalDate.parse(linha[2]),
                    Float.parseFloat(linha[3]),
                    linha[4],
                    linha[5]
            );
            incluirManutencao.incluir(Integer.parseInt(linha[1]), manutencao);
            System.out.println("Manutencao carregada: " + manutencao);
        }
    }
}
