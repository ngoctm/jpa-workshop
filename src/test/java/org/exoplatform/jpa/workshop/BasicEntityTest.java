package org.exoplatform.jpa.workshop;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.persistence.Query;

import org.junit.Test;
import org.exoplatform.jpa.workshop.entities.SuperHero;
import org.exoplatform.jpa.workshop.entities.Ennemy;
import org.exoplatform.jpa.workshop.entities.Power;
import org.exoplatform.jpa.workshop.entities.ComicsCharacter;

import java.util.Collection;

/**
 * Created by ngoctm on 11/11/15.
 */
public class BasicEntityTest extends JPATest {

  @Test
  public void testMyFirstEntity() {
    // Given
    SuperHero spiderman = new SuperHero();
    spiderman.setName("Spiderman");
    spiderman.setCivilName("Peter Parker");
    spiderman.setPicture("spiderman-picture".getBytes());

    // all operations that change the data must be done in a transaction
    entityManager.getTransaction().begin();
    entityManager.persist(spiderman);
    entityManager.getTransaction().commit();

    // When
    // 1st way to retrieve entity : query
    Query query = entityManager.createQuery("SELECT e FROM SuperHero e");
    Collection<SuperHero> superHeros = (Collection<SuperHero>) query.getResultList();

    // 2nd way to retrieve entity : find
    SuperHero fetchedSpiderman = entityManager.find(SuperHero.class, spiderman.getId());

    // Then
    assertNotNull(superHeros);
    assertEquals(1, superHeros.size());
    SuperHero superHero = superHeros.iterator().next();
    assertEquals("Spiderman", superHero.getName());
    assertEquals("Peter Parker", superHero.getCivilName());
    assertTrue(Arrays.equals("spiderman-picture".getBytes(), superHero.getPicture()));

    assertNotNull(fetchedSpiderman);
    assertEquals("Spiderman", fetchedSpiderman.getName());
    assertEquals("Peter Parker", fetchedSpiderman.getCivilName());
    assertTrue(Arrays.equals("spiderman-picture".getBytes(), fetchedSpiderman.getPicture()));
    assertTrue(fetchedSpiderman instanceof ComicsCharacter);
  }

  @Test
  public void testEnnemies() {
    // Given
    Ennemy sandman = new Ennemy();
    sandman.setName("Sandman");
    sandman.setPicture("sandman-picture".getBytes());

    Ennemy venom = new Ennemy();
    venom.setName("Venom");
    venom.setPicture("venom-picture".getBytes());

    SuperHero spiderman = new SuperHero();
    spiderman.setName("Spiderman");
    spiderman.setCivilName("Peter Parker");
    spiderman.setPicture("spiderman-picture".getBytes());
    List<Ennemy> spidermanEnnemies = new ArrayList<Ennemy>();
    spidermanEnnemies.add(sandman);
    spidermanEnnemies.add(venom);
    spiderman.setEnnemies(spidermanEnnemies);

    entityManager.getTransaction().begin();
    entityManager.persist(spiderman);
    entityManager.getTransaction().commit();

    // When
    SuperHero fetchedSpiderman = entityManager.find(SuperHero.class, spiderman.getId());

    // Then
    assertNotNull(fetchedSpiderman);
    assertEquals("Spiderman", fetchedSpiderman.getName());
    assertEquals("Peter Parker", fetchedSpiderman.getCivilName());
    assertTrue(Arrays.equals("spiderman-picture".getBytes(), fetchedSpiderman.getPicture()));
    assertTrue(fetchedSpiderman instanceof ComicsCharacter);
    List<Ennemy> ennemies = fetchedSpiderman.getEnnemies();
    assertNotNull(ennemies);
    assertEquals(2, ennemies.size());
    assertTrue(ennemies.get(0) instanceof ComicsCharacter);
  }

  @Test
  public void testPowers() {
    // Given
    Power spiderweb = new Power();
    spiderweb.setName("Spider Web");
    spiderweb.setDescription("Shoot spider webs from his wrists");

    Power agility = new Power();
    agility.setName("Agility");
    agility.setDescription("Very agile !");

    SuperHero spiderman = new SuperHero();
    spiderman.setName("Spiderman");
    spiderman.setCivilName("Peter Parker");
    spiderman.setPicture("spiderman-picture".getBytes());
    List<Power> spidermanPowers = new ArrayList<Power>();
    spidermanPowers.add(spiderweb);
    spidermanPowers.add(agility);
    spiderman.setPowers(spidermanPowers);

    entityManager.getTransaction().begin();
    entityManager.persist(spiderman);
    entityManager.getTransaction().commit();

    // When
    SuperHero fetchedSpiderman = entityManager.find(SuperHero.class, spiderman.getId());

    // Then
    assertNotNull(fetchedSpiderman);
    assertEquals("Spiderman", fetchedSpiderman.getName());
    assertEquals("Peter Parker", fetchedSpiderman.getCivilName());
    assertTrue(Arrays.equals("spiderman-picture".getBytes(), fetchedSpiderman.getPicture()));
    assertTrue(fetchedSpiderman instanceof ComicsCharacter);
    List<Power> powers = fetchedSpiderman.getPowers();
    assertNotNull(powers);
    assertEquals(2, powers.size());
  }
}
