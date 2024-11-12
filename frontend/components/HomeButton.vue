<template>
  <v-btn
      class="mb-4"
      color="primary"
      variant="outlined"
      size="small"
      @click="goHome"
  >
    <v-icon left>mdi-home</v-icon>
    Voltar para Home
  </v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();
const goHome = () => {
  router.push('/');
};
</script>