package com.app.rentacar.controller;

import com.app.rentacar.dto.CarTypeDto;
import com.app.rentacar.model.CarType;
import com.app.rentacar.service.CarTypeService;
import com.app.rentacar.specification.FiltersSpecification;
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
public class CarTypeController {

    private final CarTypeService carTypeService;

    private final FiltersSpecification<CarType> carTypeFiltersSpecification;

    public CarTypeController(CarTypeService carTypeService, FiltersSpecification<CarType> carTypeFiltersSpecification) {
        this.carTypeService = carTypeService;
        this.carTypeFiltersSpecification = carTypeFiltersSpecification;
    }

    @GetMapping("/car-types")
    public ResponseEntity<List<CarTypeDto>> getAllCarTypes(@RequestParam(value = "search" , required = false) String search){
      List<SearchCriteria> criteria = new ArrayList<>();
        try{
            if(search != null){
                Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
                Matcher matcher = pattern.matcher(search + ",");
                while (matcher.find()){
                    criteria.add(new SearchCriteria(matcher.group(1) ,
                            matcher.group(2), matcher.group(3)));
                }
            }

            Specification<CarType> spec = carTypeFiltersSpecification.createSpecification(criteria);
            List<CarTypeDto> carTypeDtos = carTypeService.getAll(spec);
            return new ResponseEntity<>(carTypeDtos, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/car-type")
    public ResponseEntity<CarTypeDto> createCarType(@RequestBody CarTypeDto carTypeDto){
        try{
            carTypeDto = carTypeService.save(carTypeDto);
            return new ResponseEntity<>(carTypeDto, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/car-type")
    public ResponseEntity<CarTypeDto> updateCarType(@RequestBody CarTypeDto carTypeDto){
        try{
            carTypeDto = carTypeService.update(carTypeDto);
            return new ResponseEntity<>(carTypeDto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/car-type/{id}")
    public ResponseEntity<Void> deleteCarType(@PathVariable("id") UUID id){
        try{
            carTypeService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
