package com.example.nubedianTest.mapper;

import com.example.nubedianTest.dto.ProcessorDto;
import com.example.nubedianTest.model.Processor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProcessorMapper {

    ProcessorDto mapProcessorToDto(Processor processor);

    @InheritInverseConfiguration
    Processor mapDtoToProcessor(ProcessorDto processorDto);
}
