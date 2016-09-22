package be.socrates.domain;

public class TransactionNotAllowedException extends RuntimeException {

  public TransactionNotAllowedException(String message) {
    super(message);
  }
}
