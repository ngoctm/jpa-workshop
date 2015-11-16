package org.exoplatform.jpa.workshop.entities;

import org.exoplatform.commons.api.persistence.ExoEntity;

import javax.persistence.*;

/**
 *
 */
@Entity
@ExoEntity
@Table(name = "ENNEMY")
public class Ennemy extends ComicsCharacter {

  @Id
  @GeneratedValue
  @Column(name = "ENNEMY_ID")
  private long id;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}