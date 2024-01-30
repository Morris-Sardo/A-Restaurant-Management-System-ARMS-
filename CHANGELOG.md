This file wil be use to comunicate what each group have change.

New configuration required to the app.

Add dependency in pom.xml 

<!--dipendencies for fontaesome -->
			<dependency>
    			<groupId>de.jensd</groupId>
    			<artifactId>fontawesomefx</artifactId>
    			<version>8.2</version>
			</dependency>
<!--dipendencies for fontaesome -->


<!--this method has been fixed. Deleted Primary Key userId and increase form 20 to 100 fields of attribute.-->
<!--WARMING I DO NOT THING THE THIS VERSION WILL WORK FOR BASE CASES.-->
public static void createLoginTable(Connection connection) throws SQLException {
	System.out.println("Creating login table");

    try (PreparedStatement statement = connection.prepareStatement("CREATE TABLE login (\n"
        + "username varchar(100), \n" + "password varchar(100), \n"
        + "question varchar(100)," + "answer varchar(100)," + "date DATE);");) {
      statement.execute();
    }
  }