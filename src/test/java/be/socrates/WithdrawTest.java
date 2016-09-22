package be.socrates;

import be.socrates.domain.Account;
import be.socrates.domain.Money;
import be.socrates.domain.TransactionNotAllowedException;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class WithdrawTest extends AccountTest {

  @Test
  public void canWithdrawMoney() {
    Account account = accountWith(100);
    Money money = Money.of(50);

    account.withdraw(money, LocalDate.now());

    assertThat(account)
        .isEqualTo(accountWith(50));
  }

  @Test(expected = TransactionNotAllowedException.class)
  public void canNotWithDrawANegativeAmount() {
    Account account = accountWith(100);
    Money money = Money.of(-10);

    account.withdraw(money, LocalDate.now());
  }

  @Test
  public void canWithdrawTwoAmounts() {
    Account account = accountWith(100);
    Money amount = Money.of(50);

    account.withdraw(amount, LocalDate.now());
    account.withdraw(amount, LocalDate.now());

    assertThat(account)
        .isEqualTo(accountWith(0));

  }
}
