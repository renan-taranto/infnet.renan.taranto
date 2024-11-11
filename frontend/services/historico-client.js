import { useNuxtApp } from '#app';

export default function createHistoricoClient() {
    // Initialize the fetch instance once
    const { $apiFetch } = useNuxtApp();

    return {
        async buscarTodos() {
            return $apiFetch('/historicos');
        },
        async buscarPorMoto(motoId) {
            return $apiFetch(`/historicos?motoId=${motoId}`);
        },
    }
}
