package br.edu.infnet.renan.taranto.adapter.client;

import br.edu.infnet.renan.taranto.domain.entity.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface FeignEnderecoClient {
    @GetMapping(value = "/{cep}/json/")
    Endereco findByCep(@PathVariable String cep);
}
