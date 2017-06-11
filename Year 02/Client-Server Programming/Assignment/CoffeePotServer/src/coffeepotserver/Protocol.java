package coffeepotserver;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/*
 * Protocol Class
 * 
 * This is the main class of the Coffee Pot Server. 
 * 
 * David Norton - 10005864
 * Hiten Kotecha - 11004776
 */
public class Protocol extends Thread {

    //=========================| Global Variables |=============================
    public enum Method {

        IDLE, ERROR, GET, BREW, PROPFIND, WHEN, END
    }
    String OK = "HTCPCP/1.0 200 OK\r\n\r\n";
    String OK_PROPFIND = "HTCPCP/1.0 200 OK\r\n";
    String FINISHED_BREWING = "HTCPCP/1.0 113 Finished Brewing\r\n\r\n";
    String NOT_FOUND = "HTCPCP/1.0 404 Not Found\r\n\r\n";
    String NOT_ACCEPTABLE = "HTCPCP/1.0 406 Not Acceptable\r\n\r\n";
    String POT_BUSY = "HTCPCP/1.0 510 Pot busy\r\n\r\n";
    String STILL_BREWING = "HTCPCP/1.0 105 Still Brewing\r\n\r\n";
    String STILL_POURING = "HTCPCP/1.0 122 Still Pouring\r\n\r\n";
    String OVERFLOWED = "HTCPCP/1.0 515 Pot Overflowed\r\n\r\n";
    String POT_COLD = "HTCPCP/1.0 419 Pot Cold\r\n\r\n";
    String FINISHED_POURING = "HTCPCP/1.0 115 Finished Pouring\r\n\r\n";
    String NOT_POURING = "HTCPCP/1.0 421 Not Pouring\r\n\r\n";
    StreamSocket client;
    Receiver clientReceiver;
    ArrayList<CoffeePot> pots;
    Method method;
    Parser parser;
    Order order;
    String request;
    int index;
    boolean clientsPot[], debug;

