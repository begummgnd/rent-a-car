package com.app.rentacar.controller;

import com.app.rentacar.constant.ApiConstants;
import com.app.rentacar.dto.car.BrandDto;
import com.app.rentacar.entity.car.Brand;
import com.app.rentacar.service.BrandService;
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
@RequestMapping(ApiConstants.BRAND)
public class BrandController {
    private final BrandService brandService;

    private final FiltersSpecification<Brand> brandFiltersSpecification;

    public BrandController(BrandService brandService, FiltersSpecification<Brand> brandFiltersSpecification) {
        this.brandService = brandService;
        this.brandFiltersSpecification = brandFiltersSpecification;
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> getAllBrands(@RequestParam(value = "search", required = false) String search){
        List<SearchCriteria> criteria = new ArrayList<SearchCriteria>();
        try{
            if (search != null) {
                Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
                Matcher matcher = pattern.matcher(search + ",");
                while (matcher.find()) {
                    criteria.add(new SearchCriteria(matcher.group(1),
                            matcher.group(2), matcher.group(3)));
                }
            }
            Specification<Brand> spec = brandFiltersSpecification.createSpecification(criteria);
            return new ResponseEntity<>(brandService.getAll(spec), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<BrandDto> createBrand(@RequestBody BrandDto brandDto){
        try{
            return new ResponseEntity<>(brandService.save(brandDto), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<BrandDto> updateBrand(@RequestBody BrandDto brandDto){
            try{
                return new ResponseEntity<>(brandService.update(brandDto), HttpStatus.OK);

            }catch(Exception e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

    @DeleteMapping(ApiConstants.ID)
    public ResponseEntity<Void> deleteBrand(@PathVariable("id") UUID id){
        try{
            brandService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
