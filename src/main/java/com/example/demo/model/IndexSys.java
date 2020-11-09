package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class IndexSys implements Persistable<String> {

   @Id
   private String url;

   @Transient
   private boolean update;

   @Override
   public String getId() {
      return this.url;
   }

   @Override
   public boolean isNew() {
      return !this.update;
   }

   @PrePersist
   @PostLoad
   public void markUpdate() {
      this.update = true;
   }
}