package br.com.projuris.infrastructure.abstracts;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Collections;
import java.util.Objects;

public abstract class QueryDslAbsSuport<T> extends QuerydslRepositorySupport {

    public QueryDslAbsSuport(Class<?> domainClass) {
        super(domainClass);
    }

    protected Page readPage(JPAQuery query, Pageable pageable) {
        if (pageable == null) {
            return readPage(query, PageRequest.of(0, Integer.MAX_VALUE));
        }

        long total = query.clone(Objects.requireNonNull(super.getEntityManager())).fetchCount();
        Objects.requireNonNull(getQuerydsl()).applyPagination(pageable, query);
        var pagedQuery = Objects.requireNonNull(getQuerydsl()).applyPagination(pageable, query);
        var content = total > pageable.getOffset() ? pagedQuery.fetch() : Collections.emptyList();
        return new PageImpl<T>(content, pageable, total);
    }
}
