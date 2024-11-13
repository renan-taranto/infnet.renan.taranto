package br.edu.infnet.renan.taranto.port.output.client;

import br.edu.infnet.renan.taranto.domain.entity.Endereco;

public interface EnderecoClient {
    Endereco findByCep(String cep);
}
