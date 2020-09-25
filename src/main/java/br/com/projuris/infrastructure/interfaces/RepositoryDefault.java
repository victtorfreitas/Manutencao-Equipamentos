package br.com.projuris.infrastructure.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RepositoryDefault<T> extends QuerydslPredicateExecutor<T>, JpaRepository<T, Long> {
}
