package com.schroodinger.matomeEngine.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Makgalemela")
public class Makgalemela  extends  auditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long id;

    @NotNull
    private  String name;

    @OneToMany( mappedBy = "makgalemela",fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Set<Container> container = new HashSet<Container>();

    public Makgalemela(@NotNull String name, Set<Container> container) {
        this.name = name;
        this.container = container;
    }

    public Makgalemela() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Container> getContainer() {
        return container;
    }

    public void setContainer(Set<Container> container) {
        this.container = container;
    }
}
