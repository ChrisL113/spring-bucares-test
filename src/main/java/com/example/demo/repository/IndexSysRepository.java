package com.example.demo.repository;

import com.example.demo.model.IndexSys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexSysRepository extends JpaRepository<IndexSys, String> {

   @Query("select u from IndexSys u where u.word = ?1")
   IndexSys findByWord(String word);

}
