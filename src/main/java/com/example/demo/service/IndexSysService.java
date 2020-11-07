package com.example.demo.service;

import com.example.demo.model.IndexSys;
import com.example.demo.dto.IndexSysDto;
import com.example.demo.mapper.IndexSysMapper;
import com.example.demo.repository.IndexSysRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class IndexSysService {
   private final IndexSysRepository indexSysRepository;
   private final IndexSysMapper indexSysMapper;

   @Transactional
   public String createIndexSys(IndexSysDto indexSysDto) {//Crud


      if (!indexSysRepository.existsById(indexSysDto.getUrl())) {
         if(indexSysRepository.findByWord(indexSysDto.getWord())== null){
            IndexSys indexSys = indexSysMapper.mapDtoToIndexSys(indexSysDto);
            indexSysRepository.save(indexSys);
            return "accepted";
         }

         return "rejected_word";
      }
      return "rejected_url";
   }

   @Transactional(readOnly = true)
   public List<IndexSysDto> getAllIndexSys() {
      return indexSysRepository.findAll().stream()
        .map(indexSysMapper::mapIndexSysToDto).collect(toList());

   }
   public void deleteIndexSys(String url){
      indexSysRepository.deleteById(url);
   }
}
