/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.itmech.collegeintegration.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "person_doc")
@XmlRootElement
public class PersonDoc implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "series")
    @ColumnTransformer(read = "replace(replace(series, '-', ''), ' ', '')")
    private String series;

    @Column(name = "numeral")
    @ColumnTransformer(read = "replace(replace(numeral, '-', ''), ' ', '')")
    private String numeral;

    @Column(name = "fed_id_code")
    private String fedIdCode;

    @Column(name = "issue_date")
    @Temporal(TemporalType.DATE)
    private Date issueDate;

    @Column(name = "issuer")
    private String issuer;

    @Column(name = "reestr_number")
    private String reestrNumber;

    @Column(name = "expired_date")
    @Temporal(TemporalType.DATE)
    private Date expiredDate;

    @Column(name = "act_date")
    @Temporal(TemporalType.DATE)
    private Date actDate;

    @Column(name = "death_date")
    @Temporal(TemporalType.DATE)
    private Date deathDate;

    @Column(name = "act_number")
    private String actNumber;

    @Column(name = "place")
    private String place;

    @Column(name = "is_inn")
    private Boolean isInn;

    @Column(name = "is_snils")
    private Boolean isSnils;

    @Column(name = "is_identity")
    private Boolean isIdentity;

    @Column(name = "birth_doc")
    private Boolean birthDoc;

    @Column(name = "death_doc")
    private Boolean deathDoc;

    @Column(name = "representative_doc")
    private Boolean representativeDoc;

    @Column(name = "deleted")
    private Boolean deleted = false;


//    @JoinColumn(name = "type_code", referencedColumnName = "id")
//    @ManyToOne
//    private PersonDocType typeCode;

//    @JoinColumn(name = "country", referencedColumnName = "id")
//    @ManyToOne
//    private PersonCountries country;

//    @JoinColumn(name = "citizenship", referencedColumnName = "id")
//    @ManyToOne
//    private PersonCitizenship citizenship;

    @JoinColumn(name = "person", referencedColumnName = "id")
    @ManyToOne
    private Person person;

}
