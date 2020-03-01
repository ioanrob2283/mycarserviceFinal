package com.ri.mycarservice.controllers;

import com.ri.mycarservice.component.LoadDatabase;
import com.ri.mycarservice.model.Car;
import com.ri.mycarservice.repository.CarMakeList;
import com.ri.mycarservice.service.MyCarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyCarServiceController {
    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    private MyCarService myCarService;

    // Get the carlist only with make field and id
    @RequestMapping(value = "/carlist", method = RequestMethod.GET)
    public List<CarMakeList> getCarMakeList() {
        logger.info("CarList endpoint called!");
        return myCarService.getCarMakeList();
    }

    // Get car details based on a id
    @RequestMapping(value = "/carlist/{id}", method = RequestMethod.GET)
    public Car getCarDetailsById(@PathVariable(name = "id") String id) {
        logger.info(String.format("CarDetails endpoint called with id: %s", id));
        return myCarService.getCarDetailsById(Long.parseLong(id));
    }

}
