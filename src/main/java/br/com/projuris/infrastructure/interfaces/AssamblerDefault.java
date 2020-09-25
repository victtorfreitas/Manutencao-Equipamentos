package br.com.projuris.infrastructure.interfaces;

/**
 * Interface para padronizar os Dissambler
 *
 * @param <T> Classe real
 * @param <E> DTO de entrada input
 */
public interface AssamblerDefault<T, E> {
    E toModel(T t);
}
