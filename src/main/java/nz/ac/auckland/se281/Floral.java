package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

public class Floral extends Services {

  public String getCost(FloralType floralType) {
    String cost = Integer.toString(floralType.getCost());
    return cost;
  }

}