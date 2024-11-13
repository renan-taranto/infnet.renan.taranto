package br.edu.infnet.renan.taranto.adapter.ui.abastecimento;

import br.edu.infnet.renan.taranto.port.input.usecase.abastecimento.ExcluirAbastecimento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcluirAbastecimentoController {
    private final ExcluirAbastecimento excluirAbastecimento;

    public ExcluirAbastecimentoController(ExcluirAbastecimento excluirAbastecimento) {
        this.excluirAbastecimento = excluirAbastecimento;
    }

    @DeleteMapping(value = "/abastecimentos/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        excluirAbastecimento.excluirAbastecimento(id);
        return ResponseEntity.noContent().build();
    }
}