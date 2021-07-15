package com.elarina.weather.weatherproject.servingwebcontent;

import com.elarina.weather.weatherproject.jdbc.DataSourceConfig;
import com.elarina.weather.weatherproject.jdbc.JDBCController;
import com.elarina.weather.weatherproject.model.Town;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TownsPageController {

    private JDBCController controller = new JDBCController(DataSourceConfig.getDataSource());

    @RequestMapping(value = "/towns", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Town> returnTowns(@RequestParam(name="temperature", required=false, defaultValue="20") Integer temperature, Model model) {
        List<Town> towns = controller.getTownsWithAverageTemperatureMoreThan(temperature);
        return towns;
    }

}
