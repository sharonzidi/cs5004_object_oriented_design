public class Gardening extends ExteriorServices {
    public Gardening(String address, boolean ifMonthly, Integer pervServiceNum, PropertySize propertySize) {
        super(address, ifMonthly, pervServiceNum, propertySize);
    }

    @Override
    public double calculatePrice() {
        return baseRate * this.hour + 20;
    }
}
