package com.example.demo.mapper;

import com.example.demo.dto.RequestUrlDto;
import com.example.demo.model.IndexSys;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UrlMapper {
   RequestUrlDto mapIndexSysToDto(IndexSys indexSys);

   @InheritInverseConfiguration
   IndexSys mapDtoToIndexSys(RequestUrlDto requestUrlDto);
}
