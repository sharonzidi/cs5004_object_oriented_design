public class WindowCleaning extends ExteriorServices {

    private final int MAX_FLOOR = 3;
    private Integer numOfFloor;

    public WindowCleaning(int numOfFloor,
                          String address,
                          boolean ifMonthly,
                          Integer pervServiceNum,
                          PropertySize propertySize) throws ExceedFloorException {
        super(address, ifMonthly, pervServiceNum, propertySize);
        if (numOfFloor > MAX_FLOOR) {
            throw new ExceedFloorException("Exceed maximum number of floors");
        }

        if (numOfFloor > 1) {
            this.baseRate *= 1.05;
        }

        this.numOfFloor = numOfFloor;
    }


    public Integer getNumOfFloor() {
        return numOfFloor; // The maximum number of floors that the company can work with is 3.
    }
}
