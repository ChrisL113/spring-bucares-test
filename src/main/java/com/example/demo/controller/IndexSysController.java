package com.example.demo.controller;

import com.example.demo.dto.IndexSysDto;
import com.example.demo.dto.RequestUrlDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.service.IndexSysService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@AllArgsConstructor
public class IndexSysController {
   private final IndexSysService indexSysService;

   @PostMapping("/check")
   public ResponseEntity<ResponseDto> createIndexSys(
     @RequestBody IndexSysDto indexSysDto) {

      ResponseDto response = new ResponseDto();

      response.setState(indexSysService.createIndexSys(indexSysDto));


      return new ResponseEntity<>(response,
        HttpStatus.OK);

   }

   @GetMapping("")
   public ResponseEntity<List<RequestUrlDto>> getAllIndexSys() {
      List<RequestUrlDto> authorizedIndexList = indexSysService.getAllIndexSys();
      if (authorizedIndexList.isEmpty())
         return ResponseEntity.status(HttpStatus.NO_CONTENT)
           .body(authorizedIndexList);
      return ResponseEntity.status(HttpStatus.OK).body(authorizedIndexList);
   }

   @DeleteMapping("")
   public ResponseEntity<String> deleteIndex(
     @RequestBody RequestUrlDto requestUrlDto) {

      try {
         indexSysService.deleteIndexSys(requestUrlDto.getUrl());

      } catch (EmptyResultDataAccessException exception) {

         return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
      } catch (Exception exception) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
           .body(null);
      }
      return ResponseEntity.status(HttpStatus.OK).body(null);
   }
}
