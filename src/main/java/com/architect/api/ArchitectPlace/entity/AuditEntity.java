package com.architect.api.ArchitectPlace.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class AuditEntity {


    @CreatedDate
    @JoinColumn(name = "created_at")
    private Instant createdAt;

    @LastModifiedDate
    @JoinColumn(name = "modified_at")
    private Instant modifiedAt;
}
