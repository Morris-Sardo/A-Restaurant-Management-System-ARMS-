package appication;



/**
 * This exception is thrown whenever a query returns unexpected information.
 *
 * @author papap
 * @version $Id: $Id
 */
public class DatabaseInformationException extends Exception {
  private static final long serialVersionUID = 1L;
  String message;

  DatabaseInformationException(String exception) {
    this.message = exception;
  }

  /**
   * <p>Getter for the field <code>message</code>.</p>
   *
   * @return a {@link java.lang.String} object
   */
  public String getMessage() {
    return message;
  }
}


