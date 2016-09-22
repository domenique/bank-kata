package be.socrates;

import be.socrates.domain.Account;
import be.socrates.domain.Money;
import be.socrates.infrastructure.ConsoleStatementPrinter;

import java.time.LocalDate;

public class Main {

  public static void main(String[] args) {
    Account account = new Account();

    account.deposit(Money.of(200), LocalDate.now().plusDays(1));
    account.deposit(Money.of(100), LocalDate.now());
    account.deposit(Money.of(1), LocalDate.now().minusDays(1));
    account.withdraw(Money.of(50), LocalDate.now().plusDays(2));

    account.printStatements(new ConsoleStatementPrinter());
  }
}
