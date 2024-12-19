package org.eduardomaravill.data_analyze.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperService {

    private final ModelMapper modelMapper;

    @Autowired
    public ModelMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
