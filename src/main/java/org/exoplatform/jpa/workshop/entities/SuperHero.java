package org.exoplatform.jpa.workshop.entities;

import org.exoplatform.commons.api.persistence.ExoEntity;

import javax.persistence.*;
import java.util.List;

/**
 *
 */
@Entity
@ExoEntity
@Table(name = "SUPERHERO")
@NamedQueries({
        @NamedQuery(name = "superhero.findByPower", query = "SELECT s FROM SuperHero s JOIN s.powers p WHERE p.name = :power")
})
public class SuperHero extends ComicsCharacter {

  @Id
  @GeneratedValue
  @Column(name = "SUPERHERO_ID")
  private long id;

  @Column(name = "CIVIL_NAME")
  private String civilName;

  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "SUPERHERO_ID")
  private List<Ennemy> ennemies;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(name = "SUPERHERO_POWER",
          joinColumns = {@JoinColumn(name = "SUPERHERO_ID")},
          inverseJoinColumns = {@JoinColumn(name = "POWER_ID")}
  )
  private List<Power> powers;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCivilName() {
    return civilName;
  }

  public void setCivilName(String civilName) {
    this.civilName = civilName;
  }

  public List<Ennemy> getEnnemies() {
    return ennemies;
  }

  public void setEnnemies(List<Ennemy> ennemies) {
    this.ennemies = ennemies;
  }

  public List<Power> getPowers() {
    return powers;
  }

  public void setPowers(List<Power> powers) {
    this.powers = powers;
  }
}