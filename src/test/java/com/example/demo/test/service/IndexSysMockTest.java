package com.example.demo.test.service;

import com.example.demo.dto.RequestUrlDto;
import com.example.demo.mapper.UrlMapper;
import com.example.demo.model.IndexSys;
import com.example.demo.dto.IndexSysDto;
import com.example.demo.repository.IndexSysRepository;
import com.example.demo.service.IndexSysService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IndexSysMockTest {

   //Class to be tested
   private IndexSysService indexSysService;
   //Dependencies
   @Mock
   private IndexSysRepository indexSysRepositoryMock;
   @Mock
   UrlMapper urlMapperMock;

   //Captor
   @Captor
   ArgumentCaptor<String> stringSnapshot;

   @BeforeEach
   void setUp() {
      indexSysService = new IndexSysService(indexSysRepositoryMock,
        urlMapperMock);
   }

   @Test
   void getAllIndexSysExpectedParameters() {
      List<IndexSys> indexSysList = new ArrayList<>();
      for (int i = 0; i < 3; i++) {
         indexSysList.add(new IndexSys("url" + i,
           false));
      }
      when(urlMapperMock.mapIndexSysToDto(any(IndexSys.class)))
        .thenReturn(new RequestUrlDto(indexSysList.get(0).getUrl()))
        .thenReturn(new RequestUrlDto(indexSysList.get(1).getUrl()))
        .thenReturn(new RequestUrlDto(indexSysList.get(2).getUrl()));

      when(indexSysRepositoryMock.findAll()).thenReturn(indexSysList);

      //Test Service
      List<RequestUrlDto> testList = indexSysService.getAllIndexSys();

      for (int i = 0; i < 3; i++) {
         assertEquals(testList.get(i).getUrl(),
           "url" + i);

      }
   }

   @Test
   void deleteIndexSysExpectedParameters() {
      //TestService
      indexSysService.deleteIndexSys("www.google.com");

      verify(indexSysRepositoryMock).deleteById(stringSnapshot.capture());
      //Assertions
      assertEquals(stringSnapshot.getValue(),
        "www.google.com");
   }

   @Test
   void dtoTests() {
      IndexSysDto indexSysDto = new IndexSysDto();
      indexSysDto.setUrl("www.google.com");
      indexSysDto.setWord("dang");


      IndexSysDto indexSysDto2 = new IndexSysDto();
      indexSysDto2.setUrl("www.google.com");
      indexSysDto2.setWord("dang");

      assertEquals(indexSysDto2,
        indexSysDto);
      assertEquals(indexSysDto.getUrl(),
        "www.google.com");
      assertEquals(indexSysDto.getWord(),
        "dang");


   }

   @Test
   void indexSysTest() {
      IndexSys indexSys = new IndexSys();
      indexSys.setUrl("www.google.com");
      IndexSys indexSys2 = new IndexSys();
      indexSys2.setUrl("www.google.com");

      assertEquals(indexSys2,
        indexSys);
      assertEquals(indexSys.getUrl(),
        "www.google.com");

   }

}
