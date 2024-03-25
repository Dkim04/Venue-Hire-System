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

  public VenueHireSystem() {
    venueNameList = new ArrayList<>();
    venueCodeList = new ArrayList<>();
    venueCapacityList = new ArrayList<>();
    venueFeeList = new ArrayList<>();
  }

  public void printVenues() {
    // TODO implement this method
     if (venueNameList.isEmpty()) {                                                                                     // If there are no venues
      MessageCli.NO_VENUES.printMessage();
    } if (venueNameList.size() == 1) {                                                                                  // If there is only one venue
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
    }
  }

  public void createVenue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    try {                                                                                                               // If hireFeeInput is not an int number
      Integer.parseInt(hireFeeInput);
    } catch (Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return;
    }

    if (Integer.parseInt(capacityInput) < 0) {                                                                          // If capacityInput is less than 0
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
    }
    else if (venueName.isEmpty()) {                                                                                     // If the venueName is empty
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
    }
    else if (!venueName.isEmpty() && !venueCode.isEmpty() && !capacityInput.isEmpty() && !hireFeeInput.isEmpty()) {     // If all the inputs are correct and not empty then create
      venueNameList.add(venueName);
      venueCodeList.add(venueCode);
      venueCapacityList.add(capacityInput);
      venueFeeList.add(hireFeeInput);
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
