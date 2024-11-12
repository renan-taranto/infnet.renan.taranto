package br.edu.infnet.renan.taranto.adapter.ui;

import br.edu.infnet.renan.taranto.port.input.usecase.ListarAbastecimentos;
import br.edu.infnet.renan.taranto.port.input.usecase.dto.AbastecimentosResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListarAbastecimentosController {
    private ListarAbastecimentos listarAbastecimentos;

    public ListarAbastecimentosController(ListarAbastecimentos listarAbastecimentos) {
        this.listarAbastecimentos = listarAbastecimentos;
    }

    @GetMapping(value = "/abastecimentos")
    public AbastecimentosResponse listar() {
        return listarAbastecimentos.listar();
    }
}
