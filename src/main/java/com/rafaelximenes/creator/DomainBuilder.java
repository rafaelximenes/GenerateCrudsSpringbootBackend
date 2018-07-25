package com.rafaelximenes.creator;

import com.rafaelximenes.domain.Field;
import com.rafaelximenes.domain.Table;
import com.rafaelximenes.enumeration.FieldTypeEnum;
import com.rafaelximenes.enumeration.TableRelationship;

public class DomainBuilder {
	
	public static void main(String[] args) {
		Table departament;
		Field f1 = new Field("id", FieldTypeEnum.INTEGER);
		f1.setPrimaryKey(true);
		Field f2 = new Field("name", FieldTypeEnum.VARCHAR);
		
		
		Table employment;
		Field f3 = new Field("id", FieldTypeEnum.INTEGER);
		f1.setPrimaryKey(true);
		Field f4 = new Field("name", FieldTypeEnum.VARCHAR);
		employment = new Table();
		employment.addFieldsInTable(f3,f4);
		departament = new Table(TableRelationship.ONE_TO_MANY, employment);
		departament.addFieldsInTable(f1,f2);
		
	}

}
