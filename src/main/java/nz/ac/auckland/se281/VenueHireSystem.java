package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  // Added Fields
  private ArrayList<String> venueNameList;
  private ArrayList<String> venueCodeList;
  private ArrayList<String> venueCapacityList;
  private ArrayList<String> venueFeeList;
  private int id;

  public VenueHireSystem() {
    venueNameList = new ArrayList<>();
    venueCodeList = new ArrayList<>();
    venueCapacityList = new ArrayList<>();
    venueFeeList = new ArrayList<>();
    id = 0;
  }

  public void printVenues() {
    // TODO implement this method
    if (venueNameList.isEmpty()) {
      MessageCli.NO_VENUES.printMessage();
    }
  }

  public void createVenue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    if (!venueName.isEmpty() && !venueCode.isEmpty() && !capacityInput.isEmpty() && !hireFeeInput.isEmpty()) {
      venueNameList.add(id, venueName);
      venueCodeList.add(id, venueCode);
      venueCapacityList.add(id, capacityInput);
      venueFeeList.add(id, hireFeeInput);
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
    }
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
