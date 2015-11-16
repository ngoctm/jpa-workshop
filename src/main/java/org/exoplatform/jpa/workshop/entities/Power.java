package org.exoplatform.jpa.workshop.entities;

import org.exoplatform.commons.api.persistence.ExoEntity;

import javax.persistence.*;

/**
 *
 */
@Entity
@ExoEntity
@Table(name = "POWER")
public class Power {

  @Id
  @GeneratedValue
  @Column(name = "POWER_ID")
  private long id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "DESCRIPTION")
  private String description;

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}