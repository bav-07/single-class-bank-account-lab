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
                12345678);
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
    public void canDepositAmount() {
        assertThat(account.deposit(1000.0000)).isEqualTo("Success. Your account contains £1000.0.");
        assertThat(account.getBalance()).isEqualTo(1000);
        assertThat(account.deposit(240.54)).isEqualTo("Success. Your account contains £1240.54.");
        assertThat(account.getBalance()).isEqualTo(1240.54);
        assertThat(account.deposit(-245)).isEqualTo("Error: Cannot deposit negative quantities.");
        assertThat(account.deposit(0)).isEqualTo("Error: Please specify an amount to deposit.");
    }

    @Test
    public void canWithdrawAmount() {
        assertThat(account.withdrawal(1000)).isEqualTo("Error: You are trying to withdraw more than your account balance.");
        account.setBalance(5000);
        assertThat(account.withdrawal(1000)).isEqualTo("Success. You have withdrawn £1000.00. Your account contains £4000.00.");
        System.out.println(account.withdrawal(1000));
        assertThat(account.withdrawal(1000.53)).isEqualTo("Success. You have withdrawn £1000.53. Your account contains £1999.47.");
        assertThat(account.withdrawal(100.50)).isEqualTo("Success. You have withdrawn £100.50. Your account contains £1898.97.");
    }


}
