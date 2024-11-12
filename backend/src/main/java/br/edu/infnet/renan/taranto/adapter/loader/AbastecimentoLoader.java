package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import br.edu.infnet.renan.taranto.domain.entity.Historico;
import br.edu.infnet.renan.taranto.port.input.usecase.historico.ListarHistoricos;
import br.edu.infnet.renan.taranto.port.input.usecase.historico.SalvarHistorico;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(2)
public class AbastecimentoLoader implements EntityLoader {
    private final LeitorCsv leitorCsv;
    private final ListarHistoricos listarHistoricos;
    private final SalvarHistorico salvarHistorico;

    public AbastecimentoLoader(LeitorCsv leitorCsv, ListarHistoricos listarHistoricos, SalvarHistorico salvarHistorico) {
        this.leitorCsv = leitorCsv;
        this.listarHistoricos = listarHistoricos;
        this.salvarHistorico = salvarHistorico;
    }

    @Override
    public void load() {
        List<String[]> dados = leitorCsv.ler("files/despesas.csv");
        for (String[] linha : dados) {
            if (!linha[0].equalsIgnoreCase("abastecimento")) {
                continue;
            }

            Historico historico = buscarHistoricoPorMotoId(Integer.parseInt(linha[1]));
            Abastecimento abastecimento = new Abastecimento(
                    LocalDate.parse(linha[2]),
                    Float.parseFloat(linha[3]),
                    Float.parseFloat(linha[6]),
                    linha[7]
            );
            historico.adicionarDespesa(abastecimento);
            salvarHistorico.salvar(historico);
            System.out.println("Abastecimento carregado: " + abastecimento);
        }
    }

    private Historico buscarHistoricoPorMotoId(int motoId) {
        return listarHistoricos.listar(motoId).getHistoricos().get(0);
    }
}
