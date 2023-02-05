package com.app.rentacar.service.impl;

import com.app.rentacar.dto.BrandDto;
import com.app.rentacar.model.Brand;
import com.app.rentacar.repository.BrandRepository;
import com.app.rentacar.service.BrandService;
import com.app.rentacar.service.mapper.BrandMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    private final BrandMapper brandMapper;
    public BrandServiceImpl(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    @Override
    public List<BrandDto> getAll(Specification<Brand> spec){

        List<Brand> brands = brandRepository.findAll(spec);
        List<BrandDto> brandDtos = brands
                                    .stream()
                                    .map(brand -> brandMapper.toDto(brand))
                                    .collect(Collectors.toList());
        return brandDtos;
    }

    @Override
    public BrandDto save(BrandDto brandDto){
        Brand brand = brandRepository.save(brandMapper.toEntity(brandDto));
        brandDto = brandMapper.toDto(brand);
        return brandDto;
    }

    @Override
    public BrandDto update(BrandDto brandDto) {
        Optional<Brand> brand = brandRepository.findById(brandDto.getId());
        if(!brand.isPresent()){
             throw new NullPointerException();
        }
        brandDto = save(brandDto);
        return brandDto;
    }

    @Override
    public void delete(UUID id){

        Optional<Brand> brand = brandRepository.findById(id);
        if(!brand.isPresent()){
            throw new NullPointerException();
        }
        brandRepository.delete(brand.get());
    }

}
