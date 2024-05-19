public class Main {
    public static void main(String[] args) {
        int nfloors = 4;
        int noOfSlotsPerFlr = 5;
        ParkingLot parkingLot = new ParkingLot("PR2458", nfloors, noOfSlotsPerFlr);
        parkingLot.parkVechile("Car", "KCH-127", "LimeGreen");
        String ticket = parkingLot.parkVechile("Car", "KCH-134", "Black");
        parkingLot.parkVechile("Car", "KCH-165", "Yellow");
        parkingLot.parkVechile("Car", "KCH-112", "DarkPurple");
        parkingLot.parkVechile("Bike", "KCH-197", "Blue");
        parkingLot.parkVechile("Bike", "KCH-145", "Black");
        parkingLot.parkVechile("Truck", "KCH-138", "DarkGreen");
        parkingLot.parkVechile("Truck", "DHL-129", "White");
        parkingLot.parkVechile("Truck", "BGL-119", "Black");
        parkingLot.displayOccupiedSlots("Car");
        parkingLot.displayOccupiedSlots("Bike");
        parkingLot.displayOccupiedSlots("Truck");
        parkingLot.unPark(ticket);
        parkingLot.displayOccupiedSlots("Car");
        parkingLot.displayOccupiedSlots("Bike");
        parkingLot.displayOccupiedSlots("Truck");

    }
}
