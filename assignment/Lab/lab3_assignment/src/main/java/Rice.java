public class Rice extends NonPerishableFood {
    public Rice(String name,
                Double currentPricePerUnit,
                Integer currentlyAvailableQuantity) {
        this.name = name;
        this.currentPricePerUnit = currentPricePerUnit;
        this.currentlyAvailableQuantity = currentlyAvailableQuantity;
    }
}
