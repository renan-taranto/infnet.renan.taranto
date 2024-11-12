import { useNuxtApp } from '#app';

export default function createManutencaoClient() {
    // Initialize the fetch instance once
    const { $apiFetch } = useNuxtApp();

    return {
        // Use $apiFetch in all methods
        async buscarTodos() {
            return $apiFetch('/manutencoes');
        }
    }
}
