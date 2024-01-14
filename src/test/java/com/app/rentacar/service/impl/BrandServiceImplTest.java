package com.app.rentacar.service.impl;

import com.app.rentacar.dto.car.BrandDto;
import com.app.rentacar.entity.car.Brand;
import com.app.rentacar.repository.BrandRepository;
import com.app.rentacar.service.BrandService;
import com.app.rentacar.service.mapper.BrandMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;



public class BrandServiceImplTest {


    private BrandService brandService;
    @Mock
    private BrandRepository brandRepository;
    @Mock
    private BrandMapper brandMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        brandService = new BrandServiceImpl(brandRepository, brandMapper);
    }
    @Test
    public void testSave() {
        BrandDto brandDto = BrandDto.builder()
                .name("scoda")
                .build();

        Brand brandMock = Mockito.mock(Brand.class);
        Mockito.when(brandMapper.dtoToEntity(ArgumentMatchers.any(BrandDto.class))).thenReturn(brandMock);
        Mockito.when(brandRepository.save(brandMock)).thenReturn(brandMock);
        Mockito.when(brandMapper.entityToDto(brandMock)).thenReturn(brandDto);
        BrandDto result = brandService.save(brandDto);
        Assertions.assertEquals(brandDto.getName(), result.getName());
    }
}
