package backend;

/**
 * A set of values for different possible states of an order.
 */
public enum Status {
   REQUESTED,
   CONFIRMED,
   READY,
   COMPLETED,
   CANCELED
}
