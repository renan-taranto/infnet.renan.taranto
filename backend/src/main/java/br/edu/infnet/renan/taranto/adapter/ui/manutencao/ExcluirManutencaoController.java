package br.edu.infnet.renan.taranto.adapter.ui.manutencao;

import br.edu.infnet.renan.taranto.port.input.usecase.manutenco.ExcluirManutencao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcluirManutencaoController {
    private final ExcluirManutencao excluirManutencao;

    public ExcluirManutencaoController(ExcluirManutencao excluirManutencao) {
        this.excluirManutencao = excluirManutencao;
    }

    @DeleteMapping(value = "/manutencoes/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        excluirManutencao.excluirManutencao(id);
        return ResponseEntity.noContent().build();
    }
}
