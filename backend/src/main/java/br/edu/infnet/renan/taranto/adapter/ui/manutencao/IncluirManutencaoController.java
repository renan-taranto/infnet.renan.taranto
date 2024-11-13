package br.edu.infnet.renan.taranto.adapter.ui.manutencao;

import br.edu.infnet.renan.taranto.domain.entity.Manutencao;
import br.edu.infnet.renan.taranto.port.input.usecase.manutenco.IncluirManutencao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncluirManutencaoController {
    private final IncluirManutencao incluirManutencao;

    public IncluirManutencaoController(IncluirManutencao incluirManutencao) {
        this.incluirManutencao = incluirManutencao;
    }

    @PostMapping("/motos/{motoId}/manutencoes")
    public ResponseEntity<String> incluir(@PathVariable int motoId, @RequestBody Manutencao manutencao) {
        incluirManutencao.incluir(motoId, manutencao);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
