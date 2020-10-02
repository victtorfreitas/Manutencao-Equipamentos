package br.com.projuris.infrastructure.abstracts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class EntityAuditAbsDefault extends EntityAbsDefault implements Serializable {

    @JsonIgnore
    @Column(name = "IS_ATIVO")
    @ColumnDefault(value = "true")
    private Boolean ativo;

    public EntityAuditAbsDefault() {
        this.ativo = true;
    }
}
