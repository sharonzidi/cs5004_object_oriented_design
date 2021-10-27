public class Pasta extends NonPerishableFood {
    public Pasta(String name,
                 Double currentPricePerUnit,
                 Integer currentlyAvailableQuantity) {
        this.name = name;
        this.currentPricePerUnit = currentPricePerUnit;
        this.currentlyAvailableQuantity = currentlyAvailableQuantity;
    }
}
