package be.socrates.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class AccountTest {

  public Account accountWith(double amount) {
    return new Account(Money.of(amount), LocalDate.now());
  }

  public class MyStatementPrinter implements StatementPrinter {

    public List<Statement> statements = new ArrayList<>();

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
