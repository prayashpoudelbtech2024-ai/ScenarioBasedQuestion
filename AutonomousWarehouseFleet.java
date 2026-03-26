abstract class Robot {
    private String batteryId;      
    protected double chargeLevel;   

    Robot(String batteryId, double chargeLevel) {
        this.batteryId = batteryId;
        this.chargeLevel = chargeLevel;
    }
    public String getBatteryId() {
        return batteryId;
    }
    public void reportStatus() {
        System.out.println("Robot ID: " + batteryId + " | Charge Level: " + chargeLevel + "%");
    }
    abstract void performTask();
}
class DroneRobot extends Robot {

    DroneRobot(String batteryId, double chargeLevel) {
        super(batteryId, chargeLevel);
    }

    @Override
    void performTask() {
        System.out.println("\n[DroneRobot Task] ID: " + getBatteryId());

        if (chargeLevel < 15) {
            System.out.println("Low battery! Task cannot be performed.");
            return;
        }
        chargeLevel -= 15;

        if (chargeLevel < 0) {
            chargeLevel = 0;
        }
        System.out.println("Task completed at 2x speed.");
        reportStatus();
    }
}
class GroundRobot extends Robot {

    GroundRobot(String batteryId, double chargeLevel) {
        super(batteryId, chargeLevel);
    }

    @Override
    void performTask() {
        System.out.println("\n[GroundRobot Task] ID: " + getBatteryId());

        System.out.println("Performing surface check... OK");

        if (chargeLevel < 5) {
            System.out.println("Low battery! Task cannot be performed.");
            return;
        }
        chargeLevel -= 5;

        if (chargeLevel < 0) {
            chargeLevel = 0;
        }

        System.out.println("Task completed on ground.");
        reportStatus();
    }
}
public class AutonomousWarehouseFleet {
    public static void main(String[] args) {

        Robot r1 = new DroneRobot("D-1", 20.0);
        Robot r2 = new GroundRobot("G-5", 10.0);
        Robot r3 = new DroneRobot("D-2", 10.0);

        System.out.println("=== Individual Test Cases ===");
        r1.performTask(); 
        r2.performTask(); 
        r3.performTask(); 

        System.out.println("\n=== Fleet Execution ===");
        Robot[] fleet = {
            new DroneRobot("D1", 50),
            new GroundRobot("G1", 50)
        };

        for (Robot r : fleet) {
            r.performTask();  
        }
    }
}