public interface IServices {
    public String getAddress();
    public PropertySize getPropertySize();
    public boolean ifCarriedMonthly();
    public Integer getPervServiceNum();
    public double calculatePrice();
}

enum PropertySize {
    Small,
    Medium,
    Large
}