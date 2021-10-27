public class Plumbing extends SpecialistServices {
    public Plumbing(Integer numOfLicensedEmployeesRequired, String address, boolean ifMonthly, Integer pervServiceNum, PropertySize propertySize) {
        super(numOfLicensedEmployeesRequired, address, ifMonthly, pervServiceNum, propertySize);
    }

    @Override
    public double calculatePrice() {
        return baseRate * this.hour + 50;
    }
}
