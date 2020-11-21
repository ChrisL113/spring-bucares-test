package com.example.demo.controller;

import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/version")

public class VersionController {

   private final BuildProperties buildProperties;

   public VersionController(BuildProperties buildProperties) {
      this.buildProperties = buildProperties;
   }

   @GetMapping("")
   public ResponseEntity<String> getVersion() {
      return new ResponseEntity<>(buildProperties.getVersion(),
        HttpStatus.OK);
   }
}







