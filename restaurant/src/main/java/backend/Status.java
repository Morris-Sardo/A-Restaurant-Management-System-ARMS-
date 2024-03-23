package backend;

/**
 * This is enum used to change the status of an order.
 * 
 * @author papap
 *
 */
public enum Status {
  /**
   * This enum is used when order is requested.
   */
  REQUESTED("Requested"),
  /**
   * This enum is used when order is confirmed.
   */
  CONFIRMED("Confirmed"),
  /**
   * This enum is used when order is ready.
   */
  READY("Ready"),
  /**
   * This enum is used when order is complited.
   */
  COMPLETED("Completed"),
  /**
   * This enum is used when order has been paid.
   */
  PAID("Paid"),
  /**
   * This enum is used when order is cancelled.
   */
  CANCELED("Canceled");


  private String status;

  private Status(String value) {
    this.status = value;
  }

  @Override
  public String toString() {
    return status;
  }
}
