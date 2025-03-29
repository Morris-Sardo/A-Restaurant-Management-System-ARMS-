package backend;

/**
 * This exception is thrown whenever a query returns unexpected information.
 * 
 * @author xaviernoel
 */
public class DatabaseInformationException extends Exception {
  private static final long serialVersionUID = 1L;

  /**
   * Error Message.
   */
  String message;

  DatabaseInformationException(String exception) {
    this.message = exception;
  }

  /**
   * this returns the message as a String.
   */
  public String getMessage() {
    return message;
  }
}


