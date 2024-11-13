package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import br.edu.infnet.renan.taranto.domain.entity.Endereco;
import br.edu.infnet.renan.taranto.port.input.usecase.abastecimento.IncluirAbastecimento;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(2)
public class AbastecimentoLoader implements EntityLoader {
    private final LeitorCsv leitorCsv;
    private final IncluirAbastecimento incluirAbastecimento;

    public AbastecimentoLoader(LeitorCsv leitorCsv, IncluirAbastecimento incluirAbastecimento) {
        this.leitorCsv = leitorCsv;
        this.incluirAbastecimento = incluirAbastecimento;
    }

    @Override
    public void load() {
        List<String[]> dados = leitorCsv.ler("files/despesas.csv");
        for (String[] linha : dados) {
            if (!linha[0].equalsIgnoreCase("abastecimento")) {
                continue;
            }

            Abastecimento abastecimento = new Abastecimento(
                    LocalDate.parse(linha[2]),
                    Float.parseFloat(linha[3]),
                    Float.parseFloat(linha[6]),
                    linha[7]
            );
            abastecimento.setEndereco(new Endereco(linha[8]));
            incluirAbastecimento.incluir(Integer.parseInt(linha[1]), abastecimento);

            System.out.println("Abastecimento carregado: " + abastecimento);
        }
    }
}
