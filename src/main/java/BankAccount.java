import java.time.LocalDate;

public class BankAccount {

    // PROPERTIES
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int accountNumber;
    private double balance = 0;
    private String accountType;

    // CONSTRUCTOR
    public BankAccount(String firstName, String lastName, LocalDate dateOfBirth, int accountNumber, String accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.accountNumber  = accountNumber;
        this.accountType = accountType;
    }

    // METHODS
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

    public String withdrawal(double withdrawalAmount) {
        String withdrawalAmountText;
        if (withdrawalAmount < 0) {
            return "Error: Cannot withdraw negative quantities.";
        }
        else if (withdrawalAmount == 0) {
            return "Error: Please specify an amount to deposit.";
        }
        /*
        else if ((float)(withdrawalAmount % 0.01) != 0f) {
            return "Error: Please specify an amount in pounds and pence (to 2 decimal places).";
        }
         */
        else {
            if (withdrawalAmount > this.balance) {
                return "Error: You are trying to withdraw more than your account balance.";
            }
            else {
                this.balance -= withdrawalAmount;
                return "Success. You have withdrawn £" + String.format("%.2f", withdrawalAmount) + ". Your account contains £" + String.format("%.2f", this.balance) + ".";
            }
        }
    }

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

}
