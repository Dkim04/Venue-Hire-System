package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class VenueHireSystem {

  // Added Fields
  private ArrayList<String> venueNameList;
  private ArrayList<String> venueCodeList;
  private ArrayList<String> venueCapacityList;
  private ArrayList<String> venueFeeList;
  private String systemDate;
  private ArrayList<String> venueCodeBookingList;
  private ArrayList<String> bookingDateList;
  private ArrayList<String> emailList;
  private ArrayList<String> attendeesList;
  private ArrayList<String> bookingReferenceList;
  private ArrayList<String> cateringList;
  private ArrayList<CateringType> cateringTypeList;
  private ArrayList<String> musicList;
  private ArrayList<String> floralList;
  private ArrayList<FloralType> floralTypeList;

  public VenueHireSystem() {
    venueNameList = new ArrayList<>();
    venueCodeList = new ArrayList<>();
    venueCapacityList = new ArrayList<>();
    venueFeeList = new ArrayList<>();
    systemDate = null;
    venueCodeBookingList = new ArrayList<>();
    bookingDateList = new ArrayList<>();
    emailList = new ArrayList<>();
    attendeesList = new ArrayList<>();
    bookingReferenceList = new ArrayList<>();
    cateringList = new ArrayList<>();
    cateringTypeList = new ArrayList<>();
    musicList = new ArrayList<>();
    floralList = new ArrayList<>();
    floralTypeList = new ArrayList<>();
  }

  public String nextAvailableDate(String venueCode, String date) {
    
    for (int i = 0; i < venueCodeBookingList.size(); i++) {
      if (venueCodeBookingList.get(i).equals(venueCode)) {
        if (bookingDateList.get(i).equals(date)) {    // If there is a booking on the given date
          String[] dateParts = date.split("/");

          if (dateParts[0].equals("31") && dateParts[1].equals("01")) {    // If the given date is the last day of January
            date = "01/02/" + dateParts[2];
            return nextAvailableDate(venueCode, date);
          }
          else if (dateParts[0].equals("28") && dateParts[1].equals("02")) {    // If the given date is the last day of February
            date = "01/03/" + dateParts[2];
            return nextAvailableDate(venueCode, date);
          }
          else if (dateParts[0].equals("31") && dateParts[1].equals("03")) {    // If the given date is the last day of March
            date = "01/04/" + dateParts[2];
            return nextAvailableDate(venueCode, date);
          }
          else if (dateParts[0].equals("30") && dateParts[1].equals("04")) {    // If the given date is the last day of April
            date = "01/05/" + dateParts[2];
            return nextAvailableDate(venueCode, date);
          }
          else if (dateParts[0].equals("31") && dateParts[1].equals("05")) {    // If the given date is the last day of May
            date = "01/06/" + dateParts[2];
            return nextAvailableDate(venueCode, date);
          }
          else if (dateParts[0].equals("30") && dateParts[1].equals("06")) {    // If the given date is the last day of June
            date = "01/07/" + dateParts[2];
            return nextAvailableDate(venueCode, date);
          }
          else if (dateParts[0].equals("31") && dateParts[1].equals("07")) {    // If the given date is the last day of July
            date = "01/08/" + dateParts[2];
            return nextAvailableDate(venueCode, date);
          }
          else if (dateParts[0].equals("31") && dateParts[1].equals("08")) {    // If the given date is the last day of August
            date = "01/09/" + dateParts[2];
            return nextAvailableDate(venueCode, date);
          }
          else if (dateParts[0].equals("30") && dateParts[1].equals("09")) {    // If the given date is the last day of September
            date = "01/10/" + dateParts[2];
            return nextAvailableDate(venueCode, date);
          }
          else if (dateParts[0].equals("31") && dateParts[1].equals("10")) {    // If the given date is the last day of October
            date = "01/11/" + dateParts[2];
            return nextAvailableDate(venueCode, date);
          }
          else if (dateParts[0].equals("30") && dateParts[1].equals("11")) {    // If the given date is the last day of November
            date = "01/12/" + dateParts[2];
            return nextAvailableDate(venueCode, date);
          }
          else if (dateParts[0].equals("31") && dateParts[1].equals("12")) {    // If the given date is the last day of December
            String year = Integer.toString((Integer.parseInt(dateParts[2])) + 1);
            date = "01/01/" + year;
            return nextAvailableDate(venueCode, date);
          } else {
            String day = Integer.toString((Integer.parseInt(dateParts[0])) + 1);
            if (Integer.parseInt(day) >= 10) {
              date = day + "/" + dateParts[1] + "/" + dateParts[2];
            } else {
              date = "0" + day + "/" + dateParts[1] + "/" + dateParts[2];
            }
            return nextAvailableDate(venueCode, date);
          }
        }
      }
    }
    return date;    // If there is no booking on the given date then that is the next available date
  }

  public void printVenues() {

     if (venueNameList.isEmpty()) {    // If there are no venues
      MessageCli.NO_VENUES.printMessage();
    } 
    if (venueNameList.size() == 1) {    // If there is only one venue
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
      for (int i = 0; i < venueNameList.size(); i++) {
        if (systemDate != null) {
          String availableDate = nextAvailableDate(venueCodeList.get(i), this.systemDate);
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i), availableDate);
        } else {
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
        }
      }
    }
    if (venueNameList.size() == 2) {    // If there are two venues
      MessageCli.NUMBER_VENUES.printMessage("are", "two", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        if (systemDate != null) {
          String availableDate = nextAvailableDate(venueCodeList.get(i), this.systemDate);
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i), availableDate);
        } else {
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
        }
      }
    }
    if (venueNameList.size() == 3) {    // If there are three venues
      MessageCli.NUMBER_VENUES.printMessage("are", "three", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        if (systemDate != null) {
          String availableDate = nextAvailableDate(venueCodeList.get(i), this.systemDate);
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i), availableDate);
        } else {
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
        }
      }
    }
    if (venueNameList.size() == 4) {    // If there are four venues
      MessageCli.NUMBER_VENUES.printMessage("are", "four", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        if (systemDate != null) {
          String availableDate = nextAvailableDate(venueCodeList.get(i), this.systemDate);
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i), availableDate);
        } else {
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
        }
      }
    }
    if (venueNameList.size() == 5) {    // If there are five venues
      MessageCli.NUMBER_VENUES.printMessage("are", "five", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        if (systemDate != null) {
          String availableDate = nextAvailableDate(venueCodeList.get(i), this.systemDate);
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i), availableDate);
        } else {
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
        }
      }
    }
    if (venueNameList.size() == 6) {    // If there are six venues
      MessageCli.NUMBER_VENUES.printMessage("are", "six", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        if (systemDate != null) {
          String availableDate = nextAvailableDate(venueCodeList.get(i), this.systemDate);
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i), availableDate);
        } else {
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
        }
      }
    }
    if (venueNameList.size() == 7) {    // If there are seven venues
      MessageCli.NUMBER_VENUES.printMessage("are", "seven", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        if (systemDate != null) {
          String availableDate = nextAvailableDate(venueCodeList.get(i), this.systemDate);
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i), availableDate);
        } else {
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
        }
      }
    }
    if (venueNameList.size() == 8) {    // If there are eight venues
      MessageCli.NUMBER_VENUES.printMessage("are", "eight", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        if (systemDate != null) {
          String availableDate = nextAvailableDate(venueCodeList.get(i), this.systemDate);
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i), availableDate);
        } else {
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
        }
      }
    }
    if (venueNameList.size() == 9) {    // If there are nine venues
      MessageCli.NUMBER_VENUES.printMessage("are", "nine", "s");
      for (int i = 0; i < venueNameList.size(); i++) {
        if (systemDate != null) {
          String availableDate = nextAvailableDate(venueCodeList.get(i), this.systemDate);
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i), availableDate);
        } else {
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
        }
      }
    }
    if (venueNameList.size() >= 10) {    // If there are ten or more venues                  
      String numberofVenues = String.valueOf(venueNameList.size());
      MessageCli.NUMBER_VENUES.printMessage("are", numberofVenues, "s");

      for (int i = 0; i < venueNameList.size(); i++) {
        if (systemDate != null) {
          String availableDate = nextAvailableDate(venueCodeList.get(i), this.systemDate);
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i), availableDate);
        } else {
          MessageCli.VENUE_ENTRY.printMessage(venueNameList.get(i), venueCodeList.get(i), venueCapacityList.get(i), venueFeeList.get(i));
        }
      }
    }
  }

  public void createVenue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {

    try {    // If hireFeeInput is not an int number
      Integer.parseInt(hireFeeInput);
    } catch (Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return;
    }

    try {    // If capacityInput is not an int number
      Integer.parseInt(capacityInput);
    } catch (Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return;
    }

    if (!venueCode.isEmpty()) {    // If venueCode is already in use for another venue
      for (int i = 0; i < venueNameList.size(); i++) {
        if (venueCode.equals(venueCodeList.get(i))) {
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCodeList.get(i), venueNameList.get(i));
          return;
        }
      }
    }

    if (Integer.parseInt(capacityInput) < 0) {    // If capacityInput is less than 0
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
    }
    else if (Integer.parseInt(hireFeeInput) < 0) {    // If hireFeeInput is less than 0
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
    }
    else if (venueName.isEmpty()) {    // If the venueName is empty
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
    }
    else if (!venueName.isEmpty() && !venueCode.isEmpty() && !capacityInput.isEmpty() && !hireFeeInput.isEmpty()) {    // If all the inputs are correct and not empty then create
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

  public void makeBooking(String[] options) {

    if (this.systemDate != null) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

      LocalDate sysDate = LocalDate.parse(this.systemDate, formatter);
      LocalDate bookDate = LocalDate.parse(options[1], formatter);

      if (bookDate.isBefore(sysDate)) {
        MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], systemDate);
        return;
      }
    }


    if (this.systemDate == null) {    // If there is no systemDate
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
    } else if (venueNameList.isEmpty()) {    // If there are no venues
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
    } else {
      for (int i = 0; i < venueCodeList.size(); i++) {
        if (venueCodeList.get(i).equals(options[0])) {    // If there is venue with the given code
          for (int j = 0; j < venueCodeBookingList.size(); j++) {
            if (venueCodeBookingList.get(j).equals(options[0])) {    // Check if there is a booking for the given date
              if (bookingDateList.get(j).equals(options[1])) {
                MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(venueNameList.get(i), options[1]);
                return;
              }
            }
          }

          if (Integer.parseInt(options[3]) < ((Integer.parseInt(venueCapacityList.get(i)))/4)) {    // If number of attendees is too small
            MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(options[3], Integer.toString(((Integer.parseInt(venueCapacityList.get(i)))/4)), venueCapacityList.get(i));
            options[3] = Integer.toString(((Integer.parseInt(venueCapacityList.get(i)))/4));
          } else if (Integer.parseInt(options[3]) > Integer.parseInt(venueCapacityList.get(i))) {    // If number of attendees is too large
            MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(options[3], venueCapacityList.get(i), venueCapacityList.get(i));
            options[3] = venueCapacityList.get(i);
          }

          String reference = BookingReferenceGenerator.generateBookingReference();
          venueCodeBookingList.add(options[0]);    // Adding the booking to the arraylists
          bookingDateList.add(options[1]);
          emailList.add(options[2]);
          attendeesList.add(options[3]);
          bookingReferenceList.add(reference);
          MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(reference, venueNameList.get(i), options[1], options[3]);
          return;
        }
      }

      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);    // If there is no venue with the given code
    }
  }

  public void printBookings(String venueCode) {

    int count = 0;
    int tempindex = 0;
    for (int j = 0; j < venueCodeList.size(); j++) {
      if (venueCodeList.get(j).equals(venueCode)) {
        count = 1;
        tempindex = j;
      }
    }

    for (int i = 0; i < venueCodeBookingList.size(); i++) {
      if (venueCodeBookingList.get(i).equals(venueCode)) {
        count = 2;
      }
    }
    
    if (count == 2) {
      MessageCli.PRINT_BOOKINGS_HEADER.printMessage(venueNameList.get(tempindex));
      for (int f = 0; f < venueCodeBookingList.size(); f++) {
        if (venueCodeBookingList.get(f).equals(venueCode)) {
          MessageCli.PRINT_BOOKINGS_ENTRY.printMessage(bookingReferenceList.get(f), bookingDateList.get(f));
        }
      }
    } else if (count == 1) {
      MessageCli.PRINT_BOOKINGS_HEADER.printMessage(venueNameList.get(tempindex));
      MessageCli.PRINT_BOOKINGS_NONE.printMessage(venueNameList.get(tempindex));
    } else if (count == 0) {
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
    }
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {

    if (bookingReferenceList.contains(bookingReference)) {
      cateringList.add(bookingReference);
      cateringTypeList.add(cateringType);
      String cateringService = "Catering (" + cateringType.getName() + ")";
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(cateringService, bookingReference);
    } else {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Catering", bookingReference);
    }
  }
  
  public void addServiceMusic(String bookingReference) {

    if (bookingReferenceList.contains(bookingReference)) {
      musicList.add(bookingReference);
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Music", bookingReference);
    } else {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Music", bookingReference);
    }
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {

    if (bookingReferenceList.contains(bookingReference)) {
      floralList.add(bookingReference);
      floralTypeList.add(floralType);
      String floralService = "Floral (" + floralType.getName() + ")";
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(floralService, bookingReference);
    } else {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Floral", bookingReference);
    }
  }

  public void viewInvoice(String bookingReference) {

    int tempi = 0;
    int tempj = 0;
    int cateringCost = 0;
    int musicCost = 0;
    int floralCost = 0;
    int totalAmount = 0;

    for (int i = 0; i < bookingReferenceList.size(); i++) {   // Getting temporary index for the booking code, email, date, and attendees
      if (bookingReference.equals(bookingReferenceList.get(i))) {
        tempi = i;
      }
    }

    for (int j = 0; j < venueCodeList.size(); j++) {    // Getting temporary index for the venue name and hire fee
      if (venueCodeBookingList.get(tempi).equals(venueCodeList.get(j))) {
        tempj = j;
      }
    }

    MessageCli.INVOICE_CONTENT_TOP_HALF.printMessage(bookingReference, emailList.get(tempi), systemDate, bookingDateList.get(tempi), attendeesList.get(tempi), venueNameList.get(tempj));
    MessageCli.INVOICE_CONTENT_VENUE_FEE.printMessage(venueFeeList.get(tempj));

    for (int k = 0; k < cateringList.size(); k++) {    // If there is a catering service
      if (cateringList.get(k).equals(bookingReference)) {
        Catering catering = new Catering();
        String cost = catering.getCost(cateringTypeList.get(k), Integer.parseInt(attendeesList.get(tempi)));
        cateringCost = Integer.parseInt(cost);
        String cateringType = (cateringTypeList.get(k)).getName();
        MessageCli.INVOICE_CONTENT_CATERING_ENTRY.printMessage(cateringType, cost);
      }
    }

    for (int l = 0; l < musicList.size(); l++) {    // If there is a music service
      if (musicList.get(l).equals(bookingReference)) {
        Music music = new Music();
        String cost = music.getCost();
        musicCost = Integer.parseInt(cost);
        MessageCli.INVOICE_CONTENT_MUSIC_ENTRY.printMessage(cost);
      }
    }

    for (int m = 0; m < floralList.size(); m++) {    // If there is a floral service
      if (floralList.get(m).equals(bookingReference)) {
        Floral floral = new Floral();
        String cost = floral.getCost(floralTypeList.get(m));
        floralCost = Integer.parseInt(cost);
        String floralType = (floralTypeList.get(m)).getName();
        MessageCli.INVOICE_CONTENT_FLORAL_ENTRY.printMessage(floralType, cost);
      }
    }

    totalAmount = Integer.parseInt(venueFeeList.get(tempj)) + cateringCost + musicCost + floralCost;

    MessageCli.INVOICE_CONTENT_BOTTOM_HALF.printMessage(Integer.toString(totalAmount));
  }
}
