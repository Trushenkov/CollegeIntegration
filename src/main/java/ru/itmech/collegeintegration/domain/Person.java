
package ru.itmech.collegeintegration.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"addresses", "contactInformations", "docs"})
@Table(name = "person")
@XmlRootElement
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "person_fed_id")
    private String personFedId;

    @Column(name = "person_reg_id")
    private String personRegId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "description")
    private String description;

    @Column(name = "gender")
    private String gender;

    @Column(name = "deleted")
    private Boolean deleted = false;


    //------------------------------------------------------------------------------------------------------------------
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @Where(clause = "deleted = false")
    @Fetch(FetchMode.SUBSELECT)
    @BatchSize(size = 200)
    private List<PersonAddress> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @Where(clause = "deleted = false")
    @Fetch(FetchMode.SUBSELECT)
    @BatchSize(size = 200)
    private List<PersonContactInformation> contactInformations = new ArrayList<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @Where(clause = "deleted = false")
    @Fetch(FetchMode.SUBSELECT)
    @BatchSize(size = 200)
    private List<PersonDoc> docs = new ArrayList<>();

    //------------------------------------------------------------------------------------------------------------------


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", personFedId='" + personFedId + '\'' +
                ", personRegId='" + personRegId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +
                ", description='" + description + '\'' +
                ", gender='" + gender + '\'' +
                ", deleted=" + deleted +
                ", addresses=" + addresses +
                ", contactInformations=" + contactInformations +
                ", docs=" + docs +
                '}';
    }
}
