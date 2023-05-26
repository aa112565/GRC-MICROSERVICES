package com.asymmetrix.grc.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MostAccessedDTO {
	
	private long count;
	private long count2;	
	private long count3;
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public long getCount2() {
		return count2;
	}
	public void setCount2(long count2) {
		this.count2 = count2;
	}
	public long getCount3() {
		return count3;
	}
	public void setCount3(long count3) {
		this.count3 = count3;
	}
	public MostAccessedDTO(long count, long count2, long count3) {
		super();
		this.count = count;
		this.count2 = count2;
		this.count3 = count3;
	}
	public MostAccessedDTO(String string, int aging) {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	

}
