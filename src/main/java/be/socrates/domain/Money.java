package be.socrates.domain;

import java.util.Objects;

public class Money {

  double amount;

  public static Money of(double amount) {
    return new Money(amount);
  }

  static Money zero() {
    return new Money();
  }

  private Money(double amount) {
    this.amount = amount;
  }

  private Money() {
    this.amount = 0.0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Money money = (Money) o;
    return Double.compare(money.amount, amount) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }

  @Override
  public String toString() {
    return "Money{" +
        "amount=" + amount +
        '}';
  }

  Money add(Money money) {
    return new Money(amount + money.amount);
  }

  boolean isNegative() {
    return amount < 0.0;
  }

  Money substract(Money money) {
    return new Money(amount - money.amount);
  }

  Money negate() {
    return new Money(amount * -1);
  }

  boolean isMoreThan(Money amount) {
    return this.amount > amount.amount;
  }
}
