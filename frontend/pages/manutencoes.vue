<script setup>
  import createManutencaoClient from '~/services/manutencao-client.js';
  import {formatDateBR} from "~/utils/date-formatter.js";
  import {formatDecimalPT} from "~/utils/format-decimal.js";

  const pending = ref(false);
  const error = ref(null);
  const manutencoes = ref(null);

  const headers = ref([
    { title: "Id", key: "id" },
    { title: "Valor", key: "valor" },
    { title: "Data", key: "data" },
    { title: "Tipo da Manutenção", key: "tipo" },
    { title: "Observações", key: "observacoes" },
  ])

  const carregarManutencoes = async () => {
    pending.value = true;
    try {
      const manutencaoClient = createManutencaoClient();
      const response = await manutencaoClient.buscarTodos();
      manutencoes.value = response.manutencoes;
    } catch (err) {
      error.value = err.message || 'Erro ao buscar manutencoes.';
    } finally {
      pending.value = false;
    }
  }

  onMounted(() => {
    carregarManutencoes();
  })
</script>

<template>
  <div>
    <HomeButton />
    <h1 class="mb-8">Manutenções</h1>

    <p v-if="pending">
      Carregando...
    </p>
    <pre v-else-if="error">{{ error }}</pre>
    <v-data-table
        v-else-if="manutencoes"
        class="mt-8"
        :items="manutencoes"
        :headers="headers"
    >
      <template v-slot:body="{ items }">
        <tr v-for="(item, index) in items" :key="index">
          <td>{{ item.id }}</td>
          <td>{{ formatCurrencyBRL(item.valor) }}</td>
          <td>{{ formatDateBR(item.data) }}</td>
          <td>{{ item.tipo }}</td>
          <td>{{ item.observacoes }}</td>
        </tr>
      </template>
    </v-data-table>
  </div>
</template>
