package br.edu.infnet.renan.taranto.adapter.ui.manutencao;

import br.edu.infnet.renan.taranto.port.input.usecase.manutenco.ListarManutencoes;
import br.edu.infnet.renan.taranto.port.input.usecase.dto.ManutencoesResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class ListarManutencoesController {
    private final ListarManutencoes listarManutencoes;

    public ListarManutencoesController(ListarManutencoes listarManutencoes) {
        this.listarManutencoes = listarManutencoes;
    }

    @GetMapping(value = "/manutencoes")
    public ManutencoesResponse listar(
            @RequestParam(name = "dataInicial", required = false) LocalDate dataInicial,
            @RequestParam(name = "dataFinal", required = false) LocalDate dataFinal
    ) {
        if (dataInicial != null && dataFinal != null) {
            return listarManutencoes.listar(dataInicial, dataFinal);
        }

        return listarManutencoes.listar();
    }
}
