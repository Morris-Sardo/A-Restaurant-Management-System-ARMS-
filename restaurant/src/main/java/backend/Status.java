package backend;

/**
 * This class is used to store the different status of the orders.
 * 
 * @author papap
 *
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
