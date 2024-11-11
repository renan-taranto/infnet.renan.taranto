<script setup>
  import createMotoClient from "~/services/moto-client.js";

  const selectLabel = ref('Selecione...');
  const motos = ref([]);

  const carregarMotos = async () => {
    try {
      const motosClient = createMotoClient();
      selectLabel.value = 'Carregando...';
      const response = await motosClient.buscarTodos();
      motos.value = response.motos;
      selectLabel.value = 'Selecione...';
    } catch (err) {
      selectLabel.value = err.message || 'Erro ao buscar lista de motos.';
    }
  }

  const emit = defineEmits(['motoSelecionada']);

  const onChange = (id) => {
    emit('motoSelecionada', id);
  }

  onMounted(() => {
    carregarMotos();
  })
</script>

<template>
  <p>
    Escolha a moto para visualizar as despesas
    <v-select
        :label="selectLabel"
        :items="motos"
        item-title="modelo"
        item-value="id"
        @update:model-value="onChange"
    ></v-select>
  </p>
</template>