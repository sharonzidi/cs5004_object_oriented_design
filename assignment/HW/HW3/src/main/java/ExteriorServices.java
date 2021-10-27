public abstract class ExteriorServices extends Services {

    public ExteriorServices(String address, boolean ifMonthly, Integer pervServiceNum, PropertySize propertySize) {
        super(address, ifMonthly, pervServiceNum, propertySize);

        switch (propertySize) {
            case Small:
                this.hour = 1;
            case Medium:
                this.hour = 2;
            case Large:
                this.hour = 4;
        }
    }


    @Override
    public double calculatePrice() {
        return this.hour * this.baseRate;
    }

}
