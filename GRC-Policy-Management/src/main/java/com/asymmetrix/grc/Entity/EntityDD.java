package com.asymmetrix.grc.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PM_ENTITY_DD")
@NoArgsConstructor
@AllArgsConstructor
public class EntityDD {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "PM_ENTITY_ID")
	private String id;

	@Column(name = "PM_ENTITY_NAME")
	private String EntityName;

	@Column(name = "PM_ENTITY_DESC")
	private String EntityDesc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEntityName() {
		return EntityName;
	}

	public void setEntityName(String entityName) {
		EntityName = entityName;
	}

	public String getEntityDesc() {
		return EntityDesc;
	}

	public void setEntityDesc(String entityDesc) {
		EntityDesc = entityDesc;
	}
	
	
	

}
