package com.example.demo.service;

import com.example.demo.dto.RequestUrlDto;
import com.example.demo.mapper.UrlMapper;
import com.example.demo.model.IndexSys;
import com.example.demo.dto.IndexSysDto;
import com.example.demo.repository.IndexSysRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class IndexSysService {
   private final IndexSysRepository indexSysRepository;
   private final UrlMapper urlMapper;

   @Transactional
   public String createIndexSys(IndexSysDto indexSysDto) {//Crud


      if (!indexSysRepository.existsById(indexSysDto.getUrl())) {
         String word = indexSysDto.getWord().toLowerCase();
         try {
            URL url = new URL(indexSysDto.getUrl());
            try (Scanner s = new Scanner(url.openStream())) {
               while (s.hasNext()) {
                  if (s.next().equalsIgnoreCase(word)) {
                     return "rejected_word";
                  }
               }
               IndexSys indexSys = new IndexSys();
               indexSys.setUrl(indexSysDto.getUrl());
               indexSysRepository.save(indexSys);
               return "accepted";

            }
         } catch (IOException ex) {

            ex.printStackTrace();
         }

      }
      return "rejected_url";
   }

   @Transactional(readOnly = true)
   public List<RequestUrlDto> getAllIndexSys() {
      return indexSysRepository.findAll().stream()
        .map(urlMapper::mapIndexSysToDto).collect(toList());

   }

   public void deleteIndexSys(String url) {
      indexSysRepository.deleteById(url);
   }
}
