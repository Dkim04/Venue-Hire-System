package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;

public abstract class Services {
  public enum ServiceType {
    Catering,
    Music,
    Floral
  }

  protected ServiceType serviceType;

  public Services(ServiceType service) {
    this.serviceType = service;
  }

  
}