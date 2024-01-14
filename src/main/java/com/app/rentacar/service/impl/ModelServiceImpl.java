package com.app.rentacar.service.impl;

import com.app.rentacar.dto.car.ModelDto;
import com.app.rentacar.entity.car.Model;
import com.app.rentacar.repository.ModelRepository;
import com.app.rentacar.service.ModelService;
import com.app.rentacar.service.mapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    private final ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ModelDto> getAll(Specification<Model> spec) {
        List<Model> models = modelRepository.findAll(spec);
        List<ModelDto> modelDtos = models
                                    .stream()
                                    .map(model -> modelMapper.entityToDto(model))
                                    .collect(Collectors.toList());
        return modelDtos;
    }

    @Override
    public ModelDto save(ModelDto modelDto) {
       Model model = modelRepository.save(modelMapper.dtoToEntity(modelDto));
       modelDto = modelMapper.entityToDto(model);
       return modelDto;
    }

    @Override
    public ModelDto update(ModelDto modelDto) {
        Optional<Model> model = modelRepository.findById(modelDto.getId());
        if(!model.isPresent()){
            throw new NullPointerException();
        }
        modelDto = save(modelDto);
        return modelDto;
    }

    @Override
    public void delete(UUID id) {
        Optional<Model> model = modelRepository.findById(id);
        if(!model.isPresent()){
            throw new NullPointerException();
        }
        modelRepository.delete(model.get());
    }
}
