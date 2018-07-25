package com.rafaelximenes.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.rafaelximenes.enumeration.TableRelationship;

public class Table implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Field> fields = new ArrayList<Field>();
	
	private String relationship; //only exists relationship with other tables; otherwise is null;
	
	private Table table;
	
	public Table() {
		
	}
	
	public Table(TableRelationship relationship, Table table) {
		this.relationship = relationship.getDescription();
		this.table = relationship != null ? table : null;  
	}
	
	public void addFieldsInTable(Field field) {
		fields.add(field);
	}
	
	public void addFieldsInTable(Field... field) {
		fields.addAll(Arrays.asList(field));
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
	
	

}
