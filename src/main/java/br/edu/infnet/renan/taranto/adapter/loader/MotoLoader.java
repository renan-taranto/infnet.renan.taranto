package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.input.usecase.SalvarMoto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class MotoLoader implements EntityLoader {
    private final LeitorCsv leitorCsv;
    private final SalvarMoto salvarMoto;

    public MotoLoader(LeitorCsv leitorCsv, SalvarMoto salvarMoto) {
        this.leitorCsv = leitorCsv;
        this.salvarMoto = salvarMoto;
    }

    @Override
    public void load() {
        List<String[]> dados = leitorCsv.ler("files/motos.csv");
        for (String[] linha : dados) {
            Moto moto = new Moto(Integer.parseInt(linha[0]), linha[1], linha[2]);
            salvarMoto.salvar(moto);
            System.out.println("Moto carregada: " + moto);
        }
    }
}
