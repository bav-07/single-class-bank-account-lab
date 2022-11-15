import java.time.LocalDate;

public class BankAccount {

    // PROPERTIES
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int accountNumber;
    private double balance = 0;

    // CONSTRUCTOR
    public BankAccount(String firstName, String lastName, LocalDate dateOfBirth, int accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.accountNumber  = accountNumber;
    }

    // METHODS
    public String deposit(double depositAmount) {
        if (depositAmount <= 0) {
            return "Error: Cannot deposit negative quantities.";
        }
        else {
            this.balance += depositAmount;
            return "Success. Your account contains £" + this.balance;
        }
    }

    // GETTERS & SETTERS
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }
    public void setDateOfBirth(LocalDate newDateOfBirth) {
        this.dateOfBirth = newDateOfBirth;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }
    public void setAccountNumber(int newAccountNumber) {
        this.accountNumber = newAccountNumber;
    }

    public double getBalance() {
        return this.balance;
    }
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }



}
