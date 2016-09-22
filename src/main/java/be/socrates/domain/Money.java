package be.socrates.domain;

import java.util.Objects;

public class Money {

  double amount;

  public static Money of(double amount) {
    return new Money(amount);
  }

  public static Money zero() {
    return new Money(0.0);
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

  public Money add(Money money) {
    return new Money(amount + money.amount);
  }

  public boolean isNegative() {
    return amount < 0.0;
  }

  public Money substract(Money money) {
    return new Money(amount - money.amount);
  }

  public Money negate() {
    return new Money(amount * -1);
  }
}
