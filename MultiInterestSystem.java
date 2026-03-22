class Account {
    protected double balance;

    Account(double balance) {
        this.balance = balance;
    }

    double calculateInterest() {
        return balance * 0.02;
    }
}

class SavingsAccount extends Account {

    SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    double calculateInterest() {
        double interest = balance * 0.04;

        if (balance > 50000) {
            interest += 500; 
        }

        return interest;
    }
}

class FixedDeposit extends SavingsAccount {

    FixedDeposit(double balance) {
        super(balance);
    }

    @Override
    double calculateInterest() {
        double interest = super.calculateInterest(); 
        interest += balance * 0.02; 
        return interest;
    }
}

public class MultiInterestSystem {
    public static void main(String[] args) {

        Account acc1 = new SavingsAccount(10000);
        System.out.println("Interest (SavingsAccount - 10000): " + acc1.calculateInterest());

        Account acc2 = new SavingsAccount(60000);
        System.out.println("Interest (SavingsAccount - 60000): " + acc2.calculateInterest());

        Account acc3 = new FixedDeposit(60000);
        System.out.println("Interest (FixedDeposit - 60000): " + acc3.calculateInterest());
    }
}