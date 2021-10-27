package designofsystems.moremodularcookiecounter;

import java.util.Map;

public class ModularNutritionCalculator {
    private ModularNutritionCalculator() {
        // Does nothing but prevents a constructor being used.
    }

    public static String getTotalMessage(AbstractFoodItem item, double quantityEaten) {
        return buildMessage(item.totalCalories(quantityEaten), item.totalSugar(quantityEaten));
    }

    public static String getTotalMessage(Map<AbstractFoodItem, Double> items) {
        double cals = 0;
        double sugar = 0;
        for (AbstractFoodItem item: items.keySet()) {
            cals += item.totalCalories(items.get(item));
            sugar += item.totalSugar(items.get(item));
        }
        return buildMessage(cals, sugar);
    }

    private static String buildMessage(double calories, double sugar) {
        StringBuilder msg = new StringBuilder()
                .append("You ate ")
                .append(calories).append(" calories and ")
                .append(sugar).append(" grams of sugar");
        return msg.toString();

    }
}
