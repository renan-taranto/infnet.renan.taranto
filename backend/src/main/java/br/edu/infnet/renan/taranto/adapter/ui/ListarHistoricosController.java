package br.edu.infnet.renan.taranto.adapter.ui;

import br.edu.infnet.renan.taranto.port.input.usecase.ListarHistoricos;
import br.edu.infnet.renan.taranto.port.input.usecase.dto.HistoricosResponse;
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
    public HistoricosResponse listar(@RequestParam(name = "motoId", required = false) Integer motoId) {
        if (motoId != null) {
            return listarHistoricos.listar(motoId);
        }
        return listarHistoricos.listar();
    }
}
