package be.socrates;

import be.socrates.domain.Account;
import be.socrates.domain.Bank;
import be.socrates.domain.Money;
import be.socrates.infrastructure.ConsoleStatementPrinter;

import java.time.LocalDate;

public class Main {

  public static void main(String[] args) {
    Bank bank = new Bank();
    Account account = bank.subscribe();

    bank.deposit(account, Money.of(200), LocalDate.now().plusDays(1));

    bank.deposit(account, Money.of(200), LocalDate.now().plusDays(1));
    bank.deposit(account, Money.of(100), LocalDate.now());
    bank.deposit(account, Money.of(1), LocalDate.now().minusDays(1));
    bank.deposit(account, Money.of(50), LocalDate.now().plusDays(2));

    bank.printStatements(account, new ConsoleStatementPrinter());
  }
}
