package org.exoplatform.jpa.workshop.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 */
@Entity
public class SuperHero {

  @Id
  @GeneratedValue
  private long id;

  private String name;

  private String civilName;

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