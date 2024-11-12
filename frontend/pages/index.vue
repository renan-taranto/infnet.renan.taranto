<template>
  <div class="mt-10">
    <v-row align="center" justify="center" dense>
      <v-col
          v-for="item in items"
          cols="12"
          sm="1"
          md="3"
      >
        <v-card class="mx-auto my-4" max-width="400">
          <v-card-title class="d-flex align-center">
            <v-icon class="mr-3">{{ item.icon }}</v-icon>
            <span class="text-h4">{{ item.total }}</span>
          </v-card-title>

          <v-card-subtitle class="text-h6" style="font-weight: bold;">
            {{ item.title }}
          </v-card-subtitle>

          <v-card-actions>
            <v-btn color="primary" size="small" @click="goTo(item.link)">Ver mais</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </div>
</template>
<script setup>
import { useRouter } from 'vue-router';
import createMotoClient from "~/services/moto-client.js";
import createHistoricoClient from "~/services/historico-client.js";
import createAbastecimentoClient from "~/services/abastecimento-client.js";
import createManutencaoClient from "~/services/manutencao-client.js";

const carregarMotos = async () => {
  const motoClient = createMotoClient();
  const response = await motoClient.buscarTodos();
  items.value.push({
    title: "Motos",
    icon: "mdi-motorbike",
    total: response.total,
    link: "/motos"
  });
}
const carregarHistoricos = async () => {
  const historicoClient = createHistoricoClient();
  const response = await historicoClient.buscarTodos();
  items.value.push({
    title: "Históricos",
    icon: "mdi-history",
    total: response.total,
    link: "/historicos"
  });
}
const carregarAbastecimentos = async () => {
  const AbastecimentoClient = createAbastecimentoClient();
  const response = await AbastecimentoClient.buscarTodos();
  items.value.push({
    title: "Abastecimentos",
    icon: "mdi-gas-station",
    total: response.total,
    link: "/abastecimentos"
  });
}
const carregarManutencoes = async () => {
  const ManutencoesClient = createManutencaoClient();
  const response = await ManutencoesClient.buscarTodos();
  items.value.push({
    title: "Manutenções",
    icon: "mdi-wrench",
    total: response.total,
    link: "/manutencoes"
  });
}

const router = useRouter();
const goTo = (url) => {
  router.push(url);
}

const items = ref([]);

onMounted(async () => {
  await carregarMotos();
  await carregarHistoricos();
  await carregarAbastecimentos();
  await carregarManutencoes();
});

</script>