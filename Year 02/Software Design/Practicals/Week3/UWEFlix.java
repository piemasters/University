package year2.SD.Week3;

import java.util.Scanner;
import java.text.DecimalFormat;

public class UWEFlix {

    public static void main(String[] args) {

        //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        // SET UP OBJECTS
        //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

        Price PriceList[] = new Price[3];
        PriceList[0] = new Price(1, "Adult", 5);
        PriceList[1] = new Price(2, "Student", 4);
        PriceList[2] = new Price(3, "Child", 3);

        Film FilmList[] = new Film[4];
        FilmList[0] = new Film(1, "Ice Age 4", "U", 78, "Snow, Ice, more snow and ice!");
        FilmList[1] = new Film(2, "Superman Returns", "12A", 154, "A new chapter in the saga of our superhero");
        FilmList[2] = new Film(3, "The Hobbit", "15", 133, "Lord of the Rings prequel…");

        Screen ScreenList[] = new Screen[4];
        ScreenList[0] = new Screen(1, 50);
        ScreenList[1] = new Screen(2, 75);
        ScreenList[2] = new Screen(3, 100);

        Showing ShowingList[] = new Showing[4];
        ShowingList[0] = new Showing(1, "April", 01, "17:00", FilmList[0], ScreenList[0], ScreenList[0].getcapacity());
        ShowingList[1] = new Showing(2, "April", 01, "19:00", FilmList[1], ScreenList[1], ScreenList[1].getcapacity());
        ShowingList[2] = new Showing(3, "April", 02, "19:00", FilmList[2], ScreenList[2], ScreenList[2].getcapacity());

        Booking BookingList[] = new Booking[1000];

        //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        // END SET UP OBJECTS 
        //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

        //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        // ENTER PROGRAM
        //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

        Scanner scan = new Scanner(System.in);
        int user = 10, managerOption = 10, customerOption = 10;

        while (user != 0) {

            System.out.println("---------------------------------------------");
            System.out.println("Welcome to UWEFlix");
            System.out.println("---------------------------------------------");
            System.out.println("If you are a cinema manager please press:   1");
            System.out.println("If you are a customer please press:         2");
            System.out.println("To power off please press:                  0");
            System.out.println("---------------------------------------------");

            user = scan.nextInt();

            //==================================================================
            // START MANAGER MODE
            //==================================================================

            if (user == 1) {

                while (managerOption != 0) {

                    System.out.println("---------------------------------------------");
                    System.out.println("Staff");
                    System.out.println("---------------------------------------------");
                    System.out.println("For a list of current films press:          1");
                    System.out.println("To add a film press:                        2");
                    System.out.println("To delete a film press:                     3");
                    System.out.println("For a list of current screens press:        4");
                    System.out.println("To add a screen press:                      5");
                    System.out.println("To delete a screen press:                   6");
                    System.out.println("For a list of current showings press:       7");
                    System.out.println("To add a showing press:                     8");
                    System.out.println("To delete a showing press:                  9");
                    System.out.println("To quit press:                              0");
                    System.out.println("---------------------------------------------");

                    managerOption = scan.nextInt();
                    System.out.println("---------------------------------------------");

                    switch (managerOption) {

                        //------------------------------------------------------
                        // List Films
                        //------------------------------------------------------

                        case 1:
                            for (int i = 0; i < FilmList.length; i++) {
                                if (FilmList[i] != null) {
                                    System.out.println(FilmList[i]);
                                }
                            }
                            break;

                        //------------------------------------------------------
                        // Add Films
                        //------------------------------------------------------

                        case 2:

                            // Retrieve Film details
                            //---------------------------------------

                            String tFilmTit,
                             tFilmAge,
                             tFilmDes;
                            int tFilmDur;
                            
                            String clear = scan.nextLine(); //Clears the scanner ready to scan a line.
                            System.out.print("Enter the Film Title:                          ");
                            tFilmTit = scan.nextLine();
                            System.out.print("Enter the Film Age Rating:                     ");
                            tFilmAge = scan.next();
                            System.out.print("Enter the Film Duration (in mins):             ");
                            tFilmDur = scan.nextInt();
                            System.out.print("Enter the Film Description:                    ");
                            tFilmDes = scan.next();

                            // Add Film to first avaliable array slot
                            //---------------------------------------

                            boolean filmUpdated = false;
                            int fCount = 0;

                            while (filmUpdated != true && fCount < FilmList.length) { // While not added to array & not reached end of array

                                if (filmUpdated != true && FilmList[fCount] == null) { // If not already added to array & array element is empty

                                    FilmList[fCount] = new Film(fCount + 1, tFilmTit, tFilmAge, tFilmDur, tFilmDes); // Add film to array
                                    filmUpdated = true;
                                }
                                fCount++;

                            }

                            // Display error if Film not added 
                            //---------------------------------------

                            if (filmUpdated == false) {
                                System.out.println("---------------------------------------------");
                                System.out.println("Error - The film database is full.");
                            }
                            break;

                        //------------------------------------------------------
                        // Delete Films
                        //------------------------------------------------------

                        case 3:

                            int delID;
                            System.out.println("Which Film ID would you like to delete? (Press 0 to Cancel)");
                            delID = scan.nextInt();
                            if (delID != 0) {
                                FilmList[delID - 1] = null;
                            }
                            break;

                        //------------------------------------------------------
                        // Display Screens
                        //------------------------------------------------------

                        case 4:
                            for (int i = 0; i < ScreenList.length; i++) {
                                if (ScreenList[i] != null) {
                                    System.out.println(ScreenList[i]);
                                }
                            }
                            break;

                        //------------------------------------------------------
                        // Add Screens
                        //------------------------------------------------------                            

                        case 5:

                            // Retrieve Screen details
                            //---------------------------------------

                            int tScreenCap;
                            System.out.print("Enter the Screen Capacity:                     ");
                            tScreenCap = scan.nextInt();

                            // Add Screen to first avaliable array slot
                            //---------------------------------------

                            boolean screenUpdated = false;
                            int sCount = 0;

                            while (screenUpdated != true && sCount < ScreenList.length) {

                                if (screenUpdated != true && ScreenList[sCount] == null) {
                                    ScreenList[sCount] = new Screen(sCount + 1, tScreenCap);
                                    screenUpdated = true;
                                }
                                sCount++;

                            }

                            // Display error if Screen not added 
                            //---------------------------------------

                            if (screenUpdated == false) {
                                System.out.println("---------------------------------------------");
                                System.out.println("Error - The screen database is full.");
                            }
                            break;

                        //------------------------------------------------------
                        // Delete Screens
                        //------------------------------------------------------                        

                        case 6:
                            int delScreen;
                            System.out.println("Which Screen ID would you like to delete? (Press 0 to Cancel)");
                            delScreen = scan.nextInt();
                            if (delScreen != 0) {
                                FilmList[delScreen - 1] = null;
                            }
                            break;

                        //------------------------------------------------------
                        // Display Showings
                        //------------------------------------------------------                            

                        case 7:
                            for (int i = 0; i < ShowingList.length; i++) {
                                if (ShowingList[i] != null) {
                                    System.out.println(ShowingList[i]);
                                }
                            }
                            break;

                        //------------------------------------------------------
                        // Add Showings
                        //------------------------------------------------------                            

                        case 8:

                            // Retrieve Showing details
                            //---------------------------------------

                            String tShowingMon,
                             tShowingTim;
                            int tShowingDat,
                             tShowingFil,
                             tShowingScr;

                            System.out.print("Enter the Showing Month (e.g January):         ");
                            tShowingMon = scan.next();
                            System.out.print("Enter the Showing Date (e.g 01):               ");
                            tShowingDat = scan.nextInt();
                            System.out.print("Enter the Showing Time (e.g 12:30):            ");
                            tShowingTim = scan.next();
                            System.out.print("Enter the Film ID:                             ");
                            tShowingFil = scan.nextInt();
                            System.out.print("Enter the Screen ID:                           ");
                            tShowingScr = scan.nextInt();

                            // Add Showing to first avaliable array slot
                            //---------------------------------------

                            boolean showingUpdated = false;
                            int shCount = 0;

                            while (showingUpdated != true && shCount < ShowingList.length) {

                                if (showingUpdated != true && ShowingList[shCount] == null) {
                                    ShowingList[shCount] = new Showing(shCount + 1, tShowingMon, tShowingDat, tShowingTim,
                                            FilmList[tShowingFil], ScreenList[tShowingScr], ScreenList[tShowingScr].getcapacity());
                                    showingUpdated = true;
                                }
                                shCount++;

                            }

                            // Display error if Showing not added 
                            //---------------------------------------

                            if (showingUpdated == false) {
                                System.out.println("---------------------------------------------");
                                System.out.println("Error - The showing database is full.");
                            }
                            break;

                        //------------------------------------------------------
                        // Delete Showings
                        //------------------------------------------------------                            

                        case 9:
                            int delShowing;
                            System.out.println("Which Showing ID would you like to delete? (Press 0 to Cancel)");
                            delShowing = scan.nextInt();
                            if (delShowing != 0) {
                                FilmList[delShowing - 1] = null;
                            }
                            break;

                        //------------------------------------------------------
                        // Exit
                        //------------------------------------------------------

                        case 0:
                            break;

                        default:
                            System.out.println("Invalid Input. Please press a value between 0-9");
                            break;

                    } //Manager Switch
                } //Manager While

                //==============================================================
                // END MANAGER MODE
                //==============================================================

                //==============================================================
                // START CUSTOMER MODE
                //==============================================================

            } else if (user == 2) {

                while (customerOption != 0) {

                    System.out.println("---------------------------------------------");
                    System.out.println("Customer");
                    System.out.println("---------------------------------------------");
                    System.out.println("To purchase advanced tickets press:         1");
                    System.out.println("To collect your tickets press:              2");
                    System.out.println("To quit press:                              0");
                    System.out.println("---------------------------------------------");

                    customerOption = scan.nextInt();

                    switch (customerOption) {

                        //------------------------------------------------------
                        // Purchase Advance Tickets
                        //------------------------------------------------------

                        case 1:

                            // List films of a certain date
                            //--------------------------------------------------

                            String userMonth;
                            int userDate;

                            System.out.print("Please enter the month (e.g April): ");
                            userMonth = scan.next();
                            System.out.print("Please enter the date (e.g 01):     ");
                            userDate = scan.nextInt();
                            System.out.println("---------------------------------------------");
                            System.out.println("Current showings for that date are:");

                            for (int i = 0; i < ShowingList.length; i++) {
                                if (ShowingList[i] != null) {
                                    if (ShowingList[i].getmonth().equals(userMonth) && ShowingList[i].getdate() == userDate) {
                                        System.out.println(ShowingList[i]);
                                    }
                                }
                            }
                            System.out.println("---------------------------------------------");

                            // Select a listed Showing
                            //--------------------------------------------------

                            System.out.print("Select a film to book (press 0 to cancel): ");
                            int userSelect = scan.nextInt();

                            if (userSelect != 0) {
                                int numTickets, ticketType, totalCost;

                                System.out.println("---------------------------------------------");
                                System.out.println("This is the film you have selected to book:  ");
                                System.out.println(FilmList[userSelect - 1] + " | Time: "
                                        + ShowingList[userSelect - 1].gettime());
                                System.out.println("---------------------------------------------");

                                // Select number of tickets
                                //----------------------------------------------

                                System.out.println("How many tickets would you like to purchase?:  ");

                                numTickets = scan.nextInt();

                                // Check if fully booked
                                //----------------------------------------------

                                if (numTickets > ShowingList[userSelect - 1].getseatAvailability() || numTickets <= 0) { // if number of tickets is greater than remaining seats or user entered less than 1 ticket

                                    if (ShowingList[userSelect - 1].getseatAvailability() == 0) { // if fully booked
                                        System.out.println("Sorry this showing is fully booked!");
                                    } else if (numTickets <= 0) { // if user enter less than 1 ticket
                                        System.out.println("Please purchse 1 or more tickets.");
                                    } else { // if user selected more tickets than seats available 
                                        System.out.println("Sorry there are only " + ShowingList[userSelect - 1].getseatAvailability() + " seats avaliable");
                                    }

                                    System.out.println("Please check another showing!");

                                } // end check fully booked
                                //
                                // Select Ticket Type
                                //----------------------------------------------
                                else {

                                    System.out.println("Select the ticket type:");

                                    for (int i = 0; i < PriceList.length; i++) {
                                        System.out.println(PriceList[i]);
                                    }

                                    ticketType = scan.nextInt();

                                    // Display cost & prompt to proceed / cancel
                                    //------------------------------------------

                                    totalCost = numTickets * PriceList[ticketType - 1].getcost();
                                    DecimalFormat tCost = new DecimalFormat("£.00");

                                    System.out.println("---------------------------------------------");
                                    System.out.println("The total cost of this booking is:  "
                                            + tCost.format(totalCost));
                                    System.out.println("To continue to purchase press :      1");
                                    System.out.println("To cancel press:                     0");

                                    int contPayment = scan.nextInt();
                                    System.out.println("---------------------------------------------");

                                    // Enter Payment Details
                                    //------------------------------------------

                                    switch (contPayment) {
                                        case 1:

                                            // Card Type -----------------------

                                            System.out.println("Please enter your Payment Type");
                                            System.out.println("Please enter 1 for Credit Card");
                                            System.out.println("Please enter 2 for Payment Card");

                                            int tempType = scan.nextInt();
                                            String payType = "";

                                            if (tempType == 1) {
                                                payType = "Credit Card";
                                            } else if (tempType == 2) {
                                                payType = "Payment Card";
                                            } else {
                                                System.out.println("Invalid Input. Enter 1 or 2");
                                                payType = "Invalid";
                                            }

                                            // Card Number ---------------------

                                            System.out.print("Card Number:              ");
                                            String cardNum = scan.next();

                                            // Expiery Date --------------------

                                            System.out.print("Expiery Date (e.g 02/15): ");
                                            String expDate = scan.next();

                                            System.out.println("---------------------------------------------");

                                            // Add & display booking
                                            //----------------------------------

                                            boolean bookingUpdated = false;
                                            int bCount = 0;

                                            while (bookingUpdated != true && bCount < BookingList.length) { // While not added to array & not reached end of array

                                                if (bookingUpdated != true && BookingList[bCount] == null) { // If not already added to array & array element is empty
                                                    BookingList[bCount] = new Booking(bCount + 1, ShowingList[userSelect - 1],
                                                            numTickets, PriceList[ticketType - 1].getticketType(), totalCost, // Add Booking to array
                                                            payType, cardNum, expDate);
                                                    bookingUpdated = true;

                                                    System.out.println("Here is your booking:\n" + BookingList[bCount]); // Display booking
                                                }
                                                bCount++;

                                            }

                                            // Decrement remaining Showing seats
                                            //----------------------------------

                                            int tempSeatAvailability = ShowingList[userSelect - 1].getseatAvailability();
                                            ShowingList[userSelect - 1].decSeats(tempSeatAvailability, numTickets);

                                            break;

                                        // Cancel Booking
                                        //--------------------------------------

                                        case 0:
                                            System.out.println("You have successfully cancelled your booking.");
                                            break;
                                        default:
                                            System.out.println("Invalid Input. Enter 0 or 1");
                                            break;

                                    } // End continue payment switch

                                } // End Select Ticket Type if/else

                            } else if (userSelect == 0) {
                                System.out.println("Booking cancelled");
                            } else {
                                System.out.println("You entered an invalid Film ID");
                            }

                            break;

                        //------------------------------------------------------
                        // Collect Tickets
                        //------------------------------------------------------

                        case 2:
                            System.out.println("This feature has not yet been implemented.");

                        //------------------------------------------------------
                        // Exit
                        //------------------------------------------------------

                        case 0:
                            break;

                        default:
                            System.out.println("Invalid Input. Please press a value between 0-2");
                            break;
                    }
                } //Customer While

                //==============================================================
                // END CUSTOMER MODE
                //==============================================================


                //--------------------------------------------------------------
                // Exit
                //--------------------------------------------------------------

            } else if (user == 0) {
                System.out.println("---------------------------------------------");
                System.out.println("Thank you for using UWEFlix. Goodbye!");
                System.out.println("---------------------------------------------");
            } //------------------------------------------------------
            // Error
            //--------------------------------------------------------
            else {
                System.out.println("---------------------------------------------");
                System.out.println("You have entered an incorrect value.");
                System.out.println("Please select either '1' or '2'.");
                System.out.println("---------------------------------------------");
            }


        } // End Program While

        //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        // END ENTER PROGRAM
        //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

    } //Main Class
} //Public Class
