package ru.itmech.collegeintegration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itmech.collegeintegration.domain.Person;

import java.util.List;

/**
 * Интерфейс, в котором размещены методы для поиска в базе данных по ФИО и по номеру СНИЛСА
 *
 * @author Трушенков Дмитрий Сергеевич
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

    /**
     * Метод для поиска в базе данных объекта по номеру СНИЛСА
     *
     * @param numeral номер СНИЛСА
     * @return объект из базы данных с указаннм номером СНИЛСА
     */
    @Query("select p from Person as p join p.docs as d where d.numeral = ?1 ")
    List<Person> findBySnils(String numeral);

    /**
     * Метод для поиска в базе данных объекта по полному имени (ФИО)
     *
     * @param fullname полное имя (ФИО)
     * @return  объект из базы данных с указанным ФИО
     */
    @Query("select p from Person as p where lower(p.fullName) like ?1 ")
    List<Person> findByFullName(String fullname);
}
