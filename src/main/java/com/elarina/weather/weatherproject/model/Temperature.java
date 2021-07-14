package com.elarina.weather.weatherproject.model;

import java.util.Date;

public class Temperature {
	private int temp;
	private Date date;
	private int townCode;
	
	public Temperature(int temp, Date date, int townCode) {
		this.temp = temp;
		this.date = date;
		this.townCode = townCode;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTownCode() {
		return townCode;
	}

	public void setTownCode(int townCode) {
		this.townCode = townCode;
	}
	
	

}
