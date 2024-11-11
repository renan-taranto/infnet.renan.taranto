package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.Historico;
import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.input.usecase.BuscarMoto;
import br.edu.infnet.renan.taranto.port.input.usecase.SalvarHistorico;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(2)
public class HistoricoLoader implements EntityLoader {
    private final LeitorCsv leitorCsv;
    private final BuscarMoto buscarMoto;
    private final SalvarHistorico salvarHistorico;

    public HistoricoLoader(LeitorCsv leitorCsv, BuscarMoto buscarMoto, SalvarHistorico salvarHistorico) {
        this.leitorCsv = leitorCsv;
        this.buscarMoto = buscarMoto;
        this.salvarHistorico = salvarHistorico;
    }

    @Override
    public void load() {
        List<String[]> dados = leitorCsv.ler("files/motos.csv");
        for (String[] linha : dados) {
            Moto moto = buscarMotoPorId(Integer.parseInt(linha[0]));
            Historico historico = new Historico(moto, LocalDate.parse(linha[3]));
            salvarHistorico.salvar(historico);
            System.out.println("Histórico de despesas carregado: " + historico);
        }
    }
    
    private Moto buscarMotoPorId(int id) {
        return buscarMoto.buscarPorId(id).orElseThrow(
                () -> new RuntimeException("Erro ao criar 'Historico' da 'Moto' de id '" + id + "'. Moto não encontrada.")
        );
    }
}
