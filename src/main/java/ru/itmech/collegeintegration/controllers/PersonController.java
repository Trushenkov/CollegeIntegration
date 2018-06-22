package ru.itmech.collegeintegration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    /**
     * Метод для обработки get-запроса по адресу localhost:8080/findbyfio/{lastName} {firstName} {middleName}
     *
     * @param lastName Фамилия
     * @param firstName Имя
     * @param middleName Отчество
     * @return найденный из базы данных по ФИО объект класса Person
     */
    @RequestMapping(value = "findbyfio/{lastName} {firstName} {middleName}", method = RequestMethod.GET)
    public List<Person> requestByFullname(@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName, @PathVariable("middleName") String middleName) {
        return repository.findByFullName(lastName.toLowerCase() + " " + firstName.toLowerCase() + " " + middleName.toLowerCase());
    }

    /**
     * Метод для обработки get-запроса по адресу localhost:8080/findbysnils/{snils}
     * @param snils номер снилса
     * @return найденный из базы данных по номеру СНИЛСА объект класса Person
     */
    @RequestMapping(value = "findbysnils/{snils}", method = RequestMethod.GET)
    public List<Person> requestBySnils(@PathVariable("snils") String snils) {
        return repository.findBySnils(snils);
    }

}
