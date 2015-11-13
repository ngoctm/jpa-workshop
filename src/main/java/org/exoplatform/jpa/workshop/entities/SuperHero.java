package org.exoplatform.jpa.workshop.entities;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "SUPERHERO")
public class SuperHero {

  @Id
  @GeneratedValue
  @Column(name = "SUPERHERO_ID")
  private long id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "CIVIL_NAME")
  private String civilName;

  @Column(name = "PICTURE")
  private byte[] picture;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCivilName() {
    return civilName;
  }

  public void setCivilName(String civilName) {
    this.civilName = civilName;
  }

  public byte[] getPicture() {
    return picture;
  }

  public void setPicture(byte[] picture) {
    this.picture = picture;
  }
}