package be.socrates;

import be.socrates.domain.Account;
import be.socrates.domain.Bank;
import be.socrates.domain.Money;
import be.socrates.domain.Statement;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class StatementTest extends AccountTest {

  private Bank theBank;

  @Before
  public void setUp() {
    theBank = new Bank();
  }

  @Test
  public void canPrintOneStatements() {
    Account account = theBank.subscribe();
    Money amount = Money.of(100);
    LocalDate statementDate = LocalDate.now();
    account.deposit(amount, statementDate);

    MyStatementPrinter printer = new MyStatementPrinter();
    theBank.printStatements(account, printer);

    assertThat(account)
        .isEqualTo(accountWith(100));
    assertThat(printer.statements)
        .containsExactly(new Statement(amount, statementDate));
  }

  @Test
  public void canPrintTwoStatements() {
    Account account = theBank.subscribe();
    Money amount = Money.of(100);
    LocalDate statementDate = LocalDate.now();
    account.deposit(amount, statementDate);
    account.deposit(amount, statementDate);

    MyStatementPrinter printer = new MyStatementPrinter();
    theBank.printStatements(account, printer);

    assertThat(account)
        .isEqualTo(accountWith(200));
    assertThat(printer.statements)
        .containsExactly(new Statement(amount, statementDate), new Statement(amount, statementDate));
  }
}
