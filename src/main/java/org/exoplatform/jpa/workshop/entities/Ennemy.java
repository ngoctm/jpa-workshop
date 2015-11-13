package org.exoplatform.jpa.workshop.entities;

import javax.persistence.*;

/**
 *
 */
@Entity
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