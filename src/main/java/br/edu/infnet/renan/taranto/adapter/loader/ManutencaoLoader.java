package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import br.edu.infnet.renan.taranto.domain.entity.Manutencao;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoDespesasRepository;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Component
@Order(3)
public class ManutencaoLoader implements EntityLoader {
    private final LeitorCsv leitorCsv;
    private final HistoricoDespesasRepository historicoDespesasRepository;

    public ManutencaoLoader(LeitorCsv leitorCsv, HistoricoDespesasRepository historicoDespesasRepository) {
        this.leitorCsv = leitorCsv;
        this.historicoDespesasRepository = historicoDespesasRepository;
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
            historicoDespesasRepository.salvar(historicoDespesas);
            System.out.println("Manutencao carregada: " + manutencao);
        }
    }

    private HistoricoDespesas buscarHistoricoPorMotoId(int motoId) {
        return historicoDespesasRepository.obterPorMotoId(motoId).orElseThrow(
                () -> new RuntimeException("Erro ao criar 'Manutencao' da 'Moto' de id '" + motoId + "'. 'HistoricoDespesas' não encontrado.")
        );
    }
}
