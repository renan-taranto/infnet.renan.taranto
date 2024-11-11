import { useNuxtApp } from '#app';

export default function createMotosClient() {
    // Initialize the fetch instance once
    const { $apiFetch } = useNuxtApp();

    return {
        // Use $apiFetch in all methods
        async buscarTodos() {
            return $apiFetch('/motos');
        }
    }
}
