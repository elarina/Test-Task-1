package com.elarina.weather.weatherproject.model;

import java.util.Date;

public class TableRecord {
	private String townName;
	private Date date;
	private int temperature;
	
	public TableRecord(String townName, Date date, int temperature) {
		this.townName = townName;
		this.date = date;
		this.temperature = temperature;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	
	
}
