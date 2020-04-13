package com.schroodinger.matomeEngine.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "MatomeSiteConfigurations")
public class SiteConfigurations implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String configName;
    private String getConfigLabel;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)

    private Site site;


    public SiteConfigurations() {
    }

    public SiteConfigurations(String configName, String getConfigLabel, Site site) {
        this.configName = configName;
        this.getConfigLabel = getConfigLabel;
        this.site = site;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getGetConfigLabel() {
        return getConfigLabel;
    }

    public void setGetConfigLabel(String getConfigLabel) {
        this.getConfigLabel = getConfigLabel;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
