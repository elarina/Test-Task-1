package com.elarina.weather.weatherproject.model;

public class Town {
	private String name;
	private int code;
	
	public Town(String name, int code) {
		this.name = name;
		this.code = code;	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	@Override
	  public String toString() {
	    return String.format(
	        "Town[code=%d, name='%s']",
	        code, name);
	  }

}
