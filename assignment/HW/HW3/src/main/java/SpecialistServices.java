public abstract class SpecialistServices extends Services {

    private Integer numOfLicensedEmployeesRequired;
    private boolean ifComplex;
    protected final int MIN_EMPLOYEE = 1;
    protected final int MAX_EMPLOYEE = 4;

    public SpecialistServices(Integer numOfLicensedEmployeesRequired,
                              String address,
                              boolean ifMonthly,
                              Integer pervServiceNum,
                              PropertySize propertySize) {
        super(address, ifMonthly, pervServiceNum, propertySize);
        if (propertySize == PropertySize.Medium || propertySize == PropertySize.Small) {
            this.numOfLicensedEmployeesRequired = 2;
        }

        this.numOfLicensedEmployeesRequired = 3;

        this.numOfLicensedEmployeesRequired = numOfLicensedEmployeesRequired;
        this.baseRate = 200.0;

    }

    @Override
    public double calculatePrice() {
        return this.baseRate * this.numOfLicensedEmployeesRequired;
    }

    public Integer getNumOfLicensedEmployeesRequired() {
        return numOfLicensedEmployeesRequired;
    }

    public boolean getIfComplex() {
        return ifComplex;
    }
}
