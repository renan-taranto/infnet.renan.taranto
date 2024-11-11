export function formatDecimalPT(value) {
    if (value == null) return '';

    // Converte o número para string e substitui "." por "," para o formato PT-BR
    return value.toString().replace('.', ',');
}