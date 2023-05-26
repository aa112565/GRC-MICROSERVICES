package com.asymmetrix.grc.Dto;

public enum ResidualImpactType
{
    VERYLOW, 
    LOW, 
    MEDIUM, 
    HIGH, 
    VERYHIGH;
    
    public String getValue() {
        return this.toString();
    }
}