<script setup>
  import createMotoClient from "~/services/moto-client.js";

  const pending = ref(false);
  const error = ref(null);
  const motos = ref(null);

  const headers = ref([
    { title: "Marca", key: "marca" },
    { title: "Modelo", key: "modelo" },
  ]);

  const carregarMotos = async () => {
    pending.value = true;
    try {
      const motoClient = createMotoClient();
      const response = await motoClient.buscarTodos();
      motos.value = response.motos;
    } catch (err) {
      error.value = err.message || 'Erro ao buscar motos.';
    } finally {
      pending.value = false;
    }
  }

  onMounted(() => {
    carregarMotos();
  })
</script>

<template>
  <div>
    <h1 class="mb-8">Motos</h1>

    <p v-if="pending">
      Fetching...
    </p>
    <pre v-else-if="error">{{ error }}</pre>
    <v-data-table
        v-else-if="motos"
        class="mt-8"
        :items="motos"
    />
  </div>
</template>
