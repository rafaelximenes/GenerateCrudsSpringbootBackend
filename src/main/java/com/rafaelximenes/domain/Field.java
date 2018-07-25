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
	
	private FieldTypeEnum type;
	
	private boolean primaryKey;
	
	private boolean foreinKey;
	
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

	public boolean getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	public boolean getForeinKey() {
		return foreinKey;
	}

	public void setForeinKey(boolean foreinKey) {
		this.foreinKey = foreinKey;
	}

	public FieldTypeEnum getType() {
		return type;
	}

	public void setType(FieldTypeEnum type) {
		this.type = type;
	}
	
	
	
	
	

}
