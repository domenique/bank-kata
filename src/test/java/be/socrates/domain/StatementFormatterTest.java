package be.socrates.domain;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class StatementFormatterTest {

  private StatementFormatter formatter;

  @Before
  public void setUp() {
    formatter = new StatementFormatter();
  }

  @Test
  public void ignoresNull() {
    String response = formatter.format(null);

    assertThat(response).isNullOrEmpty();
  }

  @Test
  public void canPrintAStatement() {
    LocalDate now = LocalDate.of(2000, 1, 1);
    Statement statement = new Statement(Money.of(100), now);

    String response = formatter.format(statement);

    assertThat(response).isEqualTo("||           100.0 |      2000-01-01 ||");
  }

  @Test
  public void canPrintAStatementWithNegativeAmount() {
    LocalDate now = LocalDate.of(2000, 1, 1);
    Statement statement = new Statement(Money.of(-100), now);

    String response = formatter.format(statement);

    assertThat(response).isEqualTo("||          -100.0 |      2000-01-01 ||");
  }
}