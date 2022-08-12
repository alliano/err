package com.web.models.entities.auditing;

import java.text.SimpleDateFormat;
import java.util.Date;

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
public class BaseEntity {
   
   @CreatedDate
   @Temporal(TemporalType.TIMESTAMP)
   protected SimpleDateFormat created_at ;


   @LastModifiedDate
   @Temporal(TemporalType.TIMESTAMP)
   protected Date updated_at;

   @CreatedDate
   @Temporal(TemporalType.TIMESTAMP)
   protected Date deleted_at;
}
