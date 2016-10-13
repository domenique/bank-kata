package be.socrates;

import be.socrates.domain.Account;
import be.socrates.domain.AccountTest;
import be.socrates.domain.Bank;
import be.socrates.domain.Money;
import be.socrates.domain.TransactionNotAllowedException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TransferTest extends AccountTest {

  private Bank theBank;

  @Before
  public void setUp() {
    theBank = new Bank();
  }

  @Test
  public void canTranferBetweenAccounts() {
    Account fromAccount = theBank.subscribe(100.00);
    Account toAccount = theBank.subscribe(10.00);

    theBank.transfer(fromAccount, toAccount, Money.of(50.00));

    assertThat(fromAccount, equalTo(accountWith(50.00)));
    assertThat(toAccount, equalTo(accountWith(60.00)));
  }

  @Test(expected = TransactionNotAllowedException.class)
  public void canNotTranferIfNotEnoughMoney() {
    Account fromAccount = theBank.subscribe(10.00);
    Account toAccount = theBank.subscribe(0.00);

    theBank.transfer(fromAccount, toAccount, Money.of(50.00));
  }

  @Test(expected = TransactionNotAllowedException.class)
  public void canNotTransferANegativeAmount() {
    Account fromAccount = theBank.subscribe(10.0);
    Account toAccount = theBank.subscribe(10.0);

    theBank.transfer(fromAccount, toAccount, Money.of(-10.00));
  }
}
