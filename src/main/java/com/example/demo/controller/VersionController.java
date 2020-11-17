package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/version")
@AllArgsConstructor
public class VersionController {

   private final BuildProperties buildProperties;

   @GetMapping("")
   public ResponseEntity<String> getVersion(){
      return new ResponseEntity<>(buildProperties.getVersion(), HttpStatus.OK);
   }
}







