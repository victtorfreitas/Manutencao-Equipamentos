package br.com.projuris.infrastructure.interfaces;

/**
 * Interface para padronizar os Dissambler
 *
 * @param <T> Classe real
 * @param <E> DTO de entrada input
 */
public interface DissamblerDefault<T, E> {
    T toDomainObject(E e);
    void copyToDomainObject(E e, T t);
}
