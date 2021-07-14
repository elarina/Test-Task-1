package com.elarina.weather.weatherproject.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.elarina.weather.weatherproject.model.TableRecord;
import com.elarina.weather.weatherproject.model.Temperature;
import com.elarina.weather.weatherproject.model.Town;


public class JDBCController {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCController(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}	
	
	public List<Town> queryTowns() {
		List<Town> towns = new ArrayList<Town>();
		
		String sql = "SELECT name, code FROM towns ORDER BY name";
		
		List<Map<String, Object>> records = jdbcTemplate.queryForList(sql);
		
		for(Map<String, Object> record: records) {
			String name = (String)record.get("name");
			int code = (int)record.get("code");
			towns.add(new Town(name, code));
		}
		
		return towns;
	}
	
	public List<TableRecord> queryAllTemperatures() {
		List<TableRecord> tableRecords = new ArrayList<TableRecord>();
		
		String sql = "SELECT date, value, name FROM temperatures  "
		        + "as tm LEFT JOIN towns as tw ON tm.town_code=tw.code "
		        + "ORDER BY date DESC";
				
		List<Map<String, Object>> records = jdbcTemplate.queryForList(sql);
		
		for(Map<String, Object> record: records) {
			Date date = (Date)record.get("date");
			int temperature = (int)record.get("value");
			String townName = (String)record.get("name");
			tableRecords.add(new TableRecord(townName, date, temperature));
		}
	
		return tableRecords;
	}
	
	public List<TableRecord> queryTemperaturesForTown(Town town) {
		List<TableRecord> tableRecords = new ArrayList<TableRecord>();
		
		String sql = "SELECT date, value, name FROM temperatures  "
		        + "as tm LEFT JOIN towns as tw ON tm.town_code=tw.code where name = '" + town.getName() + "'" 
		        + " ORDER BY date DESC";
				
		List<Map<String, Object>> records = jdbcTemplate.queryForList(sql);
		
		for(Map<String, Object> record: records) {
			Date date = (Date)record.get("date");
			int temperature = (int)record.get("value");
			String townName = (String)record.get("name");
			tableRecords.add(new TableRecord(townName, date, temperature));
		}
	
		return tableRecords;
	}
}
