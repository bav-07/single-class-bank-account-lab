import java.time.LocalDate;

public class BankAccount {

    // PROPERTIES
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int accountNumber;
    private double balance;
    private String accountType;
    private double overdraft;

    // CONSTRUCTOR
    public BankAccount(String firstName, String lastName, LocalDate dateOfBirth, int accountNumber, String accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.accountNumber  = accountNumber;
        this.accountType = accountType;
        this.balance = 0;
        this.overdraft = 0;
    }

    // METHODS

    // Deposits the specified amount, as long as it is positive and not 0.
    public String deposit(double depositAmount) {
        if (depositAmount < 0) {
            return "Error: Cannot deposit negative quantities.";
        }
        else if (depositAmount == 0) {
            return "Error: Please specify an amount to deposit.";
        }
        else {
            this.balance += depositAmount;
            return "Success. Your account contains £" + String.format("%.2f", this.balance) + ".";
        }
    }

    // Withdraws an amount, as long as it is positive, not 0, and would not cause the account to exceed the overdraft limit
    public String withdrawal(double withdrawalAmount) {
        String withdrawalAmountText;
        if (withdrawalAmount < 0) {
            return "Error: Cannot withdraw negative quantities.";
        }
        else if (withdrawalAmount == 0) {
            return "Error: Please specify an amount to deposit.";
        }
        else {
            if (this.balance - withdrawalAmount < - this.overdraft) {
                return "Error: Your account overdraft does not permit a withdrawal of this amount.";
            }
            else {
                this.balance -= withdrawalAmount;
                return "Success. You have withdrawn £" + String.format("%.2f", withdrawalAmount) + ". Your account contains £" + String.format("%.2f", this.balance) + ".";
            }
        }
    }

    // Pays interest to account (doubling if accountType is "Savings"), unless the interest provided is negative.
    public String payInterest(double interestPercent) {
        if (interestPercent < 0) {
            return "Error: Cannot have a negative interest.";
        }
        // Double the usual interest rate for a savings account
        if (this.accountType == "Savings") {
            interestPercent *= 2;
        }
        this.balance *= 1 + (interestPercent / (double)100);
        return "Success. Interest of " + String.format("%.2f", interestPercent) + "% incremented onto balance. Your new balance is £" + String.format("%.2f", this.balance);
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

    public String getAccountType() {
        return this.accountType;
    }
    public void setAccountType(String newAccountType) {
        this.accountType = newAccountType;
    }

    public double getOverdraft() {
        return this.overdraft;
    }
    public void setOverdraft(double newOverdraft) {
        this.overdraft = newOverdraft;
    }

}
