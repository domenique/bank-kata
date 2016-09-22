package be.socrates.domain;

public class StatementFormatter {

  private static final MoneyFormatter MONEY_FRMT = new MoneyFormatter();

  public String format(Statement statement) {
    if (statement == null) {
      return null;
    }
    return String.format("|| %1$15s | %2$15s ||", MONEY_FRMT.format(statement.amount), statement.date);
  }
}
