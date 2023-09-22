package com.example.organizationcrud.db.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_gen")
    @SequenceGenerator(name = "employee_gen", sequenceName = "employee_seq", allocationSize = 1)
    private Long id;
    private String email;
    private String homePhoneNumber;
    private String mobilePhoneNumber;
    private String workPhoneNumber;
    private String homeAddress;
    private String webpage;
    private String jobPosition;
    @ElementCollection
    private List<String> bankDetails;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
