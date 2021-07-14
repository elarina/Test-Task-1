package com.elarina.weather.weatherproject.model;

import java.util.Date;

public class Temperature {
	int temp;
	Date date;
	
	public Temperature(int temp, Date date) {
		this.temp = temp;
		this.date = date;
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

}
