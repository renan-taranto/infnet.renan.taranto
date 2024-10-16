package br.edu.infnet.renan.taranto.adapter.ui;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import br.edu.infnet.renan.taranto.port.input.usecase.ListarHistoricos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListarHistoricosController {
    private ListarHistoricos listarHistoricos;

    public ListarHistoricosController(ListarHistoricos listarHistoricos) {
        this.listarHistoricos = listarHistoricos;
    }

    @GetMapping(value = "/historicos")
    public List<HistoricoDespesas> listar() {
        return listarHistoricos.listar();
    }
}
