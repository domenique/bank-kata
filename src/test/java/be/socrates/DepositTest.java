package be.socrates;

import be.socrates.domain.Account;
import be.socrates.domain.Bank;
import be.socrates.domain.Money;
import be.socrates.domain.TransactionNotAllowedException;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


public class DepositTest extends AccountTest {

  private Bank theBank;

  @Before
  public void setUp() {
    theBank = new Bank();
  }

  @Test(expected = TransactionNotAllowedException.class)
  public void canNotDepositNegativeAmount() {
    Account account = theBank.subscribe(100.0);
    Money money = Money.of(-10);

    theBank.deposit(account, money, LocalDate.now());
  }

  @Test
  public void canDepositMoney() {
    Account account = theBank.subscribe(0.0);
    Money money = Money.of(100.50);

    theBank.deposit(account, money, LocalDate.now());

    assertThat(account).isEqualTo(accountWith(100.50));
  }

  @Test
  public void canDepositMoneyWhenInitialValueIsSet() {
    Account account = theBank.subscribe(25.00);
    Money money = Money.of(100.50);

    theBank.deposit(account, money, LocalDate.now());

    assertThat(account)
        .isEqualTo(accountWith(125.50));

  }

  @Test
  public void canMakeTwoDeposits() {
    Account account = theBank.subscribe();
    Money money = Money.of(100.50);
    Money money2 = Money.of(200.50);

    theBank.deposit(account, money, LocalDate.now());
    theBank.deposit(account, money2, LocalDate.now());

    assertThat(account).isEqualTo(accountWith(301));
  }

}
