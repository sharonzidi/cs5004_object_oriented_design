public class Meat extends PerishableFood {
    public Meat(String name,
                Double currentPricePerUnit,
                Integer currentlyAvailableQuantity,
                Integer orderDate,
                Integer expirationDate) {
        this.name = name;
        this.currentPricePerUnit = currentPricePerUnit;
        this.currentlyAvailableQuantity = currentlyAvailableQuantity;
        this.orderDate = orderDate;
        this.expirationDate = expirationDate;
    }
}