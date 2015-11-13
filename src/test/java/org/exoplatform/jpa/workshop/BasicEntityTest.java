package org.exoplatform.jpa.workshop;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import javax.persistence.Query;

import org.junit.Test;
import org.exoplatform.jpa.workshop.entities.SuperHero;

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
  }
}
