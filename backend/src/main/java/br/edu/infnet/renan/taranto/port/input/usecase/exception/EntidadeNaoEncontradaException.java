package br.edu.infnet.renan.taranto.port.input.usecase.exception;

public class EntidadeNaoEncontradaException extends RuntimeException {
    public EntidadeNaoEncontradaException() {
        super("Entidade não encontrada!");
    }
}
