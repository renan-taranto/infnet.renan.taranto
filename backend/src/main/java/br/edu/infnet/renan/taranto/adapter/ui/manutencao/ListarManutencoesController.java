package br.edu.infnet.renan.taranto.adapter.ui.manutencao;

import br.edu.infnet.renan.taranto.port.input.usecase.ListarManutencoes;
import br.edu.infnet.renan.taranto.port.input.usecase.dto.ManutencoesResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListarManutencoesController {
    private final ListarManutencoes listarManutencoes;

    public ListarManutencoesController(ListarManutencoes listarManutencoes) {
        this.listarManutencoes = listarManutencoes;
    }

    @GetMapping(value = "/manutencoes")
    public ManutencoesResponse listar() {
        return listarManutencoes.listar();
    }
}
