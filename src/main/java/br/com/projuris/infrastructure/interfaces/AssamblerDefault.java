package br.com.projuris.infrastructure.interfaces;

import java.util.List;

/**
 * Interface para padronizar os Dissambler
 *
 * @param <T> Classe real
 * @param <E> DTO de entrada input
 */
public interface AssamblerDefault<T, E> {
    E toModel(T t);

    List<E> toListModel(List<T> t);
}
