package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.input.usecase.BuscarMoto;
import br.edu.infnet.renan.taranto.port.input.usecase.SalvarHistoricoDespesa;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(2)
public class HistoricoDespesasLoader implements EntityLoader {
    private final LeitorCsv leitorCsv;
    private final BuscarMoto buscarMoto;
    private final SalvarHistoricoDespesa incluirHistoricoDespesa;

    public HistoricoDespesasLoader(LeitorCsv leitorCsv, BuscarMoto buscarMoto, SalvarHistoricoDespesa incluirHistoricoDespesa) {
        this.leitorCsv = leitorCsv;
        this.buscarMoto = buscarMoto;
        this.incluirHistoricoDespesa = incluirHistoricoDespesa;
    }

    @Override
    public void load() {
        List<String[]> dados = leitorCsv.ler("files/motos.csv");
        for (String[] linha : dados) {
            Moto moto = buscarMotoPorId(Integer.parseInt(linha[0]));
            HistoricoDespesas historicoDespesas = new HistoricoDespesas(moto, LocalDate.parse(linha[3]));
            incluirHistoricoDespesa.salvar(historicoDespesas);
            System.out.println("Histórico de despesas carregado: " + historicoDespesas);
        }
    }
    
    private Moto buscarMotoPorId(int id) {
        return buscarMoto.buscarPorId(id).orElseThrow(
                () -> new RuntimeException("Erro ao criar 'HistoricoDespesa' da 'Moto' de id '" + id + "'. Moto não encontrada.")
        );
    }
}
