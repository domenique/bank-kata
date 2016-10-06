package be.socrates;

import be.socrates.domain.Account;
import be.socrates.domain.Bank;
import be.socrates.domain.Money;
import be.socrates.domain.TransactionNotAllowedException;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class WithdrawTest extends AccountTest {

  private Bank theBank;

  @Before
  public void setUp() {
    theBank = new Bank();
  }

  @Test
  public void canWithdrawMoney() {
    Account account = theBank.subscribe(100);
    Money money = Money.of(50);

    theBank.withdraw(account, money, LocalDate.now());

    assertThat(account)
        .isEqualTo(accountWith(50));
  }

  @Test(expected = TransactionNotAllowedException.class)
  public void canNotWithDrawANegativeAmount() {
    Account account = theBank.subscribe(100);
    Money money = Money.of(-10);

    theBank.withdraw(account,money, LocalDate.now());
  }

  @Test
  public void canWithdrawTwoAmounts() {
    Account account = theBank.subscribe(100);
    Money amount = Money.of(50);

    theBank.withdraw(account, amount, LocalDate.now());
    theBank.withdraw(account, amount, LocalDate.now());

    assertThat(account)
        .isEqualTo(accountWith(0));

  }
}
