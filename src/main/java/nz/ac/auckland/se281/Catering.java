package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class Catering extends Services {

  public String getCost(CateringType cateringType, int attendees) {
    String cost = Integer.toString(cateringType.getCostPerPerson() * attendees);
    return cost;
  }

}