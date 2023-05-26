package com.asymmetrix.grc.dto;

public enum CustomerType {

	LOYAL, NEW, DISSATISFIED;
	 
    public String getValue() {
        return this.toString();
    }
	
}
