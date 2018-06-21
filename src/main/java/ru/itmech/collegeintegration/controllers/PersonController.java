package ru.itmech.collegeintegration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmech.collegeintegration.domain.Person;
import ru.itmech.collegeintegration.repositories.PersonRepository;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @RequestMapping(value = "find/Трушенков Дмитрий Сергеевич")
    public List<Person> find() {
        return repository.findByFullName("Трушенков % %");
    }

}
