package com.elarina.weather.weatherproject.servingwebcontent;

import com.elarina.weather.weatherproject.jdbc.DataSourceConfig;
import com.elarina.weather.weatherproject.jdbc.JDBCController;
import com.elarina.weather.weatherproject.model.Town;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AveragePageController {
    private JDBCController controller = new JDBCController(DataSourceConfig.getDataSource());
    private Integer temperature;
    private Model model;

    @GetMapping("/averageTemp")
    public String showAverageTemp(@RequestParam(name="townCode", required=false, defaultValue="123456") Integer townCode, Model model) {
        model.addAttribute("townCode", townCode);
        Double averageTemp = controller.getAverageTemperatureForTown(townCode);
        model.addAttribute("averageTemp", averageTemp);
        return "averageTemp";
    }
}
