package com.asymmetrix.grc.dto;

public class SeriesDataDTO {
	private String name;

	private Long value;

	public SeriesDataDTO() {
		super();
	}

	public SeriesDataDTO(String name, Long value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SeriesDataDTO [name=" + name + ", count=" + value + "]";
	}

}