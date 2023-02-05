package com.app.rentacar.service;

import com.app.rentacar.dto.BrandDto;
import com.app.rentacar.model.Brand;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface BrandService {

    List<BrandDto> getAll(Specification<Brand> spec);

    BrandDto save(BrandDto brandDto);

    BrandDto update(BrandDto brandDto);

    void delete(UUID id);
}
