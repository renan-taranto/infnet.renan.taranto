<template>
  <v-layout class="rounded rounded-md">
    <v-app-bar
        prominent
    >
      <v-app-bar-nav-icon variant="text" @click.stop="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>Controle de Despesas com Motos</v-toolbar-title>
    </v-app-bar>

    <v-navigation-drawer
        v-model="drawer"
        :permanent="isWebResolution"
    >
      <v-list-item v-for="item in items" :key="item.title" :title="item.title" :to="item.to">
      </v-list-item>
    </v-navigation-drawer>

    <v-main class="ma-6">
      <slot />
    </v-main>
  </v-layout>
</template>
<script setup>
import { useDisplay } from 'vuetify';

const display = useDisplay();
const drawer = ref(false);
const items  = ref([
  {
    title: 'Home',
    to: '/',
  },
  {
    title: 'Históricos',
    to: '/historicos',
  },
]);
const isWebResolution = computed(() => display.mdAndUp.value);

onMounted(() => {
  drawer.value = isWebResolution.value;
});
</script>