package com.example.nubedianTest.controller;

import com.example.nubedianTest.dto.ProcessorDto;
import com.example.nubedianTest.service.ProcessorService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@AllArgsConstructor
public class ProcessorController {
   private final ProcessorService processorService;

   @PostMapping("/create")
   public HttpStatus createProcessor(
           @RequestBody ProcessorDto processorDto
   ){
      processorService.createProcessor(processorDto);

      return HttpStatus.OK;
   }

   @GetMapping("/getAll")
   public ResponseEntity<List<ProcessorDto>> getAllProcessors() {
      List<ProcessorDto> processorList = processorService.getAllProcessors();
      if (processorList.isEmpty())
         return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
      return ResponseEntity.status(HttpStatus.OK).body(processorList);
   }

   @PutMapping("/update")
   public ResponseEntity<String> editProcessor(
           @RequestBody ProcessorDto processorDto) {
      try {
         processorService.updateProcessor(processorDto);

      } catch (Exception exception) {
         return new ResponseEntity<>("Unexpected error occurred",
                 HttpStatus.INTERNAL_SERVER_ERROR);
      }
      return new ResponseEntity<>("Processor successfully updated!",
              HttpStatus.OK);
   }

   @DeleteMapping("/delete")
   public ResponseEntity<String> deleteIndex(
           @RequestBody ProcessorDto processorDto) {

      try {
         processorService.deleteProcessor(processorDto.getModel());

      } catch (EmptyResultDataAccessException exception) {

         return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
      } catch (Exception exception) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                 .body(null);
      }
      return ResponseEntity.status(HttpStatus.OK).body(null);
   }
}
