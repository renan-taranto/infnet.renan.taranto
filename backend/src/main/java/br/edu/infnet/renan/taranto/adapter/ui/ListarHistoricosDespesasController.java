package br.edu.infnet.renan.taranto.adapter.ui;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import br.edu.infnet.renan.taranto.port.input.usecase.ListarHistoricosDespesas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListarHistoricosDespesasController {
    private ListarHistoricosDespesas listarHistoricos;

    public ListarHistoricosDespesasController(ListarHistoricosDespesas listarHistoricos) {
        this.listarHistoricos = listarHistoricos;
    }

    @GetMapping(value = "/historicos-despesas")
    public List<HistoricoDespesas> listar() {
        return listarHistoricos.listar();
    }
}
