package br.edu.infnet.renan.taranto.adapter.ui.manutencao;

import br.edu.infnet.renan.taranto.port.input.usecase.manutenco.ListarManutencoes;
import br.edu.infnet.renan.taranto.port.input.usecase.dto.ManutencoesResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    @Tag(name = "Manutenções")
    @Operation(summary = "Lista manutenções")
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
