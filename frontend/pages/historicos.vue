<script setup>
  import SelectMoto from "~/components/SelectMoto.vue";
  import createHistoricoClient from "~/services/historico-client.js";
  import {formatDateBR} from "~/utils/date-formatter.js";
  import {formatDecimalPT} from "~/utils/format-decimal.js";

  const pending = ref(false);
  const error = ref(null);
  const historico = ref(null);

  const headers = ref([
    { title: "Despesa" },
    { title: "Valor", key: "valor" },
    { title: "Data", key: "data" },
    { title: "Tipo da Manutenção", key: "tipo" },
    { title: "Observações", key: "observacoes" },
    { title: "Litros Abastecidos", key: "litrosAbastecidos" },
    { title: "Tipo de Combustível", key: "tipoCombustivel" },
  ])

  const carregarHistorico = async (motoId) => {
    pending.value = true;
    try {
      const historicoClient = createHistoricoClient();
      const response = await historicoClient.buscarPorMoto(motoId);
      historico.value = response.historicos[0];
    } catch (err) {
      error.value = err.message || 'Erro ao buscar histórico de despesas.';
    } finally {
      pending.value = false;
    }
  }
</script>

<template>
  <div>
    <HomeButton />
    <h1 class="mb-8">Históricos</h1>

    <SelectMoto @motoSelecionada="carregarHistorico" />

    <p v-if="pending">
      Carregando...
    </p>
    <pre v-else-if="error">{{ error }}</pre>
    <v-data-table
        v-else-if="historico && historico.despesas.length > 0"
        class="mt-8"
        :items="historico.despesas"
        :headers="headers"
    >
      <template v-slot:body="{ items }">
        <tr v-for="(item, index) in items" :key="index">
          <td>{{ 'litrosAbastecidos' in item ? 'Abastecimento' : 'Manutenção' }}</td>
          <td>{{ formatCurrencyBRL(item.valor) }}</td>
          <td>{{ formatDateBR(item.data) }}</td>
          <td>{{ 'tipo' in item ? item.tipo : '-' }}</td>
          <td>{{ 'observacoes' in item ? item.observacoes : '-' }}</td>
          <td>{{ 'litrosAbastecidos' in item ? formatDecimalPT(item.litrosAbastecidos) : '-' }}</td>
          <td>{{ 'tipoCombustivel' in item ? item.tipoCombustivel : '-' }}</td>
        </tr>
      </template>

    </v-data-table>
    <v-alert v-if="historico && historico.despesas.length < 1" type="info" color="blue">
      Nenhuma despesa no histórico ainda.
    </v-alert>
  </div>
</template>
