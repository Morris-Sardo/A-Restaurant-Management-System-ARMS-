package backend;

/**
 * A set of values for different possible states of an order.
 * 
 * @author xaviernoel
 */
public enum Status {
  REQUESTED("Requested"), CONFIRMED("Confirmed"), READY("Ready"), COMPLETED("Completed"), PAID(
      "Paid"), CANCELED("Canceled");

  private String status;

  private Status(String value) {
    this.status = value;
  }

  @Override
  public String toString() {
    return status;
  }
}

