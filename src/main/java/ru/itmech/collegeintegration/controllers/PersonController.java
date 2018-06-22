package ru.itmech.collegeintegration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmech.collegeintegration.domain.Person;
import ru.itmech.collegeintegration.repositories.PersonRepository;

import java.util.List;

@RestController
public class PersonController {

    private final PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "findbyfio/{lastName} {firstName} {middleName}")
    public List<Person> requestByFullname(@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName, @PathVariable("middleName") String middleName) {
        return repository.findByFullName(lastName.toLowerCase() + " " + firstName.toLowerCase() + " " + middleName.toLowerCase());
    }

    @RequestMapping(value = "findbysnils/{snils}")
    public List<Person> requestBySnils(@PathVariable("snils") String snils) {
        return repository.findBySnils(snils);
    }

}
