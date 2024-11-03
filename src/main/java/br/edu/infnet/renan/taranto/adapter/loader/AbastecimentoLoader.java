package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoDespesasRepository;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(4)
public class AbastecimentoLoader implements EntityLoader {
    private LeitorCsv leitorCsv;
    private HistoricoDespesasRepository historicoDespesasRepository;

    public AbastecimentoLoader(LeitorCsv leitorCsv, HistoricoDespesasRepository historicoDespesasRepository) {
        this.leitorCsv = leitorCsv;
        this.historicoDespesasRepository = historicoDespesasRepository;
    }

    @Override
    public void load() {
        List<String[]> dados = leitorCsv.ler("files/despesas.csv");
        for (String[] linha : dados) {
            if (!linha[0].equalsIgnoreCase("abastecimento")) {
                continue;
            }

            HistoricoDespesas historicoDespesas = buscarHistoricoPorMotoId(Integer.parseInt(linha[1]));
            Abastecimento abastecimento = new Abastecimento(
                    LocalDate.parse(linha[2]),
                    Float.parseFloat(linha[3]),
                    Float.parseFloat(linha[6]),
                    linha[7]
            );
            historicoDespesas.adicionarDespesa(abastecimento);
            historicoDespesasRepository.salvar(historicoDespesas);
            System.out.println("Abastecimento carregado: " + abastecimento);
        }
    }

    private HistoricoDespesas buscarHistoricoPorMotoId(int motoId) {
        return historicoDespesasRepository.obterPorMotoId(motoId).orElseThrow(
                () -> new RuntimeException("Erro ao criar 'Abastecimento' da 'Moto' de id '" + motoId + "'. 'HistoricoDespesas' não encontrado.")
        );
    }
}
