package org.exoplatform.jpa.workshop.entities;

import org.exoplatform.commons.api.persistence.ExoEntity;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 *
 */
@MappedSuperclass
@ExoEntity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ComicsCharacter {

  @Column(name = "NAME")
  private String name;

  @Column(name = "PICTURE")
  private byte[] picture;

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