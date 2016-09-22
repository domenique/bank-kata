package be.socrates;

import be.socrates.domain.Account;
import be.socrates.domain.Money;
import be.socrates.domain.Statement;
import be.socrates.domain.StatementPrinter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class AccountTest {

  Account accountWith(double amount) {
    return new Account(Money.of(amount), LocalDate.now());
  }

  class MyStatementPrinter implements StatementPrinter {

    List<Statement> statements = new ArrayList<>();

    @Override
    public void printHeader() {

    }

    @Override
    public void print(Statement statement) {
      this.statements.add(statement);
    }

    @Override
    public void printSummary(Money amount) {

    }
  }
}
