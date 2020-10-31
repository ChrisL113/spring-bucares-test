package com.example.demo.test.service;

import com.example.demo.model.IndexSys;
import com.example.demo.dto.IndexSysDto;
import com.example.demo.mapper.IndexSysMapper;
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
   private IndexSys indexSysMock;
   @Mock
   private IndexSysDto indexSysDtoMock;
   @Mock
   private IndexSysRepository indexSysRepositoryMock;
   @Mock
   IndexSysMapper indexSysMapperMock;

   //Captor
   @Captor
   ArgumentCaptor<IndexSys> indexSysSnapshot;
   @Captor
   ArgumentCaptor<String> stringSnapshot;

   @BeforeEach
   void setUp() {
      indexSysService = new IndexSysService(indexSysRepositoryMock,
        indexSysMapperMock);
   }

   @Test
   void createIndexSysExpectedParameters() {
      when(indexSysMock.getUrl()).thenReturn("www.google.com");
      when(indexSysMock.getWord()).thenReturn("dang");
      when(indexSysMapperMock.mapDtoToIndexSys(indexSysDtoMock))
        .thenReturn(indexSysMock);
      //Test Service
      indexSysService.createIndexSys(indexSysDtoMock);

      verify(indexSysRepositoryMock).save(indexSysSnapshot.capture());

      IndexSys indexSysSnapshot = this.indexSysSnapshot.getValue();

      //Assertions
      assertEquals(indexSysSnapshot.getUrl(),
        "www.google.com");
      assertEquals(indexSysSnapshot.getWord(),
        "dang");

   }

   @Test
   void getAllIndexSysExpectedParameters() {
      List<IndexSys> indexSysList = new ArrayList<>();
      for (int i = 0; i < 3; i++) {
         indexSysList.add(new IndexSys("url" + i,
           "word" + i,
           false));
      }
      when(indexSysMapperMock.mapIndexSysToDto(any(IndexSys.class)))
        .thenReturn(new IndexSysDto(indexSysList.get(0).getUrl(),
          indexSysList.get(0).getWord()))
        .thenReturn(new IndexSysDto(indexSysList.get(1).getUrl(),
          indexSysList.get(1).getWord()))
        .thenReturn(new IndexSysDto(indexSysList.get(2).getUrl(),
          indexSysList.get(2).getWord()));

      when(indexSysRepositoryMock.findAll()).thenReturn(indexSysList);

      //Test Service
      List<IndexSysDto> testList = indexSysService.getAllIndexSys();

      for (int i = 0; i < 3; i++) {
         assertEquals(testList.get(i).getUrl(),
           "url" + i);
         assertEquals(testList.get(i).getWord(),
           "word" + i);
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

      assertTrue(indexSysDto.equals(indexSysDto2));
      assertEquals(indexSysDto.getUrl(),"www.google.com");
      assertEquals(indexSysDto.getWord(),"dang");


   }

   @Test
   void indexSysTest() {
      IndexSys indexSys= new IndexSys();
      indexSys.setUrl("www.google.com");
      indexSys.setWord("dang");
      IndexSys indexSys2= new IndexSys();
      indexSys2.setUrl("www.google.com");
      indexSys2.setWord("dang");

      assertTrue(indexSys.equals(indexSys2));
      assertEquals(indexSys.getUrl(),"www.google.com");
      assertEquals(indexSys.getWord(),"dang");

   }

}
