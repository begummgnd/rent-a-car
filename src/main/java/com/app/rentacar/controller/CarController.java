package com.app.rentacar.controller;

import com.app.rentacar.dto.CarDto;
import com.app.rentacar.model.Car;
import com.app.rentacar.service.CarService;
import com.app.rentacar.specification.CarSpecification;
import com.app.rentacar.specification.criteria.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class CarController {

    private final CarService carService;

    private final CarSpecification carSpecification;

    public CarController(CarService carService , CarSpecification carSpecification) {
        this.carService = carService;
        this.carSpecification = carSpecification;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars(@RequestParam(value = "search" , required = false) String search){
        List<SearchCriteria> criteria = new ArrayList<>();
        try{
            if(search != null){
                Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
                Matcher matcher = pattern.matcher(search + ",");
                while (matcher.find()){
                    criteria.add(new SearchCriteria(matcher.group(1),
                            matcher.group(2), matcher.group(3)));
                }
            }
            Specification<Car> spec = carSpecification.createSpecification(criteria);
            List<CarDto> carDtos = carService.getAll(spec);
            return new ResponseEntity<>(carDtos, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/car")
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto carDto){
        try{
            carDto = carService.save(carDto);
            return new ResponseEntity<>(carDto, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/car")
    public ResponseEntity<CarDto> updateCar(@RequestBody CarDto carDto){
        try{
            carDto = carService.update(carDto);
            return new ResponseEntity<>(carDto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<Void> updateCar(@PathVariable UUID id){
        try{
            carService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
