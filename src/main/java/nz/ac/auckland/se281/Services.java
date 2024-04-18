package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public abstract class Services {
  public enum ServiceType {
    Catering,
    Music,
    Floral
  }

  protected ServiceType serviceType;
  protected CateringType cateringType;
  protected FloralType floralType;

  public Services(ServiceType service, CateringType cateringType) {
    this.serviceType = service;
    this.cateringType = cateringType;
  }

  public Services(ServiceType service, FloralType floralType) {
    this.serviceType = service;
    this.floralType = floralType;
  }

  public Services(ServiceType service) {
    this.serviceType = service;
  }

  public ServiceType getServiceType() {
    return this.serviceType;
  }
}