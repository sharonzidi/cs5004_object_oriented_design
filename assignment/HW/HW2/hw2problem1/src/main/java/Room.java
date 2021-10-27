/**
 * Room is a simple object that has maximum occupancy, price and number of guest to stay.
 */
public class Room {

    private int maxOccupancy;
    private double price;
    private int numberOfGuest;

    /**
     * Constructor that create a new Room object with maximum occupancy, price and number of guest to stay.
     * @param maxOccupancy
     * @param price
     */
    public Room(int maxOccupancy, double price) {
        this.maxOccupancy = maxOccupancy;
        this.price = price;
        this.numberOfGuest = 0;
    }

    /**
     * Method to check if the room is available.
     * @return true if the room is available. False if the room is not available.
     */
    public boolean isAvailable() {
        return numberOfGuest == 0;
    }

    /**
     * Method bookRoom to set the room's number of guest.
     * @param guest
     * @return true if guest number is valid and the room is available.
     * @return false if guest number is invalid or the room is not available.
     */
    public boolean bookRoom(int guest) {
        if (guest <= 0 || guest > maxOccupancy || !isAvailable()){
            return false;
        }

        numberOfGuest = guest;
        return true;
    }
}
