package com.schroodinger.matomeEngine.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "MatomeSite")
public class Site implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    private String siteName;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteDescription() {
        return siteDescription;
    }

    public void setSiteDescription(String siteDescription) {
        this.siteDescription = siteDescription;
    }

    public SiteConfigurations getSiteConfig() {
        return siteConfig;
    }

    public void setSiteConfig(SiteConfigurations siteConfig) {
        this.siteConfig = siteConfig;
    }

    @JsonIgnore
    public Set<Container> getContainer() {
        return container;
    }

    public void setContainer(Set<Container> container) {
        this.container = container;
    }

    public Site(String siteName, String siteDescription, SiteConfigurations siteConfig, Set<Container> container) {
        this.siteName = siteName;
        this.siteDescription = siteDescription;
        this.siteConfig = siteConfig;
        this.container = container;
    }

    public Site() {
    }

    private String siteDescription;


    @OneToOne(mappedBy = "site")
    @JsonIgnore
    private SiteConfigurations siteConfig;


    @OneToMany( mappedBy = "site",fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)

    private Set<Container> container = new HashSet<Container>();

}
