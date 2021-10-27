package p3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RestaurantRecommender {
    private Map<Restaurant, Integer> restaurantStatistics;

    public RestaurantRecommender(){
        this.restaurantStatistics = new HashMap<>();
    }

    public void getAggregatedStatistics(List<Guest> guests){
        for(Guest guest : guests) {
            List<Restaurant> restaurantList = guest.getVisitedRestaurant();
            for(Restaurant restaurant: restaurantList) {
                if(restaurantStatistics.containsKey(restaurant)) {
                    restaurantStatistics.put(restaurant, restaurantStatistics.get(restaurant) + 1);
                } else {
                    restaurantStatistics.put(restaurant, 1);
                }
            }
        }
    }

    public Restaurant recommendMostVisitedRestaurant() {
        Restaurant mostVisited = null;
        int visitTimes = 0;
        for (Map.Entry<Restaurant, Integer> entry : restaurantStatistics.entrySet()) {
            if (visitTimes < entry.getValue()) {
                visitTimes = entry.getValue();
                mostVisited = entry.getKey();
            }
        }
        return mostVisited;
    }

    public Restaurant recommendHighlyRatedRestaurant(String cousine) {
        Restaurant mostRated = null;
        float rated = 0;
        for (Map.Entry<Restaurant, Integer> entry : restaurantStatistics.entrySet()) {
            Restaurant currentRestaurant = entry.getKey();
            if (cousine.equals(currentRestaurant.getCuisine()) && rated < currentRestaurant.getRating()) {
                rated =  currentRestaurant.getRating();
                mostRated =  currentRestaurant;
            }
        }
        return  mostRated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantRecommender that = (RestaurantRecommender) o;
        return Objects.equals(restaurantStatistics, that.restaurantStatistics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantStatistics);
    }

    @Override
    public String toString() {
        return "RestaurantRecommender{" +
                "restaurantStatistics=" + restaurantStatistics +
                '}';
    }
}
