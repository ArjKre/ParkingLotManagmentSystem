import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ParkingLot {
    String parkingLotId;
    // This is a list of all floors
    List<List<Slot>> slots;

    ParkingLot(String parkingLotId, int nfloors, int noOfSlotsPerFlr) {
        this.parkingLotId = parkingLotId;
        slots = new ArrayList<>();
        for (int i = 0; i < nfloors; i++) {
            slots.add(new ArrayList<>());
            // this is a list for each slots in each floor
            List<Slot> floorSlot = slots.get(i);
            floorSlot.add(new Slot("Truck"));
            floorSlot.add(new Slot("Bike"));
            floorSlot.add(new Slot("Bike"));
            for (int j = 3; j < noOfSlotsPerFlr; j++) {
                floorSlot.add(new Slot("Car"));
            }
        }
    }

    private String generateTicketId(int flr, int slno) {
        return parkingLotId + "_" + flr + "_" + slno;
    }

    public String parkVechile(String type, String regNo, String color) {
        Vehicle newVehicle = new Vehicle(type, regNo, color);
        for (int i = 0; i < slots.size(); i++) {
            for (int j = 0; j < slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (slot.type == type && slot.vehicle == null) {
                    slot.vehicle = newVehicle;
                    slot.ticketID = generateTicketId(i + 1, j + 1);
                    return slot.ticketID;
                }
            }
        }
        System.out.println("NO AVALIABLE SPACE FOR YOUR TYPE OF VECHILE, TRY AGAIN LATER");
        return null;
    }

    public void unPark(String ticketId) {
        try {
            String[] extract = ticketId.split("_");
            int flr_idx = Integer.parseInt(extract[1]) - 1;
            int slot_idx = Integer.parseInt(extract[2]) - 1;
            for (int i = 0; i < slots.size(); i++) {
                for (int j = 0; j < slots.get(i).size(); j++) {
                    if (i == flr_idx && j == slot_idx) {
                        Slot slot = slots.get(i).get(j);
                        slot.vehicle = null;
                        slot.ticketID = null;
                        System.out.println("Unparked Vehicle");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Enter a Valid TicketID");
        }
    }

    public int getNoOfOpenSlots(String type) {
        int count = 0;
        for(List<Slot> floor : slots){
            for(Slot slt : floor){
                if (slt.vehicle == null && slt.type.equals(type) ) {
                    count++;
                }
            }
        }
        return count;
    }

    public void displayOpenSlots(String type) {
        for(int i=0;i < slots.size(); i++){
            for(int j=0; j < slots.get(i).size();j++){
                Slot slt = slots.get(i).get(j);
                if (slt.vehicle == null && slt.type.equals(type)) {
                    System.out.println("Floor:"+(i+1)+ " Slot:"+(j+1));
                }
            }
        }
    }

    public void displayOccupiedSlots(String type) {
        for(int i=0;i < slots.size(); i++){
            for(int j=0; j < slots.get(i).size();j++){
                Slot slt = slots.get(i).get(j);
                if (slt.vehicle != null && slt.type.equals(type)) {
                    System.out.println("Floor:"+(i+1) + " Slot:"+(j+1));
                }
            }
        }
    }

}