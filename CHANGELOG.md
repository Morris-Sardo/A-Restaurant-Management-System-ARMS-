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


#Fixed bug in change password in changwe password form.

the bug was couse in hnadleChangePasswrd() the overridepassword used to get has argument the paramenter from the view but the fielad was alredy cleaned ehen i type forgot password in Login form. to fixed i used a viariable used ot save the username in loging form such the when the system cuold use the variable to match the new password with the user 

#Fixed two bugs in inventory page.
  first bug was coused by handleDelete(). this mathod was unable to handle exception if delete button was pressed without selecting any item. now it will pop a alert txt.
  second bug was coused by  handleUpdate(). this method could handle the update items with same product id. now it wll pop up a alert text.

#Fixed bug in review page interface.
  The bugs was that a text never continued in a new line. 