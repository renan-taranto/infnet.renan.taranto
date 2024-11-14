package br.edu.infnet.renan.taranto.adapter.ui.manutencao;

import br.edu.infnet.renan.taranto.domain.entity.Manutencao;
import br.edu.infnet.renan.taranto.port.input.usecase.manutenco.AlterarManutencao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlterarManutencaoController {
    private final AlterarManutencao alterarManutencao;

    public AlterarManutencaoController(AlterarManutencao alterarManutencao) {
        this.alterarManutencao = alterarManutencao;
    }

    @PutMapping("/manutencoes/{id}")
    @Tag(name = "Manutenções")
    @Operation(summary = "Lista manutenções")
    public ResponseEntity<Manutencao> alterar(@PathVariable int id, @Valid @RequestBody Manutencao manutencao) {
        Manutencao manutencaoAtualizada = alterarManutencao.alterar(id, manutencao);

        return ResponseEntity.ok(manutencaoAtualizada);
    }
}
