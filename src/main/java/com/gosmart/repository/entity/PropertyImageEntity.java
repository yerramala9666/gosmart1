package com.gosmart.repository.entity;



import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/* *
  ^<h2>PropertyImageEntity</h2>
  * ThisEntityClassMaps to Property_Iamge_Entity
  * 
  * @author yerramala
  * version 1.0
  * since 2022-12-17
  */
@Entity
@Data
@Table(name="PROPERTY_IMAGE_ENTITY")
public class PropertyImageEntity {
	//primary key
	
	@Id
	//this is propertyImageId
	@Column(name="PROPERTY_IMAGE_ID")
	private Integer propertyImageId;
	//this is propertyId
	@Column(name="PROPERTY_ID")
	private Integer propertyId;
	//this is propertyImageName
	@Column(name="PROPERTY_IMAGE_NAME")
	private String propertyImageName;
	//this is propertyImageCreatedBy
	@Column(name="PROPERTY_IMAGE_CREATED_BY")
	private Integer propertyImageCreatedBy;
	//this is propertyImageUpdatedBy
	@Column(name="PROPERTY_IMAGE_UPDATED_BY")
	private Integer propertyImageUpdatedBy;
	//this is propertyImageCreatedOn
	@Column(name="PROPERTY_CREATED_ON")
	private Date propertyCreatedOn;
	//this is propertyImageUpdatedOn
	@Column(name="PROPERTY_UPDATED_ON")
	private Date propertyUpdatedOn;
}
