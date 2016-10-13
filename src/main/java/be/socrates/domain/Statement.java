package be.socrates.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Statement {

  Money amount;
  LocalDate date;

  public Statement(Money amount, LocalDate date) {
    this.amount = amount;
    this.date = date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Statement statement = (Statement) o;
    return Objects.equals(amount, statement.amount) &&
        Objects.equals(date, statement.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, date);
  }

  void print(StatementPrinter printer) {
    printer.print(this);
  }
}
