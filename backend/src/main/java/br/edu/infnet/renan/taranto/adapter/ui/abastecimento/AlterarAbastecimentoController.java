package br.edu.infnet.renan.taranto.adapter.ui.abastecimento;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import br.edu.infnet.renan.taranto.port.input.usecase.abastecimento.AlterarAbastecimento;
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
    public ResponseEntity<Abastecimento> alterar(@PathVariable int id, @RequestBody Abastecimento abastecimento) {
        Abastecimento abstecimentoAtualizado = alterarAbastecimento.alterar(id, abastecimento);

        return ResponseEntity.ok(abstecimentoAtualizado);
    }
}
