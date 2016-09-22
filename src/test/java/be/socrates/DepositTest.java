package be.socrates;

import be.socrates.domain.Account;
import be.socrates.domain.Money;
import be.socrates.domain.TransactionNotAllowedException;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


public class DepositTest extends AccountTest {

  @Test(expected = TransactionNotAllowedException.class)
  public void canNotDepositNegativeAmount() {
    Account account = accountWith(100.0);
    Money money = Money.of(-10);

    account.deposit(money, LocalDate.now());
  }

  @Test
  public void canDepositMoney() {
    Account account = new Account(Money.zero(), LocalDate.now());
    Money money = Money.of(100.50);

    account.deposit(money, LocalDate.now());

    assertThat(account).isEqualTo(accountWith(100.50));
  }

  @Test
  public void canDepositMoneyWhenInitialValueIsSet() {
    Account account = accountWith(25.00);
    Money money = Money.of(100.50);

    account.deposit(money, LocalDate.now());

    assertThat(account)
        .isEqualTo(accountWith(125.50));

  }

  @Test
  public void canMakeTwoDeposits() {
    Account account = new Account();
    Money money = Money.of(100.50);
    Money money2 = Money.of(200.50);

    account.deposit(money, LocalDate.now());
    account.deposit(money2, LocalDate.now());

    assertThat(account).isEqualTo(accountWith(301));
  }

}
