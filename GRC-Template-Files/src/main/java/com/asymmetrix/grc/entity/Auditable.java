package com.asymmetrix.grc.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class Auditable{

  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "D_CREATED", nullable = false, updatable = false)
  private Date createdDate;

  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "D_LAST_UPDATED", nullable = false)
  private Date modifiedDate;


  public Date getCreatedDate() {
    return createdDate;
  }

  public Date getModifiedDate() {
    return modifiedDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }


}
