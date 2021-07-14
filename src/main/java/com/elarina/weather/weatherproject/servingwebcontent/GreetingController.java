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
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, 
			Model model) {
		
		model.addAttribute("name", name);
		
		JDBCController controller = new JDBCController(DataSourceConfig.getDataSource());
		List<Town> townsList = controller.queryTowns();
		List<String> townNames = new ArrayList<String>();
		System.out.println("towns: \n");
		for(Town town: townsList){
			townNames.add(town.getName());
			System.out.println(town + " \n");
		}
		

		
		
		model.addAttribute("towns", townNames);
		
		return "greeting";
	}

}