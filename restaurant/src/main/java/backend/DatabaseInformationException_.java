package main.java.backend;

public class DatabaseInformationException_ {
//custom  exception class
public class DatabaseInformationException extends Exception {
    public DatabaseInformationException(String message) {
    super(message);
    }
    
public DatabaseInformationException(String message, Throwable cause) {
        super(message, cause);

}
}
}
