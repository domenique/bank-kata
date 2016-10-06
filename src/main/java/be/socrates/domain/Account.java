package be.socrates.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Account {

  private Money amount;
  private Statements statements;

  public Account() {
    this.amount = Money.zero();
    this.statements = new Statements();
  }

  public Account(Money initialAmount, LocalDate statementDate) {
    amount = initialAmount;
    this.statements = new Statements();
    statements.add(new Statement(initialAmount, statementDate));
  }

  public void deposit(Money money, LocalDate statementDate) {
    if (money.isNegative()) {
      throw new TransactionNotAllowedException("You cannot deposit a negative amount");
    }
    statements.add(new Statement(money, statementDate));
    amount = amount.add(money);
  }

  public void withdraw(Money money, LocalDate statementDate) {
    if (money.isNegative() || money.isMoreThan(amount)) {
      throw new TransactionNotAllowedException("You cannot withdraw a negative amount");
    }
    statements.add(new Statement(money.negate(), statementDate));
    amount = amount.substract(money);
  }

  public void printStatements(StatementPrinter printer) {
    statements.print(printer);
    printer.printSummary(amount);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Account account = (Account) o;
    return Objects.equals(amount, account.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }

  @Override
  public String toString() {
    return "Account{" +
        "amount=" + amount +
        '}';
  }
}
