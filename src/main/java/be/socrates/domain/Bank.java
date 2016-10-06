package be.socrates.domain;

import java.time.LocalDate;

public class Bank {

  public void transfer(Account fromAccount, Account toAccount, Money amount) {
    LocalDate statementDate = LocalDate.now();

    fromAccount.withdraw(amount, statementDate);
    toAccount.deposit(amount, statementDate);
  }
}
