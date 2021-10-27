public abstract class PerishableFood extends Food {
    protected Integer orderDate;
    protected Integer expirationDate;

    public PerishableFood() {
        this.maxAllowedQuantity = 100;
    }

    public Integer getOrderDate() {
        return orderDate;
    }

    public Integer getExpirationDate() {
        return expirationDate;
    }
}
