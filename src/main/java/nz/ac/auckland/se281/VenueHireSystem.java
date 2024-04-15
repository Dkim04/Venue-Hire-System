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
  private String systemDate;
  private ArrayList<String> venueCodeBookinglist;
  private ArrayList<String> bookingDateList;
  private ArrayList<String> emailList;
  private ArrayList<String> attendeesList;
  private ArrayList<String> bookingReferenceList;

  public VenueHireSystem() {
    venueNameList = new ArrayList<>();
    venueCodeList = new ArrayList<>();
    venueCapacityList = new ArrayList<>();
    venueFeeList = new ArrayList<>();
    systemDate = null;
    venueCodeBookinglist = new ArrayList<>();
    bookingDateList = new ArrayList<>();
    emailList = new ArrayList<>();
    attendeesList = new ArrayList<>();
    bookingReferenceList = new ArrayList<>();
  }

  public void printVenues() {
    // TODO implement this method
     if (venueNameList.isEmpty()) {                                                                                     // If there are no venues
      MessageCli.NO_VENUES.printMessage();
    } 
    if (venueNameList.size() == 1) {                                                                                  // If there is only one venue
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
      for (int i = 0; i < venueNameList.size(); i++) {
        MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
      }
    }
    if (venueNameList.size() == 2) {                                                                                  // If there are two venues
      MessageCli.NUMBER_VENUES.printMessage("are", "two", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
      }
    }
    if (venueNameList.size() == 3) {                                                                                  // If there are three venues
      MessageCli.NUMBER_VENUES.printMessage("are", "three", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
      }
    }
    if (venueNameList.size() == 4) {                                                                                  // If there are four venues
      MessageCli.NUMBER_VENUES.printMessage("are", "four", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
      }
    }
    if (venueNameList.size() == 5) {                                                                                  // If there are five venues
      MessageCli.NUMBER_VENUES.printMessage("are", "five", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
      }
    }
    if (venueNameList.size() == 6) {                                                                                  // If there are six venues
      MessageCli.NUMBER_VENUES.printMessage("are", "six", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
      }
    }
    if (venueNameList.size() == 7) {                                                                                  // If there are seven venues
      MessageCli.NUMBER_VENUES.printMessage("are", "seven", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
      }
    }
    if (venueNameList.size() == 8) {                                                                                  // If there are eight venues
      MessageCli.NUMBER_VENUES.printMessage("are", "eight", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
      }
    }
    if (venueNameList.size() == 9) {                                                                                  // If there are nine venues
      MessageCli.NUMBER_VENUES.printMessage("are", "nine", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
      }
    }
    if (venueNameList.size() >= 10) {                                                                                 // If there are ten or more venues                  
      String numberofVenues = String.valueOf(venueNameList.size());
      MessageCli.NUMBER_VENUES.printMessage("are", numberofVenues, "s");

      for (int i = 0; i < venueNameList.size(); i++) {
        MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
      }
    }
  }

  public void createVenue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    try {                                                                                                               // If hireFeeInput is not an int number
      Integer.parseInt(hireFeeInput);
    } catch (Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return;
    }

    try {                                                                                                               // If capacityInput is not an int number
      Integer.parseInt(capacityInput);
    } catch (Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return;
    }

    if (!venueCode.isEmpty()) {                                                                                         // If venueCode is already in use for another venue
      for (int i = 0; i < venueNameList.size(); i++) {
        if (venueCode.equals(venueCodeList.get(i))) {
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCodeList.get(i), venueNameList.get(i));
          return;
        }
      }
    }

    if (Integer.parseInt(capacityInput) < 0) {                                                                          // If capacityInput is less than 0
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
    }
    else if (Integer.parseInt(hireFeeInput) < 0) {                                                                      // If hireFeeInput is less than 0
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
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
    this.systemDate = dateInput;
    MessageCli.DATE_SET.printMessage(this.systemDate);
  }

  public void printSystemDate() {
    if (this.systemDate == null) {
      MessageCli.CURRENT_DATE.printMessage("not set");
    } else {
      MessageCli.CURRENT_DATE.printMessage(this.systemDate);
    }
  }

// The system’s date must be set,
// There must be at least one venue in the system,
// The venue code must exist,
// The venue must be available on the specified date, and
// The booking date must not be in the past (today or later is OK in terms of the current system date).

  public void makeBooking(String[] options) {

    if (this.systemDate != null) {
      String[] date1Parts = options[1].split("/");
      String[] date2Parts = systemDate.split("/");

      if (date1Parts[2].compareTo(date2Parts[2]) < 0) {                                                                 // If the year is earlier
        MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], systemDate);
        return;
      } else if ((date1Parts[2] == date2Parts[2]) && (date1Parts[1].compareTo(date2Parts[1]) < 0)) {                    // If the year is the same but the month is earlier
        MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], systemDate);
        return;
      } else if ((date1Parts[2] == date2Parts[2]) && (date1Parts[1] == date2Parts[1]) && (date1Parts[0].compareTo(date2Parts[0]) < 0)) {    // If only the day is earlier
        MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], systemDate);
        return;
      }
    }


    if (this.systemDate == null) {                                                                                      // If there is no systemDate
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
    } else if (venueNameList.isEmpty()) {                                                                               // If there are no venues
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
    } else {
      for (int i = 0; i < venueCodeList.size(); i++) {
        if (venueCodeList.get(i).equals(options[0])) {                                                                  // If there is venue with the given code
          for (int j = 0; j < venueCodeBookinglist.size(); j++) {
            if (venueCodeBookinglist.get(j).equals(options[0])) {                                                       // Check if there is a booking for the given date
              if (bookingDateList.get(j).equals(options[1])) {
                MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(venueNameList.get(i), options[1]);
                return;
              }
            }
          }

          if (Integer.parseInt(options[3]) < ((Integer.parseInt(venueCapacityList.get(i)))/4)) {                        // If number of attendees is too small
            MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(options[3], Integer.toString(((Integer.parseInt(venueCapacityList.get(i)))/4)), venueCapacityList.get(i));
            options[3] = Integer.toString(((Integer.parseInt(venueCapacityList.get(i)))/4));
          }
          
          String reference = BookingReferenceGenerator.generateBookingReference();
          venueCodeBookinglist.add(options[0]);                                                                         // Adding the booking to the arraylists
          bookingDateList.add(options[1]);
          emailList.add(options[2]);
          attendeesList.add(options[3]);
          bookingReferenceList.add(reference);
          MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(reference, venueNameList.get(i), options[1], options[3]);
          return;
        }
      }

      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);                                             // If there is no venue with the given code
    }
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
