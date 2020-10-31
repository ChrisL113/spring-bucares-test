package com.example.demo.test.controller;

import com.example.demo.controller.IndexSysController;
import com.example.demo.dto.IndexSysDto;
import com.example.demo.dto.RequestUrlDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.service.IndexSysService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IndexSysControllerMockTest {

   @InjectMocks
   IndexSysController indexSysControllerMock;
   @Mock
   IndexSysService indexSysServiceMock;
   @Mock
   IndexSysDto indexSysDtoMock;
   @Mock
   ResponseDto responseDtoMock;
   @Mock
   RequestUrlDto requestUrlDtoMock;

   @Captor
   ArgumentCaptor<String> stringSnapshot;

   @BeforeEach
   void setUp() {
      indexSysControllerMock = new IndexSysController(indexSysServiceMock);
   }

   @Test
   void createIndexSysExpectedParameters() {
      when(indexSysServiceMock.createIndexSys(indexSysDtoMock))
        .thenReturn("accepted");
      when(responseDtoMock.getState()).thenReturn("accepted");
      //Test Controller
      indexSysControllerMock.createIndexSys(indexSysDtoMock);

      assertEquals(responseDtoMock.getState(),
        "accepted");

   }

   @Test
   void getAllIndexSysExpectedParametersIsEmpty() {
      List<IndexSysDto> authorizedList = new ArrayList<>();

      //TestController
      indexSysControllerMock.getAllIndexSys();
   }

   @Test
   void deleteIndexExpectedParameters() {
      //TestController
      indexSysControllerMock.deleteIndex(requestUrlDtoMock);

   }

}
