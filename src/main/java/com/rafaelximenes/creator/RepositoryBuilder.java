package com.rafaelximenes.creator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.rafaelximenes.domain.Table;
import com.rafaelximenes.util.ReadProperties;

public class RepositoryBuilder {

	private static RepositoryBuilder builder;

	public static RepositoryBuilder getInstance() {
		if (builder == null) {
			builder = new RepositoryBuilder();
			return builder;
		} else
			return builder;
	}

	public void createRepository(Table table) {
		String path = ReadProperties.readElement("path");
		path += File.separator+"repository";
		createDir(path);
		
		File file = new File(path + File.separator + table.getName()+"Repository.java");
		try {
			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {
				System.out.println("File already exists.");
			}
			// Write Content
			FileWriter writer = new FileWriter(file);
			String text = "";
			text += writeInterface(table);
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

	private String writeInterface(Table table) {
		StringBuilder sb = new StringBuilder();
		sb.append("@Repository");
		sb.append(System.getProperty("line.separator"));
		sb.append("public interface "+ table.getName() +"Repository extends JpaRepository<"+table.getName()+", Integer> {");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		sb.append("}");
		sb.append(System.getProperty("line.separator"));
		return sb.toString();
	}
	

}
