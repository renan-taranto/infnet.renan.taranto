package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoDespesasRepository;
import br.edu.infnet.renan.taranto.port.output.repository.MotoRepository;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(2)
public class HistoricoDespesasLoader implements EntityLoader {
    private final LeitorCsv leitorCsv;
    private final MotoRepository motoRepository;
    private final HistoricoDespesasRepository historicoDespesasRepository;

    public HistoricoDespesasLoader(LeitorCsv leitorCsv, MotoRepository motoRepository, HistoricoDespesasRepository historicoDespesasRepository) {
        this.leitorCsv = leitorCsv;
        this.motoRepository = motoRepository;
        this.historicoDespesasRepository = historicoDespesasRepository;
    }

    @Override
    public void load() {
        List<String[]> dados = leitorCsv.ler("files/motos.csv");
        for (String[] linha : dados) {
            Moto moto = buscarMotoPorId(Integer.parseInt(linha[0]));
            HistoricoDespesas historicoDespesas = new HistoricoDespesas(moto, LocalDate.parse(linha[3]));
            historicoDespesasRepository.salvar(historicoDespesas);
            System.out.println("Histórico de despesas carregado: " + historicoDespesas);
        }
    }
    
    private Moto buscarMotoPorId(int id) {
        return motoRepository.buscarPorId(id).orElseThrow(
                () -> new RuntimeException("Erro ao criar 'HistoricoDespesa' da 'Moto' de id '" + id + "'. Moto não encontrada.")
        );
    }
}
