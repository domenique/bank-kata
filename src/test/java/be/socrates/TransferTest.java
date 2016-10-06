package be.socrates;

import be.socrates.domain.Account;
import be.socrates.domain.Bank;
import be.socrates.domain.Money;
import be.socrates.domain.TransactionNotAllowedException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TransferTest extends AccountTest {

  @Test
  public void canTranferBetweenAccounts() {
    Account fromAccount = accountWith(100.00);
    Account toAccount = accountWith(10.00);
    Bank theBank = new Bank();

    theBank.transfer(fromAccount, toAccount, Money.of(50.00));

    assertThat(fromAccount, equalTo(accountWith(50.00)));
    assertThat(toAccount, equalTo(accountWith(60.00)));
  }

  @Test(expected = TransactionNotAllowedException.class)
  public void canNotTranferIfNotEnoughMoney() {
    Account fromAccount = accountWith(10.00);
    Account toAccount = accountWith(0.00);
    Bank theBank = new Bank();

    theBank.transfer(fromAccount, toAccount, Money.of(50.00));
  }

  @Test(expected = TransactionNotAllowedException.class)
  public void canNotTransferANegativeAmount() {
    Account fromAccount = accountWith(10.0);
    Account toAccount = accountWith(10.0);
    Bank theBank = new Bank();

    theBank.transfer(fromAccount, toAccount, Money.of(-10.00));
  }
}
