abstract class Payment {
    private String transactionId;
    private double amount;


    public Payment(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }


    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    
    public abstract double processPayment();
}

class CreditCardPayment extends Payment {

    public CreditCardPayment(String transactionId, double amount) {
        super(transactionId, amount);
    }

    
    @Override
    public double processPayment() {
        double fee = getAmount() * 0.02;
        return getAmount() + fee;
    }
}


class UPIPayment extends Payment {

    public UPIPayment(String transactionId, double amount) {
        super(transactionId, amount);
    }


    @Override
    public double processPayment() {
        return getAmount();
    }
}

class PaymentProcessor {

    public void process(Payment p) {
        double result = p.processPayment();
        System.out.println("Transaction ID: " + p.getTransactionId());
        System.out.println("Final Amount: " + result);
        System.out.println("----------------------");
    }
}


public class SmartPaymentGateway {
    public static void main(String[] args) {

        
        Payment p1 = new CreditCardPayment("TXN123", 1000.0);
        Payment p2 = new UPIPayment("TXN124", 1000.0);

        PaymentProcessor processor = new PaymentProcessor();

        
        processor.process(p1);
        processor.process(p2);

        
        Payment[] payments = new Payment[2];
        payments[0] = p1;
        payments[1] = p2;

        double total = 0;

        for (Payment p : payments) {
            total += p.processPayment();
        }

        System.out.println("Total Amount: " + total);
    }
}