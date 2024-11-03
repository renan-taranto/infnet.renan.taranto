package br.edu.infnet.renan.taranto.adapter.loader;

import br.edu.infnet.renan.taranto.domain.entity.HistoricoDespesas;
import br.edu.infnet.renan.taranto.domain.entity.Moto;
import br.edu.infnet.renan.taranto.port.output.repository.HistoricoDespesasRepository;
import br.edu.infnet.renan.taranto.port.output.repository.MotoRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Loader implements ApplicationRunner {
    private List<DespesaObserver> observers;
    private HistoricoDespesasRepository historicoDespesasRepository;
    private MotoRepository motoRepository;

    public Loader(List<DespesaObserver> observers, HistoricoDespesasRepository historicoDespesasRepository, MotoRepository motoRepository) {
        this.observers = observers;
        this.historicoDespesasRepository = historicoDespesasRepository;
        this.motoRepository = motoRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        try {
            carregarHistorico();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carregarHistorico() throws Exception {
        BufferedReader leitor = new BufferedReader(new FileReader("files/despesas.csv"));
        leitor.readLine(); //Ignora a primeira linha contendo os cabeçalhos do csv

        Map<Long, HistoricoDespesas> historicos = new HashMap<>();
        String linha;
        while ((linha = leitor.readLine()) != null) {
            String[] dados = linha.split(",");
            long motoId = Long.parseLong(dados[0]);

            HistoricoDespesas historico = obterOuCriarHistorico(historicos, motoId);
            notificarObservers(dados, historico);
        }
        leitor.close();

        incluir(historicos.values());
    }

    private HistoricoDespesas obterOuCriarHistorico(Map<Long, HistoricoDespesas> historicos, long motoId) {
        // Verifica se já existe um historico para a moto com o ID fornecido
        HistoricoDespesas historico = historicos.get(motoId);

        // Se não existir, cria uma nova moto e seu histórico
        if (historico == null) {
            Moto moto = new Moto(motoId);
            motoRepository.salvar(moto);
            historico = new HistoricoDespesas(moto);
            historicos.put(motoId, historico);
        }

        return historico;
    }

    private void notificarObservers(String[] dados, HistoricoDespesas historico) {
        // Notifica todos os observers para tentarem criar uma despesa
        for (DespesaObserver observer : observers) {
            observer.criarDespesa(dados, historico);
        }
    }

    private void incluir(Collection<HistoricoDespesas> historicos) {
        for(HistoricoDespesas h: historicos) {
            historicoDespesasRepository.incluir(h); // Inclui os históricos no repositório
            System.out.println(h);
        }
    }
}
