package br.edu.infnet.renan.taranto.adapter.ui.abastecimento;

import br.edu.infnet.renan.taranto.port.input.usecase.abastecimento.ListarAbastecimentos;
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
