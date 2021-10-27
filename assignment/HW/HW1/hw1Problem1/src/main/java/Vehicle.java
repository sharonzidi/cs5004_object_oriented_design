/**
 * Vehicle is a simple object that has a unique Vehicle Identification Number
 (VIN), and corresponding license plate.
 */
public class Vehicle {
    private int VIN;
    private String licensePlate;
    private Owner owner;

    /**
     * Constructor that creates a new vehicle object with the specified VIN and
     * license plate.
     * @param VIN - VIN of the new Vehicle object.
     * @param licensePlate - license plate of the new Vehicle.
     */
    public Vehicle (Integer VIN, String licensePlate, Owner owner) {
        this.VIN = VIN;
        this.licensePlate = licensePlate;
        this.owner = owner;
    }

    /**
     * Returns the VIN of the Vehicle.
     * @return the VIN of the Vehicle.
     */
    public int getVIN() {
        return this.VIN;
    }

    /**
     * Returns the licensePlate of the Vehicle.
     * @return the licensePlate of the Vehicle.
     */
    public String getLicensePlate() {
        return this.licensePlate;
    }

    /**
     * Sets the VIN of the Vehicle.
     * @param VIN
     */
    public void setVIN(Integer VIN) {
        this.VIN = VIN;
    }

    /**
     * Sets the licensePlate of the Vehicle.
     * @param licensePlate
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Returns the first name of the owner.
     * @return the first name of the owner.
     */
    public String getOwnerFirstName() {
        return owner.getFirstName();
    }

    /**
     * Sets the first name of the owner.
     * @param firstName
     */
    public void setOwnerFirstName(String firstName) {
        this.owner.setFirstName(firstName);
    }

    /**
     * Returns the last name of the owner.
     * @return the last name of the owner.
     */
    public String getOwnerLastName() {
        return owner.getLastName();
    }

    /**
     * Returns the last name of the owner.
     * @param lastName
     */
    public void setOwnerLastName(String lastName) {
        this.owner.setLastName(lastName);
    }

    /**
     * Returns the phone number of the owner.
     * @return the phone number of the owner.
     */
    public String getOwnerPhoneNumber() {
        return owner.getPhoneNumber();
    }

    /**
     * Return phone number.
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.owner.setPhoneNumber(phoneNumber);
    }

}

