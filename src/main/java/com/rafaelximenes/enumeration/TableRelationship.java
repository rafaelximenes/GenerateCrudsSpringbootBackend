package com.rafaelximenes.enumeration;


public enum TableRelationship {
	
	ONE_TO_ONE("One to One"),
	ONE_TO_MANY("One to Many"),
	MANY_TO_ONE("Many to One"),
	MANY_TO_MANY("Many to Many");
	
	private String description;
	
	private TableRelationship(String description) {
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

