package com.ri.mycarservice.service;

import com.ri.mycarservice.component.LoadDatabase;
import com.ri.mycarservice.exceptions.CarNotFoundOrWrongIdException;
import com.ri.mycarservice.model.Car;
import com.ri.mycarservice.repository.CarMakeList;
import com.ri.mycarservice.repository.CarMakeListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyCarServiceImpl implements MyCarService {
    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    private CarMakeListRepository carMakeListRepository;

    /* Get the car make list + the ids*/
    @Override
    public List<CarMakeList> getCarMakeList() {
        logger.debug("getCarList service implementation was invoked");
        return carMakeListRepository.findBy();
    }

    /* Get the car by id*/
    @Override
    public Car getCarDetailsById(Long id) {
        logger.debug(String.format("getCarDetails service implementation was invoked with id: %s", id.toString()));
        return carMakeListRepository.findById(id)
                    .orElseThrow(()-> new CarNotFoundOrWrongIdException("Could not find car with id: " + id));
    }
}
