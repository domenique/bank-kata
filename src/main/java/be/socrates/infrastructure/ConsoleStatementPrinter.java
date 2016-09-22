package be.socrates.infrastructure;

import be.socrates.domain.Money;
import be.socrates.domain.MoneyFormatter;
import be.socrates.domain.Statement;
import be.socrates.domain.StatementFormatter;
import be.socrates.domain.StatementPrinter;

public class ConsoleStatementPrinter implements StatementPrinter {

  private static final StatementFormatter FRMT = new StatementFormatter();
  private static final MoneyFormatter MONEY_FRMT = new MoneyFormatter();

  @Override
  public void printHeader() {
    System.out.println(String.format("|| %1$15s | %2$15s ||", "Amount", "Date"));
    System.out.println("---------------------------------------");
  }

  @Override
  public void print(Statement statement) {
    System.out.println(FRMT.format(statement));
  }

  @Override
  public void printSummary(Money amount) {
    System.out.println("Current balance: " + MONEY_FRMT.format(amount));
  }
}
