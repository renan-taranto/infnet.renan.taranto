package br.edu.infnet.renan.taranto.adapter.client;

import br.edu.infnet.renan.taranto.domain.entity.Endereco;
import br.edu.infnet.renan.taranto.port.output.client.EnderecoClient;
import org.springframework.stereotype.Service;

@Service
public class FeignEnderecoClientImpl implements EnderecoClient {
    private final FeignEnderecoClient feignEnderecoClient;

    public FeignEnderecoClientImpl(FeignEnderecoClient feignEnderecoClient) {
        this.feignEnderecoClient = feignEnderecoClient;
    }

    @Override
    public Endereco findByCep(String cep) {
        return feignEnderecoClient.findByCep(cep);
    }
}
