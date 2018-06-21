package ru.itmech.collegeintegration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itmech.collegeintegration.domain.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("select p from Person as p join p.docs as d where d.numeral = ?1 ")
    List<Person> findBySnils(String numeral);

    @Query("select p from Person as p where p.fullName like ?1 ")
    List<Person> findByFullName(String fullname);
}
