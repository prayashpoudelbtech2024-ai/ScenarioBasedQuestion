abstract class Device {
    String brand;

    
    Device(String brand) {
        this.brand = brand;
    }
    abstract void turnOn();
}
interface RemoteControllable{
    void connectToWifi();
}
interface PowerSaving{
    int getEnergyRating();
} 
class SmartTV extends Device implements RemoteControllable, PowerSaving {

    SmartTV(String brand){
        super(brand);
    }

    @Override
    void turnOn(){
        System.out.println(brand + "TV is booting up...");
    }

    @Override
    public void connectToWifi(){
        System.out.println("Connecting to Home 5G...");
    }
    
    @Override
    public int getEnergyRating(){
        return 5;
    }
}
class ElectricKettle extends Device{
    ElectricKettle(String brand){
        super(brand);
    }
    @Override
    void turnOn(){
        System.out.println(brand + " Kettle is heating water...");
    }
}

public class SmartHomeTest{
    public static void main(String[] args){

        
        Device d = new SmartTV("Sony");
        d.turnOn();   

        RemoteControllable r = new SmartTV("LG");
        r.connectToWifi();

        PowerSaving p = new SmartTV("Samsung");
        System.out.println("Energy Rating: " + p.getEnergyRating());

        Device k = new ElectricKettle ("Philips");
        k.turnOn();

    }
}
