<script setup>
  import createAbastecimentoClient from "~/services/abastecimento-client.js";
  import {formatDateBR} from "~/utils/date-formatter.js";
  import {formatDecimalPT} from "~/utils/format-decimal.js";

  const pending = ref(false);
  const error = ref(null);
  const abastecimentos = ref(null);

  const headers = ref([
    { title: "Id", key: "id" },
    { title: "Valor", key: "valor" },
    { title: "Data", key: "data" },
    { title: "Litros Abastecidos", key: "litrosAbastecidos" },
    { title: "Tipo de Combustível", key: "tipoCombustivel" },
    { title: "Cep do Posto de Combustível", key: "endereco.cep" },
  ])

  const carregarAbastecimentos = async () => {
    pending.value = true;
    try {
      const abastecimentosClient = createAbastecimentoClient();
      const response = await abastecimentosClient.buscarTodos();
      abastecimentos.value = response.abastecimentos;
    } catch (err) {
      error.value = err.message || 'Erro ao buscar abastecimentos.';
    } finally {
      pending.value = false;
    }
  }

  onMounted(() => {
    carregarAbastecimentos();
  })
</script>

<template>
  <div>
    <HomeButton />
    <h1 class="mb-8">Abastecimentos</h1>

    <p v-if="pending">
      Carregando...
    </p>
    <pre v-else-if="error">{{ error }}</pre>
    <v-data-table
        v-else-if="abastecimentos"
        class="mt-8"
        :items="abastecimentos"
        :headers="headers"
    >
      <template v-slot:body="{ items }">
        <tr v-for="(item, index) in items" :key="index">
          <td>{{ item.id }}</td>
          <td>{{ formatCurrencyBRL(item.valor) }}</td>
          <td>{{ formatDateBR(item.data) }}</td>
          <td>{{ formatDecimalPT(item.litrosAbastecidos) }}</td>
          <td>{{ item.tipoCombustivel }}</td>
          <td>{{ item.endereco.cep }}</td>
        </tr>
      </template>
    </v-data-table>
  </div>
</template>
