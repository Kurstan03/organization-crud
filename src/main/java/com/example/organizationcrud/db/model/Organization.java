package com.example.organizationcrud.db.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organizations")
@Getter
@Setter
@NoArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_gen")
    @SequenceGenerator(name = "organization_gen", sequenceName = "organization_seq", allocationSize = 1)
    private Long id;
    private String ownershipForm;
    private String legalForm;
    private String name;
    private String fullNameOfDirector;
    private String fax;
    private String phoneNumber;
    private String webpage;
    private String login;
    private String licenseNumber;
    private LocalDate dateOfGetLicense;
    private String evidenceNumber;
    private LocalDate dateOfGetEvidence;
    private String address;
    @ElementCollection
    private List<String> files;
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    List<Employee> employees;

    public void addFiles(List<String> files) {
        if (this.files == null) {
            this.files = new ArrayList<>();
        }
        this.files.addAll(files);
    }
}
