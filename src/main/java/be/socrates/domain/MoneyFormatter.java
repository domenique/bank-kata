package be.socrates.domain;

public class MoneyFormatter {

  public String format(Money money) {
    return Double.toString(money.amount);
  }
}
