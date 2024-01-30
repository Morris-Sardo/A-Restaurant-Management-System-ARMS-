package backend;

/**
 * This exception is thrown whenever a query returns unexpected information.
 */
public class DatabaseInformationException extends Exception {
  private static final long serialVersionUID = 1L;
  String message;
  
  DatabaseInformationException(String exception) {
    this.message = exception;
  }

  public String getMessage() {
    return message;
  }
}
