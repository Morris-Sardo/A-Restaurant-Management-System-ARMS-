package backend;

/**
 * A set of values for different possible states of an order.
 * 
 * @author xaviernoel
 */
public enum Status {
  
  /**
   * Requested Status.
   */
  REQUESTED("Requested"),
  
  /**
   * Confirmed Status.
   */
  CONFIRMED("Confirmed"),
  
  /**
   * Ready Status.
   */
  READY("Ready"),
 
  /**
   * Completed Status.
   */
  COMPLETED("Completed"),
  
  /**
   * Paid Status.
   */
  PAID("Paid"),
  
  /**
   * Cancelled Status.
   */
  CANCELED("Canceled");

  /**
   * This is the Status of orders.
   */
  private String status;

  /**
   * Constructor for the status.
   * 
   * @param value to update the status.
   */
  private Status(String value) {
    this.status = value;
  }


  /**
   * This sets the status to string.
   */
  @Override
  public String toString() {
    return status;
  }
}

