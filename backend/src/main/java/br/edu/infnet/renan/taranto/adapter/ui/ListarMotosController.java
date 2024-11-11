package br.edu.infnet.renan.taranto.adapter.ui;

import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.input.usecase.ListarMotos;
import br.edu.infnet.renan.taranto.port.input.usecase.dto.MotosResponse;
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
    public MotosResponse listar() {
        return listarMotos.listar();
    }
}
