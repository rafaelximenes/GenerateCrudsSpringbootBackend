package com.rafaelximenes.creator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.rafaelximenes.domain.Field;
import com.rafaelximenes.domain.Table;
import com.rafaelximenes.util.ReadProperties;

public class DomainBuilder {

	private static DomainBuilder builder;

	public static DomainBuilder getInstance() {
		if (builder == null) {
			builder = new DomainBuilder();
			return builder;
		} else
			return builder;
	}

	public void createDomainClass(Table table) {
		String path = ReadProperties.readElement("path");
		path += File.separator+"domain";
		createDir(path);
		
		File file = new File(path + File.separator + table.getName()+".java");
		try {
			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {
				System.out.println("File already exists.");
			}
			// Write Content
			FileWriter writer = new FileWriter(file);
			String text = writePackageAndImports();
			text += writeClass(table);
			writer.write(text);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createDir(String path) {
		new File(path).mkdirs();
		
	}

	private String writeClass(Table table) {
		StringBuilder sb = new StringBuilder();
		sb.append("public class "+ table.getName() +" implements Serializable {");
		sb.append(System.getProperty("line.separator"));
		sb.append("private static final long serialVersionUID = 1L");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		sb.append(writeAttributes(table));
		sb.append(writeConstructors(table));
		sb.append(writeGetsAndSets(table));
		sb.append(System.getProperty("line.separator"));
		sb.append("}");
		sb.append(System.getProperty("line.separator"));
		return sb.toString();
	}
	
	private String writeGetsAndSets(Table table) {
		StringBuilder sb = new StringBuilder();
		for(Field f: table.getFields()) {
			sb.append("public "+fieldTypeToWrapper(f)+ " get"+returnNameAttributeWhithFirstLetterUpperCase(f)+"() {");
			sb.append(System.getProperty("line.separator"));
			sb.append("\treturn "+f.getName()+";");
			sb.append(System.getProperty("line.separator"));
			sb.append("}");
			sb.append(System.getProperty("line.separator"));
			sb.append("public void set"+returnNameAttributeWhithFirstLetterUpperCase(f)+"("+fieldTypeToWrapper(f)+" "+f.getName()+") {");
			sb.append(System.getProperty("line.separator"));
			sb.append("\tthis."+f.getName() +" = "+f.getName()+";");
			sb.append(System.getProperty("line.separator"));
			sb.append("}");
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}

	private String returnNameAttributeWhithFirstLetterUpperCase(Field f) {
		String name = f.getName();
		return name.substring(0, 1).toUpperCase()+name.substring(1);
	}

	private String convertListFieldsWithComma(List<Field> fields) {
		StringBuilder sb = new StringBuilder();
		boolean firstPosition = true;
		for(Field f: fields) {
			if(firstPosition) {
				sb.append(fieldTypeToWrapper(f)+ " " +f.getName());
				firstPosition = false;
			} else
				sb.append(", "+fieldTypeToWrapper(f)+ " " +f.getName());
		}
		return sb.toString();
		
	}
	
	private String attributesConstructors(Table table) {
		StringBuilder sb = new StringBuilder();
		for(Field f: table.getFields()) {
			sb.append("\tthis." +f.getName()+" = "+f.getName()+";");
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
	
	private String writeAttributes(Table table) {
		StringBuilder sb = new StringBuilder();
		for(Field f: table.getFields()) {
			createAnnotations(f);
			sb.append("private "+fieldTypeToWrapper(f) +" "+ f.getName()+";");
			sb.append(System.getProperty("line.separator"));
		}
		sb.append(System.getProperty("line.separator"));
		return sb.toString();
	}

	private String createAnnotations(Field f) {
		StringBuilder sb = new StringBuilder();
		if(f.getName().equalsIgnoreCase("id") && f.getPrimaryKey()) {
			sb.append("@Id");
			sb.append(System.getProperty("line.separator"));
			sb.append("@GeneratedValue(strategy=GenerationType.IDENTITY)");
		}
		return sb.toString();
		
	}

	private String writeConstructors(Table table) {
		StringBuilder sb = new StringBuilder();
		sb.append("@Entity");
		sb.append(System.getProperty("line.separator"));
		sb.append("public "+table.getName()+"() {");
		sb.append(System.getProperty("line.separator"));
		sb.append("}");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		sb.append("public "+table.getName()+"("+convertListFieldsWithComma(table.getFields())+") {");
		sb.append(System.getProperty("line.separator"));
		sb.append(attributesConstructors(table));
		sb.append(System.getProperty("line.separator"));
		sb.append("}");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		return sb.toString();
	}

	private String fieldTypeToWrapper(Field f) {
		return ReadProperties.readElement(f.getFieldType());
	}

	private String writePackageAndImports() {
		StringBuilder sb = new StringBuilder();
		sb.append("package domain;");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		sb.append("import java.io.Serializable;");
		sb.append(System.getProperty("line.separator"));
		sb.append("import javax.persistence.Entity;");
		sb.append(System.getProperty("line.separator"));
		sb.append("import javax.persistence.Id;");
		sb.append(System.getProperty("line.separator"));
		sb.append("import javax.persistence.GenerationType;");		
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		return sb.toString();
	}

}
