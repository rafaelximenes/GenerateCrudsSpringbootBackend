package com.rafaelximenes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.rafaelximenes.creator.DomainBuilder;
import com.rafaelximenes.creator.ManagerBuilder;
import com.rafaelximenes.domain.Field;
import com.rafaelximenes.domain.Table;
import com.rafaelximenes.enumeration.FieldTypeEnum;

@ManagedBean
@ViewScoped
public class TableController {
	
	private String nameTableFilter;
	
	private List<Table> tableList = null;
	
	private List<Field> fieldList = null;
	
	private Table tableSelected = new Table();
	
	private Field fieldSelected = new Field();
	
	public TableController() {
		
	}
	
	public void clearFilter() {
		nameTableFilter = null;
	}
	
	public void clearListColumns() {
		fieldList = null;
	}
	
	public void clearFieldSelected() {
		fieldSelected = new Field();
	}
	
	public void addTable() {
		if(tableList == null) 
			tableList = new ArrayList<Table>();
		Table aux = new Table();
		aux.setName(nameTableFilter);
		tableList.add(aux);
		clearFilter();
	}
	
	public void addColumn() {
		if(fieldList == null)
			fieldList = new ArrayList<Field>();
		fieldList.add(new Field(fieldSelected.getName(), fieldSelected.getType()));
		clearFieldSelected();
	}
	
	public void addFieldsToTable() {
		tableSelected.addFieldsInTable(fieldList);
		clearListColumns();
		ManagerBuilder.getInstance().createClass(tableSelected);
	}
	
	public String getNameTableFilter() {
		return nameTableFilter;
	}

	public void setNameTableFilter(String nameTableFilter) {
		this.nameTableFilter = nameTableFilter;
	}

	public List<Table> getTableList() {
		return tableList;
	}

	public void setTableList(List<Table> tableList) {
		this.tableList = tableList;
	}

	public Table getTableSelected() {
		return tableSelected;
	}

	public void setTableSelected(Table tableSelected) {
		this.tableSelected = tableSelected;
	}

	public Field getFieldSelected() {
		return fieldSelected;
	}

	public void setFieldSelected(Field fieldSelected) {
		this.fieldSelected = fieldSelected;
	}
	
	public FieldTypeEnum[] getColumnTypes() {
		return FieldTypeEnum.values();
	}

	public List<Field> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<Field> fieldList) {
		this.fieldList = fieldList;
	}
	
	
}
