package br.edu.infnet.renan.taranto.adapter.ui;

import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.input.usecase.ListarMotos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListarMotosController {
    private ListarMotos listarMotos;

    public ListarMotosController(ListarMotos listarMotos) {
        this.listarMotos = listarMotos;
    }

    @GetMapping(value = "/motos")
    public List<Moto> listar() {
        return listarMotos.listar();
    }
}
