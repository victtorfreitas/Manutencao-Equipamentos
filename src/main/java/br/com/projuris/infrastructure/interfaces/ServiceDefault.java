package br.com.projuris.infrastructure.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ServiceDefault<T> {

    Page<T> findAll(Pageable pageable);

    List<T> findAll();

    Optional<T> findOne(Long id);

    T insert(T entity);

    T update(T entity);

    void remove(T entity);

    void removeById(Long id);
}
