package com.schroodinger.schroodinger.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class )
@JsonIgnoreProperties(value = {"createdAt", "updateAt"}, allowGetters = true)

public class user implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Long id;


  @NotBlank
  private String username;


  @NotBlank
  private String last_name;

  @NotBlank
  private String first_name;


  @NotBlank
  private String email_add;

  @Column(name = "created_on",nullable = false , updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createAt;


  @Column(name="updated_on",nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private  Date updatedAt;


  public user() {
  }

  public user(long id , String username , String last_name ,  String first_name
      , String email_add , Date createdAt , Date updatedAt){
    this.id = id;
    this.username = username;
    this.last_name = last_name;
    this.email_add = email_add;
    this.createAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getEmail_add() {
    return email_add;
  }

  public void setEmail_add(String email_add) {
    this.email_add = email_add;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }



}
