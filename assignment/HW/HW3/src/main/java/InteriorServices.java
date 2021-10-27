public abstract class InteriorServices extends Services {

    protected Integer numOfPets;

    public InteriorServices(Integer numOfPets,
                            String address,
                            boolean ifMonthly,
                            Integer pervServiceNum,
                            PropertySize propertySize) {
        super(address, ifMonthly, pervServiceNum, propertySize);
        this.numOfPets = numOfPets;
        switch (propertySize) {
            case Small:
                this.hour = 1;
            case Medium:
                this.hour = 2;
            case Large:
                this.hour = 4;
        }

        if (this.numOfPets <= 2) {
            this.baseRate *= 1.05;
        } else if (this.numOfPets > 2){
            this.baseRate *= 1.07;
        }
    }

    @Override
    public double calculatePrice() {
        return this.baseRate * this.hour;
    }

    public Integer getNumOfPets() {
        return numOfPets;
    }
}
