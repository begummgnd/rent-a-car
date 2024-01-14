package com.app.rentacar.service;

import com.app.rentacar.dto.car.BrandDto;
import com.app.rentacar.entity.car.Brand;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface BrandService {

    List<BrandDto> getAll(Specification<Brand> spec);

    BrandDto save(BrandDto brandDto);

    BrandDto update(BrandDto brandDto);

    void delete(UUID id);
}
