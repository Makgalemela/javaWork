package com.schroodinger.matomeEngine.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "treeview")
public class TreeView  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long id;

    private String text;
    private String type;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TreeView getParent() {
        return parent;
    }

    public void setParent(TreeView parent) {
        this.parent = parent;
    }

    public Set<TreeView> getChildren() {
        return children;
    }

    public void setChildren(Set<TreeView> children) {
        this.children = children;
    }

    public TreeView() {
    }

    public TreeView(String text, String type) {
        this.text = text;
        this.type = type;
    }

    //    @ManyToOne(cascade={CascadeType.ALL})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @JoinColumn(name="parent_id")
    private TreeView parent;

    @OneToMany(mappedBy="parent")
//    @JsonIgnore
    private Set<TreeView> children = new HashSet<TreeView>();

}
