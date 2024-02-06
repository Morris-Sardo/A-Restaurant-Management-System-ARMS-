package appication;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataBaseModelTest {

  private DataBaseModel model;

  private Connection connect; // connection to database table.
  private PreparedStatement prepare; // use to compiled database.
  private ResultSet result; // result database.

  // private Random random;


  @BeforeEach
  void setup() {
    assertDoesNotThrow(() -> connect = DataBaseModel.connectToDatabase());
    model = new DataBaseModel();

  }

  @Test
  void testLogin() {



    assertDoesNotThrow(() -> assertEquals(model.getRightLogin("Morris", "22"), true ));

  }

  @Test
  void testSignUp() {
    
    assertDoesNotThrow(() -> {
      
    
      assertEquals(model.registerUser("Morris", "22", "What is your favorite color?", "red"),
          false);
      
      String key = new Random().toString();
      assertEquals(model.registerUser(key, new Random().toString(),new Random().toString(), new Random().toString()), true);
      
      PreparedStatement st = connect.prepareStatement("DELETE FROM login WHERE \"username\" = '"+key+"';");
      st.execute();
      
      
    });


  }

  @Test
  void testDatabase() throws SQLException {

    String test = "SELECT version();";
    prepare = connect.prepareStatement(test);
    result = prepare.executeQuery();
    if (result.next())
      assertEquals((result.getString("version").split(" ")[0]), "PostgreSQL");
    else
      fail();
    
    

  }



}
