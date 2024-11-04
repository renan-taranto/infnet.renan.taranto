package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import br.edu.infnet.renan.taranto.domain.entity.Manutencao;
import br.edu.infnet.renan.taranto.port.input.usecase.BuscarHistoricoDespesas;
import br.edu.infnet.renan.taranto.port.input.usecase.SalvarHistoricoDespesa;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(3)
public class ManutencaoLoader implements EntityLoader {
    private final LeitorCsv leitorCsv;
    private final BuscarHistoricoDespesas buscarHistoricoDespesas;
    private final SalvarHistoricoDespesa salvarHistoricoDespesa;

    public ManutencaoLoader(LeitorCsv leitorCsv, BuscarHistoricoDespesas buscarHistoricoDespesas, SalvarHistoricoDespesa salvarHistoricoDespesa) {
        this.leitorCsv = leitorCsv;
        this.buscarHistoricoDespesas = buscarHistoricoDespesas;
        this.salvarHistoricoDespesa = salvarHistoricoDespesa;
    }

    @Override
    public void load() {
        List<String[]> dados = leitorCsv.ler("files/despesas.csv");
        for (String[] linha : dados) {
            if (!linha[0].equalsIgnoreCase("manutencao")) {
                continue;
            }

            HistoricoDespesas historicoDespesas = buscarHistoricoPorMotoId(Integer.parseInt(linha[1]));
            Manutencao manutencao = new Manutencao(
                    LocalDate.parse(linha[2]),
                    Float.parseFloat(linha[3]),
                    linha[4],
                    linha[5]
            );
            historicoDespesas.adicionarDespesa(manutencao);
            salvarHistoricoDespesa.salvar(historicoDespesas);
            System.out.println("Manutencao carregada: " + manutencao);
        }
    }

    private HistoricoDespesas buscarHistoricoPorMotoId(int motoId) {
        return buscarHistoricoDespesas.buscarPorMotoId(motoId).orElseThrow(
                () -> new RuntimeException("Erro ao criar 'Manutencao' da 'Moto' de id '" + motoId + "'. 'HistoricoDespesas' não encontrado.")
        );
    }
}
