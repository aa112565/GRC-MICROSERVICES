package com.asymmetrix.grc.dto;

public enum ResidualImpactType {
	
		VERYLOW, LOW, MEDIUM, HIGH, VERYHIGH;
	 
    public String getValue() {
        return this.toString();
    }
}
