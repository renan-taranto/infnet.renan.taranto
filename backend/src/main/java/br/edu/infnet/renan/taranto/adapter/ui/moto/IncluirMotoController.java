package br.edu.infnet.renan.taranto.adapter.ui.moto;

import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.input.usecase.moto.IncluirMoto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class IncluirMotoController {
    private final IncluirMoto incluirMoto;

    public IncluirMotoController(IncluirMoto incluirMoto) {
        this.incluirMoto = incluirMoto;
    }

    @PostMapping("/motos")
    @Tag(name = "Motos")
    @Operation(summary = "Inclui uma moto")
    public ResponseEntity<String> incluir(@Valid @RequestBody Moto moto) {
        incluirMoto.incluir(moto, LocalDate.now());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
