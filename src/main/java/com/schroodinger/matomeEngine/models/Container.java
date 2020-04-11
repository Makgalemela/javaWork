package com.schroodinger.matomeEngine.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Container")
public class Container  extends auditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long id;


    public Container(@NotBlank String containerName, Container parentContainer, Set<Container> subContainer, Makgalemela makgalemela) {
        this.containerName = containerName;
        this.parentContainer = parentContainer;
        this.subContainer = subContainer;
        this.makgalemela = makgalemela;
    }

    @NotBlank
    private String containerName;

//    @NotBlank
//    private Long parentContainerId;

    public Makgalemela getMakgalemela() {
        return makgalemela;
    }

    public void setMakgalemela(Makgalemela makgalemela) {
        this.makgalemela = makgalemela;
    }

    public Container() {
    }

    public Container(@NotBlank String containerName, Container parentContainer, Set<Container> subContainer) {
        this.containerName = containerName;
//        this.parentContainerId = parentContainerId;
        this.parentContainer = parentContainer;
        this.subContainer = subContainer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

//    public Long getParentContainerId() {
//        return parentContainerId;
//    }
//
//    public void setParentContainerId(Long parentContainerId) {
//        this.parentContainerId = parentContainerId;
//    }

    public Container getParentContainer() {
        return parentContainer;
    }

    public void setParentContainer(Container parentContainer) {
        this.parentContainer = parentContainer;
    }

    public Set<Container> getSubContainer() {
        return subContainer;
    }

    public void setSubContainer(Set<Container> subContainer) {
        this.subContainer = subContainer;
    }

//    @ManyToOne(cascade={CascadeType.ALL})
@ManyToOne(fetch = FetchType.LAZY, optional = false)

@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @JoinColumn(name="parent_containerId")
    private Container parentContainer;

//
@OneToMany(mappedBy="parentContainer")
    private Set<Container> subContainer = new HashSet<Container>();


    //  @JoinColumn(name = "user_id", nullable = false)
//     @JoinTable(name = "userRes", joinColumns = { @JoinColumn(name = "user_id") },
//            inverseJoinColumns = { @JoinColumn(name = "userAddress_id") })
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private  Makgalemela makgalemela;

}
