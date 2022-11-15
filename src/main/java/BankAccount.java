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
        if (depositAmount < 0) {
            return "Error: Cannot deposit negative quantities.";
        }
        else if (depositAmount == 0) {
            return "Error: Please specify an amount to deposit.";
        }
        else {
            this.balance += depositAmount;
            return "Success. Your account contains £" + this.balance + ".";
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
        else {
            if (withdrawalAmount > this.balance) {
                return "Error: You are trying to withdraw more than your account balance.";
            }
            else {
                this.balance -= withdrawalAmount;
                /*
                if (withdrawalAmount % 1 == 0) {
                    withdrawalAmountText = String.valueOf(withdrawalAmount) + "0";
                }
                else if ((double)withdrawalAmount % (double)0.1 == 0){
                    withdrawalAmountText = String.valueOf(withdrawalAmount) + "0";
                    System.out.println(withdrawalAmount);
                }
                else {
                    withdrawalAmountText = String.valueOf(withdrawalAmount);
                }
                 */
                return "Success. You have withdrawn £" + String.format("%.2f", withdrawalAmount) + ". Your account contains £" + String.format("%.2f", this.balance) + ".";
            }
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
