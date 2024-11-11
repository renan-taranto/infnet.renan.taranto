package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.Historico;
import br.edu.infnet.renan.taranto.domain.entity.Manutencao;
import br.edu.infnet.renan.taranto.port.input.usecase.ListarHistoricos;
import br.edu.infnet.renan.taranto.port.input.usecase.SalvarHistorico;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(3)
public class ManutencaoLoader implements EntityLoader {
    private final LeitorCsv leitorCsv;
    private final ListarHistoricos listarHistoricos;
    private final SalvarHistorico salvarHistorico;

    public ManutencaoLoader(LeitorCsv leitorCsv, ListarHistoricos listarHistoricos, SalvarHistorico salvarHistorico) {
        this.leitorCsv = leitorCsv;
        this.listarHistoricos = listarHistoricos;
        this.salvarHistorico = salvarHistorico;
    }

    @Override
    public void load() {
        List<String[]> dados = leitorCsv.ler("files/despesas.csv");
        for (String[] linha : dados) {
            if (!linha[0].equalsIgnoreCase("manutencao")) {
                continue;
            }

            Historico historico = buscarHistoricoPorMotoId(Integer.parseInt(linha[1]));
            Manutencao manutencao = new Manutencao(
                    LocalDate.parse(linha[2]),
                    Float.parseFloat(linha[3]),
                    linha[4],
                    linha[5]
            );
            historico.adicionarDespesa(manutencao);
            salvarHistorico.salvar(historico);
            System.out.println("Manutencao carregada: " + manutencao);
        }
    }

    private Historico buscarHistoricoPorMotoId(int motoId) {
        return listarHistoricos.listar(motoId).getHistoricos().get(0);
    }
}