    //==========================================================================
    //
    //===========================| Constructor |================================
    public Protocol(Socket acceptedSocket, ArrayList<CoffeePot> pots, boolean debug) {

        try {

            this.pots = pots;
            this.debug = debug;

            client = new StreamSocket(acceptedSocket);
            clientReceiver = new Receiver(client);
            parser = new Parser();
            method = Method.IDLE;

            //--------------| Make all client's pots false |-------------------
            clientsPot = new boolean[this.pots.size()];
            for (int i = 0; i < this.pots.size(); i++) {
                clientsPot[i] = false;
            }
            //------------------------------------------------------------------

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //==========================================================================
    //
    //============================| Run State |=================================
    @Override
    public void run() {

        clientReceiver.start();

        while (client.isOpen()) {

            switch (method) {

                //========================| Error  |============================

                case ERROR: {

                    //-------------------| Send 404 Error |---------------------
                    if (parser.getErrorNo() == 404) {

                        // Send 404 Not Found
                        client.sendString(NOT_FOUND);

                        // Debug message
                        if (debug == true) {
                            System.out.print("Sent to: " + client.displayDetail() + "\n" + NOT_FOUND);
                        }
                    } // If
                    //----------------------------------------------------------
                    //
                    //-------------------| Send 406 Error |---------------------
                    else if (parser.getErrorNo() == 406) {

                        // Send 406 Not Acceptable
                        client.sendString(NOT_ACCEPTABLE);

                        // Debug message
                        if (debug == true) {
                            System.out.print("Sent to: " + client.displayDetail() + "\n" + NOT_ACCEPTABLE);
                        }
                    } // If
                    //----------------------------------------------------------

                    clientReceiver.clear();
                    method = Method.IDLE;
                    break;
                }

                //==============================================================
                //
                //=========================| Brew |=============================

                case BREW: {

                    //----------------| If Idle Process Order|------------------
                    if (pots.get(index).getPotState() == CoffeePot.State.IDLE) {

                        //-------------------| Add order |----------------------
                        parser.addToOrder(request);
                        order = parser.getOrder();
                        order = pots.get(index).takeOrder(order);
                        //------------------------------------------------------
                        //
                        //----| Check additions, set to brewing or cancel |-----
                        if ((order.hasMilk == order.wantsMilk)
                                && (order.hasSyrup == order.wantsSyrup)
                                && (order.hasAlcohol == order.wantsAlcohol)) {

                            pots.get(index).setPotState(CoffeePot.State.BREWING);
                            clientsPot[index] = true;

                        } else {
                            pots.get(index).cancelOrder();
                            method = Method.PROPFIND;
                            break;
                        }
                        //------------------------------------------------------
                    }//
                    //----------------------------------------------------------
                    //
                    //----------------| Else Send 510 Pot Busy |----------------
                    else {

                        // Send 510 Pot Busy
                        client.sendString(POT_BUSY);

                        //-----------| Display status on debug mode |-----------
                        if (debug == true) {// DEBUG MESSAGE
                            System.out.print("Sent to: " + client.displayDetail() + "\n" + POT_BUSY);
                        }
                        //------------------------------------------------------
                    }

                    clientReceiver.clear();
                    method = Method.IDLE;
                    break;
                }

                //==============================================================
                //
                //=========================| Get |==============================

                case GET: {

                    // ----------------| If coffeepot is ready |----------------
                    if (pots.get(index).getPotState() == CoffeePot.State.READY) {

                        //Send 200 OK message
                        clientsPot[index] = false;
                        client.sendString(OK);

                        //---------| Display status on debug mode |-------------
                        if (debug == true) {// DEBUG MESSAGE
                            System.out.print("Sent to: " + client.displayDetail() + "\n" + OK);
                        }
                        //------------------------------------------------------

                        pots.get(index).setPotState(CoffeePot.State.IDLE);
                        method = Method.END;
                        break;

                    }//
                    //----------------------------------------------------------
                    //
                    // ---------------| If coffeepot is brewing |---------------
                    else if (pots.get(index).getPotState() == CoffeePot.State.BREWING) {

                        // Send 105 Still Brewing message
                        client.sendString(STILL_BREWING);

                        //---------| Display status on debug mode |-------------    
                        if (debug == true) {// DEBUG MESSAGE
                            System.out.print("Sent to: " + client.displayDetail() + "\n" + STILL_BREWING);
                        }
                        //------------------------------------------------------
                    } //
                    //----------------------------------------------------------
                    //
                    // ---------------| If coffeepot is pouring |---------------
                    else if (pots.get(index).getPotState() == CoffeePot.State.POURING) {

                        // Send 122 Still Pouring
                        client.sendString(STILL_POURING);

                        //---------| Display status on debug mode |-------------
                        if (debug == true) {
                            System.out.print("Sent to: " + client.displayDetail() + "\n" + STILL_POURING);
                        }
                        //------------------------------------------------------

                    } //
                    //----------------------------------------------------------
                    //
                    // -------------| If coffeepot has overflowed |-------------
                    else if (pots.get(index).getPotState() == CoffeePot.State.OVERFLOWED) {

                        // Send 515 Pot Overflowed
                        client.sendString(OVERFLOWED);

                        //---------| Display status on debug mode |-------------
                        if (debug == true) {
                            System.out.print("Sent to: " + client.displayDetail() + "\n" + OVERFLOWED);
                        }
                        //------------------------------------------------------
                    } //
                    //----------------------------------------------------------
                    //
                    // -------------| If coffeepot has overflowed |-------------
                    else if (pots.get(index).getPotState() == CoffeePot.State.IDLE) {

                        // Send 200 OK
                        client.sendString(OK);

                        //---------| Display status on debug mode |-------------
                        if (debug == true) {// DEBUG MESSAGE
                            System.out.print("Sent to: " + client.displayDetail() + "\n" + OK);
                        }
                        //------------------------------------------------------                      
                    } //
                    //----------------------------------------------------------
                    //
                    // ----------------| If coffeepot is cold |-----------------
                    else if (pots.get(index).getPotState() == CoffeePot.State.COLD) {

                        //---------------| Send 419 Pot Cold |------------------

                        // If this is clients pot then reset pot
                        if (clientsPot[index] == true) {
                            clientsPot[index] = false;
                            client.sendString(POT_COLD);

                            //---------| Display status on debug mode |---------
                            if (debug == true) {
                                System.out.print("Sent to: " + client.displayDetail() + "\n" + POT_COLD);
                            }
                            //--------------------------------------------------

                            pots.get(index).setPotState(CoffeePot.State.IDLE);
                            method = Method.END;
                            break;
                        } // Else display status
                        else {
                            client.sendString(POT_COLD);

                            //---------| Display status on debug mode |---------
                            if (debug == true) {
                                System.out.print("Sent to: " + client.displayDetail() + "\n" + POT_COLD);
                            }
                            //--------------------------------------------------
                        }
                    }//
                    //----------------------------------------------------------
                    //
                    // ----------------| If coffeepot is OK |-----------------
                    else {

                        // Send 200 OK
                        client.sendString(OK);

                        //-----------| Display status on debug mode |-----------
                        if (debug == true) {
                            System.out.print("Sent to: " + client.displayDetail() + "\n" + OK);
                        }
                        //------------------------------------------------------
                    }

                    clientReceiver.clear();
                    method = Method.IDLE;
                    break;
                }

                //==============================================================
                //
                //=======================| Propfind  |==========================

                case PROPFIND: {

                    // Send 200 OK
                    String message = OK_PROPFIND + "accept-additions:"
                            + pots.get(index).additionsToString() + "\r\n\r\n";
                    client.sendString(message);

                    //-------------| Display status on debug mode |-------------
                    if (debug == true) {
                        System.out.print("Sent to: " + client.displayDetail() + "\n" + message);
                    }
                    //----------------------------------------------------------

                    clientReceiver.clear();
                    method = Method.IDLE;
                    break;
                }

                //==============================================================
                //
                //========================| When |==============================    

                case WHEN: {

                    // ----------------| If coffeepot is pouring |--------------
                    if (pots.get(index).getPotState() == CoffeePot.State.POURING) {

                        // Send 115 Finished Pouring
                        client.sendString(FINISHED_POURING);

                        //-----------| Display status on debug mode |-----------
                        if (debug == true) {
                            System.out.print("Sent to: " + client.displayDetail() + "\n" + FINISHED_POURING);
                        }
                        //------------------------------------------------------

                        pots.get(index).setPotState(CoffeePot.State.READY);

                    } //
                    //----------------------------------------------------------
                    //
                    // --------------| If coffeepot has overflowed |------------
                    else if (pots.get(index).getPotState() == CoffeePot.State.OVERFLOWED) {

                        //------------| Send 515 Pot Overflowed |---------------

                        // If this is clients pot then reset pot
                        if (clientsPot[index] == true) {

                            clientsPot[index] = false;
                            client.sendString(OVERFLOWED);

                            //---------| Display status on debug mode |---------
                            if (debug == true) {
                                System.out.print("Sent to: " + client.displayDetail() + "\n" + OVERFLOWED);
                            }
                            //--------------------------------------------------

                            pots.get(index).setPotState(CoffeePot.State.IDLE);
                            method = Method.END;
                            break;

                        } // Else display status
                        else {

                            client.sendString(OVERFLOWED);

                            //---------| Display status on debug mode |---------
                            if (debug == true) {
                                System.out.print("Sent to: " + client.displayDetail() + "\n" + OVERFLOWED);
                            }
                            //--------------------------------------------------
                        }

                    } //
                    //----------------------------------------------------------
                    //
                    // --------------| If coffeepot isn't pouring |-------------                   
                    else {

                        // Send 421 Not Pouring
                        client.sendString(NOT_POURING);

                        //-----------| Display status on debug mode |-----------
                        if (debug == true) {// DEBUG MESSAGE
                            System.out.print("Sent to: " + client.displayDetail() + "\n" + NOT_POURING);
                        }
                        //------------------------------------------------------
                    }

                    clientReceiver.clear();
                    method = Method.IDLE;
                    break;
                }

                //==============================================================
                //
                //==========================| End |=============================

                case END: {

                    try {
                        client.kill();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                //==============================================================
                //
                //=======================| Default |============================

                default: {

                    // Wait
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // ---------------| Check for client input |----------------
                    if (!"".equals(request = clientReceiver.getInput())) {

                        //-----------| Display status on debug mode |-----------
                        if (debug == true) {
                            System.out.print("Received from: " + client.displayDetail() + "\n" + request);
                        }
                        //------------------------------------------------------

                        //Get method
                        method = parser.parseHeader(request, pots.size());
                        // Get pot number
                        index = parser.getPotNo();
                        
                        // If input invalid send client error
                        if (method == Method.ERROR) {
                            break;
                        }                       
                    }
                    
                    clientReceiver.clear();
                    
                    // ---------| Notify client that pot has brewed |-----------
                    for (int i = 0; i < pots.size(); i++) {
                        
                        if ((pots.get(i).getPotState() == CoffeePot.State.NOT_BREWING) 
                                && (clientsPot[i] == true)) {
                            
                            // Send 113 Finished Brewing
                            client.sendString(FINISHED_BREWING);
                            
                             //---------| Display status on debug mode |--------
                            if (debug == true) {// DEBUG MESSAGE
                                System.out.print("Sent to: " + client.displayDetail() + "\n" + FINISHED_BREWING);
                            }
                            //--------------------------------------------------
                            
                            pots.get(i).setPotState(CoffeePot.State.POURING);
                        }
                    }
                    break;
                }
                //==============================================================    
            } // Switch
        } // While
    } // Run
    //==========================================================================
}