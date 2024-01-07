package com.app.rentacar.controller;

import com.app.rentacar.constant.ApiConstants;
import com.app.rentacar.dto.ModelDto;
import com.app.rentacar.entity.Model;
import com.app.rentacar.service.ModelService;
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
@RequestMapping(ApiConstants.MODEL)
public class ModelController {

    private final ModelService modelService;

    private final FiltersSpecification<Model> modelFiltersSpecification;

    public ModelController(ModelService modelService, FiltersSpecification<Model> modelFiltersSpecification) {
        this.modelService = modelService;
        this.modelFiltersSpecification = modelFiltersSpecification;
    }

    @GetMapping
    public ResponseEntity<List<ModelDto>> getAllModels(@RequestParam(value = "search" , required = false) String search){
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
            Specification<Model> spec = modelFiltersSpecification.createSpecification(criteria);
            return new ResponseEntity<>(modelService.getAll(spec), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<ModelDto> createModel(@RequestBody ModelDto modelDto){
        try{
            return new ResponseEntity<>(modelService.save(modelDto), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<ModelDto> updateModel(@RequestBody ModelDto modelDto){
        try{
            return new ResponseEntity<>(modelService.update(modelDto), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(ApiConstants.ID)
    public ResponseEntity<Void> deleteModel(@PathVariable("id") UUID id){
        try{
            modelService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
