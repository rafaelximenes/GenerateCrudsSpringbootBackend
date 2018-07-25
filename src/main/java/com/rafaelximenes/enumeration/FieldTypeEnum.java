package com.rafaelximenes.enumeration;



public enum FieldTypeEnum {
	
	INTEGER("Integer"),
	VARCHAR("Varchar"),
	DECIMAL("Number");
	
	private String description;
	
	private FieldTypeEnum(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static FieldTypeEnum toEnum(String description) {
		if (description == null) {
			return null;
		}
		
		for (FieldTypeEnum x : FieldTypeEnum.values()) {
			if(x.getDescription().equals(description)) {
				return x;
			}
		}
		throw new IllegalArgumentException("Description " + description+ " not found.");
	}

}
