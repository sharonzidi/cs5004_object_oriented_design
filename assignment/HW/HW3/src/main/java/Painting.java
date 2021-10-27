public class Painting extends InteriorServices {
    public Painting(Integer numOfPets, String address, boolean ifMonthly, Integer pervServiceNum, PropertySize propertySize) {
        super(numOfPets, address, ifMonthly, pervServiceNum, propertySize);
        switch (propertySize) {
            case Small:
                this.hour = 16;
            case Medium:
                this.hour = 16;
            case Large:
                this.hour = 24;
        }
    }
}
