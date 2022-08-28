package com.web.models.entities.auditing;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TrackingDateTime {
   
   @CreatedDate
   @Temporal(TemporalType.TIMESTAMP)
   protected LocalDateTime created_at = LocalDateTime.now();

   @LastModifiedDate
   @Temporal(TemporalType.TIMESTAMP)
   protected LocalDateTime updated_at;

   @CreatedDate
   @Temporal(TemporalType.TIMESTAMP)
   protected LocalDateTime deleted_at;
}
