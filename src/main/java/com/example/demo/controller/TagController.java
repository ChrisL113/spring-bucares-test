package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tag")
@AllArgsConstructor
public class TagController {

   private final Environment environment;
   @GetMapping("")
   public ResponseEntity<String> getTag(){
      return new ResponseEntity<>(environment.getProperty("tag"), HttpStatus.OK);
   }

}
