package com.example.demo.mapper;

import com.example.demo.model.IndexSys;
import com.example.demo.dto.IndexSysDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IndexSysMapper {
   IndexSysDto mapIndexSysToDto(IndexSys indexSys);

   @InheritInverseConfiguration
   IndexSys mapDtoToIndexSys(IndexSysDto indexSysDto);
}

