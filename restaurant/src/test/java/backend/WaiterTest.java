package backend;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;

public class WaiterTest {
  private static Waiter testWaiter = null;

  @BeforeAll
  public static void setUp() throws Exception {
    testWaiter = new Waiter(ConnectionManager.connectToDatabase(), "waiterUsername");
  }

  @AfterAll
  public static void tearDown() throws Exception {
    if (testWaiter != null) {
      testWaiter.getConnection().close();
    }
  }

