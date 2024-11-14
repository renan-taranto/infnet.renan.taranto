package br.edu.infnet.renan.taranto.adapter.ui.historico;

import br.edu.infnet.renan.taranto.port.input.usecase.historico.ListarHistoricos;
import br.edu.infnet.renan.taranto.port.input.usecase.dto.HistoricosResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListarHistoricosController {
    private ListarHistoricos listarHistoricos;

    public ListarHistoricosController(ListarHistoricos listarHistoricos) {
        this.listarHistoricos = listarHistoricos;
    }

    @GetMapping(value = "/historicos")
    @Tag(name = "Históricos")
    @Operation(summary = "Lista históricos")
    public HistoricosResponse listar(@RequestParam(name = "motoId", required = false) Integer motoId) {
        if (motoId != null) {
            return listarHistoricos.listar(motoId);
        }
        return listarHistoricos.listar();
    }
}
