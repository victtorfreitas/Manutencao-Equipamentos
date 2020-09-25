package br.com.projuris.infrastructure.abstracts;

import br.com.projuris.infrastructure.interfaces.RepositoryDefault;
import br.com.projuris.infrastructure.interfaces.ServiceDefault;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class ServiceAbsDefault<T extends EntityAuditAbsDefault> implements ServiceDefault<T> {

    private final RepositoryDefault<T> repository;

    public ServiceAbsDefault(RepositoryDefault<T> repository) {
        this.repository = repository;
    }

    @Override
    public Optional<T> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public T insert(T entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void remove(T entity) {
        repository.delete(entity);
    }

    @Override
    @Transactional
    public void removeById(Long id) {
        repository.deleteById(id);
    }
}
