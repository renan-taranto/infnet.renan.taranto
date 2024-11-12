package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.input.usecase.moto.IncluirMoto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(1)
public class MotoLoader implements EntityLoader {
    private final LeitorCsv leitorCsv;
    private final IncluirMoto incluirMoto;

    public MotoLoader(LeitorCsv leitorCsv, IncluirMoto incluirMoto) {
        this.leitorCsv = leitorCsv;
        this.incluirMoto = incluirMoto;
    }

    @Override
    public void load() {
        List<String[]> dados = leitorCsv.ler("files/motos.csv");
        for (String[] linha : dados) {
            Moto moto = new Moto(Integer.parseInt(linha[0]), linha[1], linha[2]);
            incluirMoto.incluir(moto, LocalDate.parse(linha[3]));
            System.out.println("Moto carregada: " + moto);
        }
    }
}
