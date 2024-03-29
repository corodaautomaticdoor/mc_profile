package com.coroda.repository;

import com.coroda.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("from Person p where p.numberDocument = :numberDocument")
    List<Person> searchNumberDocument (@Param("numberDocument") Long numberDocument);

    @Query("from Person p where p.email = :email")
    List<Person> searchEmail (@Param("email") String email);
}
