package br.edu.infnet.renan.taranto.adapter.ui.moto;

import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.input.usecase.moto.AlterarMoto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlterarMotoController {
    private final AlterarMoto alterarMoto;

    public AlterarMotoController(AlterarMoto alterarMoto) {
        this.alterarMoto = alterarMoto;
    }

    @PutMapping("/motos/{id}")
    public ResponseEntity<Moto> alterar(@PathVariable int id, @RequestBody Moto moto) {
        Moto motoAtualizada = alterarMoto.alterar(id, moto);

        return ResponseEntity.ok(motoAtualizada);
    }
}
