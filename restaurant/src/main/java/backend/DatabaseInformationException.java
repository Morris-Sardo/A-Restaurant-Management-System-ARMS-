package backend;



/**
 * This exception is thrown whenever a query returns unexpected information.
 *
 * @author papap
 * @version $Id: Team Project 15.
 */
public class DatabaseInformationException extends Exception {
  private static final long serialVersionUID = 1L;

  /**
   * This is thr string message.
   */
  String message;

  /**
   * Thsi costructor is inizailize the obect.
   * 
   * @param exception is text.
   */
  DatabaseInformationException(String exception) {
    this.message = exception;
  }

  /**
   * <p>
   * Getter for the field <code>message</code>.
   * </p>
   *
   * @return a {@link java.lang.String} object
   */
  public String getMessage() {
    return message;
  }
}

