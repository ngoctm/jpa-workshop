package org.exoplatform.jpa.workshop.entities;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "ENNEMY")
public class Ennemy {

  @Id
  @GeneratedValue
  @Column(name = "ENNEMY_ID")
  private long id;

  @Column(name = "NAME")
  private String name;

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

  public byte[] getPicture() {
    return picture;
  }

  public void setPicture(byte[] picture) {
    this.picture = picture;
  }
}