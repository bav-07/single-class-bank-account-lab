import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount(
                "Bav",
                "Nagarajah",
                LocalDate.of(2000,1,25),
                12345678,
                "Current");
        account.setBalance(0);
    }

    @Test
    public void hasFirstName() {
        assertThat(account.getFirstName()).isEqualTo("Bav");
    }

    @Test
    public void canSetFirstName() {
        account.setFirstName("John");
        assertThat(account.getFirstName()).isEqualTo("John");
    }

    @Test
    public void hasLastName() {
        assertThat(account.getLastName()).isEqualTo("Nagarajah");
    }

    @Test
    public void canSetLastName() {
        account.setLastName("Smith");
        assertThat(account.getLastName()).isEqualTo("Smith");
    }

    @Test
    public void hasDateOfBirth() {
        int actualDayOfMonth = account.getDateOfBirth().getDayOfMonth();
        int actualMonth = account.getDateOfBirth().getMonthValue();
        int actualYear = account.getDateOfBirth().getYear();
        assertThat(actualDayOfMonth).isEqualTo(25);
        assertThat(actualMonth).isEqualTo(1);
        assertThat(actualYear).isEqualTo(2000);
    }

    @Test
    public void canSetDateOfBirth() {
        account.setDateOfBirth(LocalDate.of(1850,5,31));
        int actualDayOfMonth = account.getDateOfBirth().getDayOfMonth();
        int actualMonth = account.getDateOfBirth().getMonthValue();
        int actualYear = account.getDateOfBirth().getYear();
        assertThat(actualDayOfMonth).isEqualTo(31);
        assertThat(actualMonth).isEqualTo(5);
        assertThat(actualYear).isEqualTo(1850);
    }

    @Test
    public void hasAccountNumber() {
        assertThat(account.getAccountNumber()).isEqualTo(12345678);
    }

    @Test
    public void canSetAccountNumber() {
        account.setAccountNumber(87654321);
        assertThat(account.getAccountNumber()).isEqualTo(87654321);
    }

    @Test
    public void hasBalance() {
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void canSetBalance() {
        account.setBalance(1000);
        assertThat(account.getBalance()).isEqualTo(1000);
        // System.out.println(account.getBalance());
        account.setBalance(1560.34);
        assertThat(account.getBalance()).isEqualTo(1560.34);
        // System.out.println(account.getBalance());
        account.setBalance(578423942394.34);
        assertThat(account.getBalance()).isEqualTo(578423942394.34);
    }

    @Test
    public void hasAccountType() {
        assertThat(account.getAccountType()).isEqualTo("Current");
        account.setAccountType("Savings");
        assertThat(account.getAccountType()).isEqualTo("Savings");
    }

    @Test
    public void canSetAccountType() {
        account.setAccountType("Savings");
        assertThat(account.getAccountType()).isEqualTo("Savings");
        account.setAccountType("Current");
        assertThat(account.getAccountType()).isEqualTo("Current");
    }

    @Test
    public void hasOverdraft() {
        assertThat(account.getOverdraft()).isEqualTo(0);
    }

    @Test
    public void setOverdraft() {
        account.setOverdraft(1000);
        assertThat(account.getOverdraft()).isEqualTo(1000);
    }

    @Test
    public void canDepositAmount() {
        assertThat(account.deposit(1000.0000)).isEqualTo("Success. Your account contains £1000.00.");
        assertThat(account.getBalance()).isEqualTo(1000);
        assertThat(account.deposit(240.54)).isEqualTo("Success. Your account contains £1240.54.");
        assertThat(account.getBalance()).isEqualTo(1240.54);
        assertThat(account.deposit(240.36)).isEqualTo("Success. Your account contains £1480.90.");
        assertThat(account.deposit(-245)).isEqualTo("Error: Cannot deposit negative quantities.");
        assertThat(account.deposit(0)).isEqualTo("Error: Please specify an amount to deposit.");
    }

    @Test
    public void canWithdrawAmount() {
        assertThat(account.withdrawal(1000)).isEqualTo("Error: You are trying to withdraw more than your account balance.");
        account.setBalance(5000);
        assertThat(account.withdrawal(1000)).isEqualTo("Success. You have withdrawn £1000.00. Your account contains £4000.00.");
        assertThat(account.withdrawal(1000.53)).isEqualTo("Success. You have withdrawn £1000.53. Your account contains £2999.47.");
        assertThat(account.withdrawal(100.50)).isEqualTo("Success. You have withdrawn £100.50. Your account contains £2898.97.");
        assertThat(account.withdrawal(0)).isEqualTo("Error: Please specify an amount to deposit.");
        assertThat(account.withdrawal(-240)).isEqualTo("Error: Cannot withdraw negative quantities.");
        assertThat(account.withdrawal(240.3283)).isEqualTo("Success. You have withdrawn £240.33. Your account contains £2658.64.");
        assertThat(account.withdrawal(4.2222)).isEqualTo("Success. You have withdrawn £4.22. Your account contains £2654.42.");
    }

    @Test
    public void canPayInterest() {
        account.setBalance(100);
        assertThat(account.payInterest(-2)).isEqualTo("Error: Cannot have a negative interest.");
        assertThat(account.payInterest(1.2)).isEqualTo("Success. Interest of 1.20% incremented onto balance. Your new balance is £101.20");
        account.setBalance(100);
        assertThat(account.payInterest(1)).isEqualTo("Success. Interest of 1.00% incremented onto balance. Your new balance is £101.00");
        account.setBalance(100);
        assertThat(account.payInterest(2.463463)).isEqualTo("Success. Interest of 2.46% incremented onto balance. Your new balance is £102.46");
        account.setBalance(100);
        account.setAccountType("Savings");
        assertThat(account.payInterest(1.2)).isEqualTo("Success. Interest of 2.40% incremented onto balance. Your new balance is £102.40");
        account.setBalance(100);
        assertThat(account.payInterest(3.452562)).isEqualTo("Success. Interest of 6.91% incremented onto balance. Your new balance is £106.91");
    }

}
