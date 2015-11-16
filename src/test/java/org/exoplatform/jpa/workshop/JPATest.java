package org.exoplatform.jpa.workshop;

import javax.persistence.EntityManager;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.exoplatform.commons.persistence.impl.EntityManagerService;
import org.exoplatform.container.StandaloneContainer;

import org.junit.After;
import org.junit.Before;
import org.junit.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ngoctm on 11/13/15.
 */
public class JPATest {
  protected EntityManagerService entityManagerService;
  protected EntityManager entityManager;
  private StandaloneContainer container;

  private Connection conn;
  private Liquibase liquibase;

  @Before
  public void setup() {
    // Init Liquibase
    try {
      Class.forName("org.hsqldb.jdbcDriver");
    } catch (ClassNotFoundException e) {
      System.out.println("Failed to get class org.hsqldb.jdbcDriver: " + e);
    }
    try {
      conn = DriverManager.getConnection("jdbc:hsqldb:mem:db1", "sa", "");
    }
    catch (Exception e) {
      System.out.println("Exception when get connection from Driver manager: " + e);
    }

    try {
      Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(conn));
      liquibase = new Liquibase("db/changelogs/superhero.db.changelog-1.0.0.xml", new ClassLoaderResourceAccessor(), database);
      liquibase.update((String) null);
    }
    catch (Exception e) {
      System.out.println("Cannot create new database: " + e);
    }

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
  public void teardown() throws Exception {
    // close entity manager
    if(entityManagerService != null) {
      entityManagerService.endRequest(container);
    }
    container.stop();

    // Close DB
    liquibase.rollback(1000, null);
    conn.close();
  }
}