package p3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RealEstateTrends {

  private static final Integer ONLINE_ENGAGEMENT = 1;
  private static final Integer VISIT_ENGAGEMENT = 2;
  private List<Client> clients;

  public RealEstateTrends(List<Client> clients) {
    this.clients = clients;
  }

  public Map<String, Integer> trackEngagements(List<Client> clients){
    Map<String, Integer> trackEngagement = new HashMap<>();

    for(Client client: clients){
      for(String consideredProperty: client.getConsideredProperties()){
        if(trackEngagement.containsKey(consideredProperty)){
          trackEngagement.put(consideredProperty, trackEngagement.get(consideredProperty) + ONLINE_ENGAGEMENT);
        }else{
          trackEngagement.put(consideredProperty, ONLINE_ENGAGEMENT);
        }
        for(String visitedProperty: client.getVisitedProperties()){
          if(trackEngagement.containsKey(visitedProperty)){
            trackEngagement.put(visitedProperty, trackEngagement.get(visitedProperty) + VISIT_ENGAGEMENT);
          }else{
            trackEngagement.put(visitedProperty, VISIT_ENGAGEMENT);
          }
        }
      }
    }
    return trackEngagement;
  }

}

