public class Electrical extends SpecialistServices {

    public Electrical(Integer numOfLicensedEmployeesRequired,
                      String address,
                      boolean ifMonthly,
                      Integer pervServiceNum,
                      PropertySize propertySize) throws ExceedEmployeeException {
        super(numOfLicensedEmployeesRequired, address, ifMonthly, pervServiceNum, propertySize);

        if (numOfLicensedEmployeesRequired > 4) {
            throw new ExceedEmployeeException("Cannot create an electrical service");
        }
    }

    @Override
    public double calculatePrice() {
        return baseRate * this.hour + 50;
    }
}
