package br.edu.infnet.renan.taranto.adapter.ui.abastecimento;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import br.edu.infnet.renan.taranto.port.input.usecase.abastecimento.IncluirAbastecimento;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncluirAbastecimentoController {
    private final IncluirAbastecimento incluirAbastecimento;

    public IncluirAbastecimentoController(IncluirAbastecimento incluirAbastecimento) {
        this.incluirAbastecimento = incluirAbastecimento;
    }

    @PostMapping("/motos/{motoId}/abastecimentos")
    public ResponseEntity<String> incluir(@PathVariable int motoId, @RequestBody Abastecimento abastecimento) {
        incluirAbastecimento.incluir(motoId, abastecimento);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
