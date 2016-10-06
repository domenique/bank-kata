package be.socrates.domain;

import java.time.LocalDate;

public class Bank {

  public Account subscribe(double initialAmount) {
    return new Account(Money.of(initialAmount), LocalDate.now());
  }

  public Account subscribe() {
    return new Account();
  }

  public void deposit(Account account, Money amount, LocalDate statementDate) {
    account.deposit(amount, statementDate);
  }

  public void withdraw(Account account, Money amount, LocalDate statementDate) {
    account.withdraw(amount, statementDate);
  }

  public void transfer(Account fromAccount, Account toAccount, Money amount) {
    LocalDate statementDate = LocalDate.now();

    fromAccount.withdraw(amount, statementDate);
    toAccount.deposit(amount, statementDate);
  }

  public void printStatements(Account account, StatementPrinter printer) {
    account.printStatements(printer);
  }
}
