package org.exoplatform.jpa.workshop;

import javax.persistence.EntityManager;

import org.exoplatform.commons.persistence.impl.EntityManagerService;
import org.exoplatform.container.StandaloneContainer;

import org.junit.After;
import org.junit.Before;

import org.exoplatform.container.ExoContainerContext;
import java.net.MalformedURLException;

/**
 * Created by ngoctm on 11/13/15.
 */
public class JPATest {
  protected EntityManagerService entityManagerService;
  protected EntityManager entityManager;
  private StandaloneContainer container;

  @Before
  public void setup() {
    // init container
    try {
      container = StandaloneContainer.getInstance();
    }
    catch (Exception e) {
      System.out.println("Exeption: " + e);
    }

    // create entity manager
    entityManagerService = container.getComponentInstanceOfType(EntityManagerService.class);
    entityManagerService.startRequest(container);
    entityManager = entityManagerService.getEntityManager();
  }

  @After
  public void teardown() {
    // close entity manager
    if(entityManagerService != null) {
      entityManagerService.endRequest(container);
    }
    container.stop();
  }
}
