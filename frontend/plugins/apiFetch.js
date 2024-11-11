export default defineNuxtPlugin(() => {
    const config = useRuntimeConfig();

    const apiFetch = (url, options = {}) => {
        return $fetch(url, {
            baseURL: config.public.baseURL,
            ...options,
        });
    };

    return {
        provide: {
            apiFetch,
        },
    };
});