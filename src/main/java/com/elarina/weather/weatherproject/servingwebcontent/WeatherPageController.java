package com.elarina.weather.weatherproject.servingwebcontent;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.elarina.weather.weatherproject.jdbc.DataSourceConfig;
import com.elarina.weather.weatherproject.jdbc.JDBCController;
import com.elarina.weather.weatherproject.model.TableRecord;
import com.elarina.weather.weatherproject.model.Town;

@Controller
public class WeatherPageController {
	
	private JDBCController controller = new JDBCController(DataSourceConfig.getDataSource());	
	
	@GetMapping("/weather")
	public String showWeatherPage(Model model) {
		addTowns(model);
		addDefaultTemperatures(model);
		return "weather";
	}

	private void addTowns(Model model) {
		List<Town> townsList = controller.queryTowns();
		List<String> townNames = new ArrayList<String>();
		for(Town town: townsList){
			townNames.add(town.getName());
		}
		
		model.addAttribute("towns", townNames);	
	}
	
	private void addDefaultTemperatures(Model model) {
		List<TableRecord> tableRecords = controller.queryAllTemperatures();
		model.addAttribute("records", tableRecords);	
	}

}