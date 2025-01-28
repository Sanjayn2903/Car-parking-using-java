import java.lang.*;
import java.util.*;

class Car{
     private String carNumber;
     private String carModel;

     public Car(String carNumber, String carModel) {
        this.carNumber = carNumber;
        this.carModel=carModel;
     }
    public  String getCarNumber() {
    return carNumber;
     }
     public String getCarModel(){
        return carModel;
     }
     
    //  @Override
    //  public String toString() {
    //      return "Car{" +
    //              "carNumber='" + carNumber + '\'' +
    //              ", model='" + carModel + '\'' +
    //              '}';
    //  }
    }
 class ParkingSpot{
    private int spotNumber;
    private boolean isOccupied;

    public  ParkingSpot(int spotNumber){
        this.spotNumber = spotNumber;
        this.isOccupied= false;
    }
    public int getSlotNumber(){
        return spotNumber;
    }
    public boolean getIsOccupied(){
        return isOccupied;
    }

    public void parkCar(){
        this.isOccupied=true;
    }
    public void removeCar(){
        this.isOccupied=false;
    }

}

 class ParkingLot{
    private List<ParkingSpot> slots;
    private List<Car> cars;


    public ParkingLot(int numberOfSlots){
        this.slots = new ArrayList<>();
        this.cars = new ArrayList<>();
        for(int i=0;i<numberOfSlots;i++){
        slots.add(new ParkingSpot(i));
    }
    }

    public void parkCar(Car car){
        for(ParkingSpot spot:slots){
            if(!spot.getIsOccupied()){
                spot.parkCar();
                cars.add(car);
                System.out.println("Car " + car.getCarNumber() + " parked at spot " + spot.getSlotNumber());
                return;
            }
        }
        System.out.println("No available spots to park the car.");
    }
    //System.out.println("No available spots to park the car.");
    


public void removeCar(String carNumber) {
    for (int i = 0; i < cars.size(); i++) {
        Car car = cars.get(i);
        if (car.getCarNumber().equals(carNumber)) {
            ParkingSpot spot = slots.get(i);
            spot.removeCar();
            cars.remove(i);
            System.out.println("Car " + carNumber + " removed from spot " + spot.getSlotNumber());
            return;
        }
    }
    System.out.println("Car with number " + carNumber + " is not found.");
}

public void displayStatus() {
    System.out.println("Parking Lot Status:");
    for (ParkingSpot spot : slots) {
        System.out.println("Spot " + spot.getSlotNumber() + " is " + (spot.getIsOccupied() ? "Occupied" : "Available"));
    }
}
 }

public class CarParking {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of parking spots: ");
    int numOfSpots = scanner.nextInt();
    scanner.nextLine();  // Consume newline left-over from nextInt()

    ParkingLot parkingLot = new ParkingLot(numOfSpots);

    while (true) {
        System.out.println("\n--- Car Parking System ---");
        System.out.println("1. Park a car");
        System.out.println("2. Remove a car");
        System.out.println("3. View Parking Lot Status");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter car number: ");
                String carNumber = scanner.nextLine();
                System.out.print("Enter car model: ");
                String model = scanner.nextLine();
                Car car = new Car(carNumber, model);
                parkingLot.parkCar(car);
                break;

            case 2:
                System.out.print("Enter car number to remove: ");
                String removeCarNumber = scanner.nextLine();
                parkingLot.removeCar(removeCarNumber);
                break;

            case 3:
                parkingLot.displayStatus();
                break;

            case 4:
                System.out.println("Exiting...");
                scanner.close();
                return;

            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }
}
}