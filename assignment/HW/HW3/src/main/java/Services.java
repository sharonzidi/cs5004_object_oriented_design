public abstract class Services implements IServices {

    protected String address;
    protected boolean ifMonthly;
    protected Integer pervServiceNum;
    protected PropertySize propertySize;
    protected Double baseRate;
    protected int hour;

    public Services(String address,
                    boolean ifMonthly,
                    Integer pervServiceNum,
                    PropertySize propertySize) {
        this.address = address;
        this.ifMonthly = ifMonthly;
        this.pervServiceNum = pervServiceNum;
        this.propertySize = propertySize;
        this.baseRate = 80.0; //base rate is 80
        this.hour = 1; // assume 1 hour
    }

    @Override
    public double calculatePrice() {
        if ((this.pervServiceNum + 1) % 10 == 0) {
            return this.baseRate * this.hour * 0.5;
        } else if (ifMonthly) {
            return this.baseRate * this.hour * 0.9;
        }
        
        return baseRate * this.hour;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public boolean ifCarriedMonthly() {
        return ifMonthly;
    }

    @Override
    public Integer getPervServiceNum() {
        return pervServiceNum;
    }

    @Override
    public PropertySize getPropertySize() {
        return propertySize;
    }
}
