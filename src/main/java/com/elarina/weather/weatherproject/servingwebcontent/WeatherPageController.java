package com.elarina.weather.weatherproject.servingwebcontent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elarina.weather.weatherproject.jdbc.DataSourceConfig;
import com.elarina.weather.weatherproject.jdbc.JDBCController;
import com.elarina.weather.weatherproject.model.Town;

@Controller
public class WeatherPageController {

	@GetMapping("/weather")
	public String showWeatherPage(Model model) {
		
		JDBCController controller = new JDBCController(DataSourceConfig.getDataSource());
		List<Town> townsList = controller.queryTowns();
		List<String> townNames = new ArrayList<String>();
		for(Town town: townsList){
			townNames.add(town.getName());
		}
		
		model.addAttribute("towns", townNames);
		
		return "weather";
	}
	
	
	

}