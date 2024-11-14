package br.edu.infnet.renan.taranto.adapter.ui.moto;

import br.edu.infnet.renan.taranto.port.input.usecase.moto.ListarMotos;
import br.edu.infnet.renan.taranto.port.input.usecase.dto.MotosResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListarMotosController {
    private ListarMotos listarMotos;

    public ListarMotosController(ListarMotos listarMotos) {
        this.listarMotos = listarMotos;
    }

    @GetMapping(value = "/motos")
    @Tag(name = "Motos")
    @Operation(summary = "Lista motos")
    public MotosResponse listar(@RequestParam(name = "marca", required = false) String marca) {
        if (marca != null) {
            return listarMotos.listar(marca);
        }
        return listarMotos.listar();
    }
}
