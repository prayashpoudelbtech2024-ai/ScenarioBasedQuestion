abstract class Transport {
    String trackingID;
    String destination;

    Transport(String trackingID, String destination) {
        this.trackingID = trackingID;
        this.destination = destination;
    }

    abstract void dispatch();
}

interface GPS {
    String getCoordinates();
}

interface Autonomous {
    void selfNavigate();
}

class Truck extends Transport {

    Truck(String trackingID, String destination) {
        super(trackingID, destination);
    }

    @Override
    void dispatch() {
        System.out.println("Truck " + trackingID + " delivering goods to " + destination);
    }
}

class CargoShip extends Transport {

    CargoShip(String trackingID, String destination) {
        super(trackingID, destination);
    }

    @Override
    void dispatch() {
        System.out.println("Cargo Ship " + trackingID + " sailing to " + destination);
    }
}

class DeliveryDrone extends Transport implements GPS, Autonomous {

    DeliveryDrone(String trackingID, String destination) {
        super(trackingID, destination);
    }

    @Override
    void dispatch() {
        System.out.println("Drone " + trackingID + " taking off...");
    }

    @Override
    public String getCoordinates() {
        return "40.7128° N, 74.0060° W";
    }

    @Override
    public void selfNavigate() {
        System.out.println("Drone " + trackingID + " is navigating autonomously.");
    }
}

public class SmartLogisticsSystem {
    public static void main(String[] args) {

        // Using Transport reference
        Transport t = new DeliveryDrone("D101", "New York");
        t.dispatch();

        // Using GPS interface
        GPS g = new DeliveryDrone("D102", "Los Angeles");
        System.out.println("Coordinates: " + g.getCoordinates());

        // Using Autonomous interface
        Autonomous a = new DeliveryDrone("D103", "Chicago");
        a.selfNavigate();
    }
}