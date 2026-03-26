abstract class Plan {
    private String patientName;
    private double baseFee;

    public Plan(String patientName, double baseFee) {
        this.patientName = patientName;
        this.baseFee = baseFee;
    }
    public String getPatientName() {
        return patientName;
    }
    public double getBaseFee() {
        return baseFee;
    }
    abstract double calculateBill();
}
class SilverPlan extends Plan {

    public SilverPlan(String patientName, double baseFee) {
        super(patientName, baseFee);
    }

    @Override
    double calculateBill() {
        return getBaseFee() + 15; 
    }
}
class GoldPlan extends Plan {

    public GoldPlan(String patientName, double baseFee) {
        super(patientName, baseFee);
    }

    @Override
    double calculateBill() {
        double surcharge = getBaseFee() * 0.10; 
        double discount = 20; 
        return getBaseFee() + surcharge - discount;
    }
}
public class TelemedicineBilling {

    public static void printInvoice(Plan p) {
        System.out.println("Patient Name: " + p.getPatientName());
        System.out.println("Base Fee: $" + p.getBaseFee());
        System.out.println("Final Bill: $" + p.calculateBill());
        System.out.println("---------------------------");
    }
    public static void main(String[] args) {

        Plan p1 = new SilverPlan("John", 100.0);
        printInvoice(p1);

        Plan p2 = new GoldPlan("Sophia", 200.0);
        printInvoice(p2);

        Plan p3 = new GoldPlan("Max", 50.0);
        printInvoice(p3);
    }
}