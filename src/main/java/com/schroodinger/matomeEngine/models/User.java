package com.schroodinger.matomeEngine.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
@Table(name = "user")
public class User extends auditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Long id;

  public User(@NotBlank String first_name, List<userAddress> _userAddresses) {
    this.first_name = first_name;
    this._userAddresses = _userAddresses;
  }

  @NotBlank
  private String username;


  @NotBlank
  private String last_name;

  @NotBlank
  private String first_name;


  @NotBlank
  private String email_add;

  public void setId(Long id) {
    this.id = id;
  }


//  public void set_userAddresses(userAddress _userAddresses) {
//    this._userAddresses = _userAddresses;
//  }

  @OneToMany(fetch = FetchType.LAZY,
          cascade =  CascadeType.ALL)
@JoinTable(name = "userRes", joinColumns = { @JoinColumn(name = "user_id") },
        inverseJoinColumns = { @JoinColumn(name = "userProfile_id") })
  private List<userAddress> _userAddresses;

  public User() {
  }

  public List<userAddress> get_userAddresses() {
    return _userAddresses;
  }

  public void set_userAddresses(List<userAddress> _userAddresses) {
    this._userAddresses = _userAddresses;
  }

  public User(long id , String username , String last_name , String first_name, String email_add ){

    this.username = username;
    this.last_name = last_name;
    this.email_add = email_add;

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




}
