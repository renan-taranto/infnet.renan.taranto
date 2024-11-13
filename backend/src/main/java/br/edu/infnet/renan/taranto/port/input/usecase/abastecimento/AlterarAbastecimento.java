package br.edu.infnet.renan.taranto.port.input.usecase.abastecimento;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import br.edu.infnet.renan.taranto.port.input.usecase.exception.EntidadeNaoEncontradaException;
import br.edu.infnet.renan.taranto.port.output.client.EnderecoClient;
import br.edu.infnet.renan.taranto.port.output.repository.AbastecimentoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlterarAbastecimento {
    private final AbastecimentoRepository abastecimentoRepository;
    private final EnderecoClient enderecoClient;

    public AlterarAbastecimento(AbastecimentoRepository abastecimentoRepository, EnderecoClient enderecoClient) {
        this.abastecimentoRepository = abastecimentoRepository;
        this.enderecoClient = enderecoClient;
    }

    public Abastecimento alterar(int id, Abastecimento abastecimento) {
        Abastecimento abastecimentoExistente = abastecimentoRepository.buscarPorId(id).orElseThrow(EntidadeNaoEncontradaException::new);

        abastecimentoExistente.setLitrosAbastecidos(abastecimento.getLitrosAbastecidos());
        abastecimentoExistente.setTipoCombustivel(abastecimento.getTipoCombustivel());
        abastecimentoExistente.setValor(abastecimento.getValor());
        abastecimentoExistente.setData(abastecimento.getData());
        abastecimentoExistente.setEndereco(enderecoClient.findByCep(abastecimento.getEndereco().getCep()));

        return abastecimentoRepository.salvar(abastecimentoExistente);
    }
}
