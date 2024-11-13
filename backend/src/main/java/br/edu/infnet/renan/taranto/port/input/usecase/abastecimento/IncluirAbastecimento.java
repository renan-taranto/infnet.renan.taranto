package br.edu.infnet.renan.taranto.port.input.usecase.abastecimento;

import br.edu.infnet.renan.taranto.domain.entity.Abastecimento;
import br.edu.infnet.renan.taranto.domain.entity.Endereco;
import br.edu.infnet.renan.taranto.domain.entity.Historico;
import br.edu.infnet.renan.taranto.port.input.usecase.exception.EntidadeNaoEncontradaException;
import br.edu.infnet.renan.taranto.port.output.client.EnderecoClient;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoRepository;
import org.springframework.stereotype.Service;

@Service
public class IncluirAbastecimento {
    private final HistoricoRepository historicoRepository;
    private final EnderecoClient enderecoClient;

    public IncluirAbastecimento(HistoricoRepository historicoRepository, EnderecoClient enderecoClient) {
        this.historicoRepository = historicoRepository;
        this.enderecoClient = enderecoClient;
    }

    public void incluir(int motoId, Abastecimento abastecimento) {
        Historico historico = historicoRepository.obterPorMotoId(motoId).orElseThrow(EntidadeNaoEncontradaException::new);
        Endereco endereco = enderecoClient.findByCep(abastecimento.getEndereco().getCep());
        abastecimento.setEndereco(endereco);
        historico.adicionarDespesa(abastecimento);

        historicoRepository.salvar(historico);
    }
}
