public abstract class Food implements IFood {

    public String name;

    public Double currentPricePerUnit;

    public Integer currentlyAvailableQuantity;

    public Integer maxAllowedQuantity;

    public String getName() {
        return this.name;
    }

    public Double getCurrentPricePerUnit() {
        return this.currentPricePerUnit;
    }

    public Integer getCurrentlyAvailableQuantity() {
        return this.currentlyAvailableQuantity;
    }

    public Integer getMaxAllowedQuantity() {
        return this.maxAllowedQuantity;
    }
}
