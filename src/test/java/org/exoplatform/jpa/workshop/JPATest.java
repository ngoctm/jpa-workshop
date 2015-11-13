package org.exoplatform.jpa.workshop;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ngoctm on 11/13/15.
 */
public class JPATest {
  protected EntityManagerFactory entityManagerFactory;
  protected EntityManager entityManager;

  @Before
  public void setup() {
    entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
    entityManager = entityManagerFactory.createEntityManager();
  }

  @After
  public void teardown() {
    if(entityManager != null) {
      entityManager.close();
    }
    if(entityManagerFactory != null) {
      entityManagerFactory.close();
    }
  }
}
