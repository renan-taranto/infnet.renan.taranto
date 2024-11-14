package br.edu.infnet.renan.taranto.adapter.ui.abastecimento;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import br.edu.infnet.renan.taranto.port.input.usecase.abastecimento.AlterarAbastecimento;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlterarAbastecimentoController {
    private final AlterarAbastecimento alterarAbastecimento;

    public AlterarAbastecimentoController(AlterarAbastecimento alterarAbastecimento) {
        this.alterarAbastecimento = alterarAbastecimento;
    }

    @PutMapping("/abastecimentos/{id}")
    @Tag(name = "Abastecimento")
    @Operation(summary = "Altera um abastecimento")
    public ResponseEntity<Abastecimento> alterar(@PathVariable int id, @Valid @RequestBody Abastecimento abastecimento) {
        Abastecimento abstecimentoAtualizado = alterarAbastecimento.alterar(id, abastecimento);

        return ResponseEntity.ok(abstecimentoAtualizado);
    }
}
