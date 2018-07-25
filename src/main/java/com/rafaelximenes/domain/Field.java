package com.rafaelximenes.domain;

import java.io.Serializable;

import com.rafaelximenes.enumeration.FieldTypeEnum;

public class Field implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String fieldType;
	
	private Boolean primaryKey;
	
	private Boolean foreinKey;
	
	public Field() {
		
	}
	
	public Field(String name, FieldTypeEnum fieldType) {
		this.name = name;
		this.fieldType = fieldType.getDescription();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public Boolean getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Boolean getForeinKey() {
		return foreinKey;
	}

	public void setForeinKey(Boolean foreinKey) {
		this.foreinKey = foreinKey;
	}
	
	
	
	
	

}
