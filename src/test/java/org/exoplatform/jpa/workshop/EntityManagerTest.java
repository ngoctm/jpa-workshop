package org.exoplatform.jpa.workshop;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by ngoctm on 11/11/15.
 */
public class EntityManagerTest extends JPATest {

  @Test
  public void testEntityManager()  {
    assertNotNull(entityManager);
  }
}
