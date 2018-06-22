/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.itmech.collegeintegration.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Сущность для таблицы person_contact_information
 *
 * @author Трушенков Дмитрий Сергеевич
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "person_contact_information")
@XmlRootElement
class PersonContactInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "value")
    private String value;

    @Column(name = "deleted")
    private Boolean deleted = false;

    @JsonBackReference("person")
    @JoinColumn(name = "person", referencedColumnName = "id")
    @ManyToOne
    private Person person;

//    @JoinColumn(name = "category", referencedColumnName = "id")
//    @ManyToOne
//    private ContactInformationCategory category;


}
