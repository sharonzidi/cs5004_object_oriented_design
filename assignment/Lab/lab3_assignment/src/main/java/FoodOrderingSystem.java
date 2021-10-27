import java.util.ArrayList;

public class FoodOrderingSystem {
    private ArrayList<IFood> foodList;

    public FoodOrderingSystem() {
        this.foodList = new ArrayList<>();
}

    public void addFood(Food food) {
        this.foodList.add(food);
    }

    public ArrayList<IFood> getFoodList() {
        return this.foodList;
    }
}
