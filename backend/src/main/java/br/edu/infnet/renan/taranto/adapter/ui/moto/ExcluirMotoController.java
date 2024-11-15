package br.edu.infnet.renan.taranto.adapter.ui.moto;

import br.edu.infnet.renan.taranto.port.input.usecase.moto.ExcluirMoto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcluirMotoController {
    private final ExcluirMoto excluirMoto;

    public ExcluirMotoController(ExcluirMoto excluirMoto) {
        this.excluirMoto = excluirMoto;
    }

    @DeleteMapping(value = "/motos/{id}")
    @Tag(name = "Motos")
    @Operation(summary = "Exclui uma moto")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        excluirMoto.excluirMoto(id);
        return ResponseEntity.noContent().build();
    }
}
