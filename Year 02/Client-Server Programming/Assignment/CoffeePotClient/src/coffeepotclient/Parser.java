package coffeepotclient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/*
 * Setup Class
 * 
 * This class parses through all values selected by the client for use with 
 * other classes. It deals with additions, the request header type and the
 * pot number.
 * 
 * David Norton - 10005864
 * Hiten Kotecha - 11004776
 */

public class Parser {

    //====================| Check Valid Coffee Request |========================
    static private boolean validateProtocol(String request) {

        boolean valid = false;

        if (request.startsWith("coffee://")) {
            valid = true;
        }

        return valid;
    }

    //=========================================================================
    //
    //=============| Replace 'coffee://' to match Java URL class |==============
    static private String replaceProtocol(String request) {

        request = request.replaceFirst("coffee://", "http://");

        return request;
    }

    //==========================================================================
    //
    //==================| Return host specified in request |====================
    static public String getHost(String request) {

        String host = "";

        if (validateProtocol(request)) {

            //-----------------------| Get host URL |---------------------------
            try {
                URL url = new URL(replaceProtocol(request));
                host = url.getHost();
            } catch (MalformedURLException e) {
                System.out.println("Invalid URL");
            }
            //------------------------------------------------------------------

        } // If

        return host;
    }

    //==========================================================================
    //
    //===================| Return pot specified in request |====================
    static private String getPotDesignator(String request) {

        String pot = " ";

        if (validateProtocol(request)) {

            //-------------| If URL is correct get pot's path |-----------------
            try {
                URL url = new URL(replaceProtocol(request));

                if (!((url.getPath()).equals("/"))) {

                    if (!((url.getPath()).equals(""))) {
                        pot = " " + url.getPath() + " ";
                    }
                }
            } catch (MalformedURLException e) {
                System.out.println("Invalid URL");
            }
            //------------------------------------------------------------------

        }

        return pot;
    }

    //==========================================================================
    //
    //=====================| Return additions specified |=======================
    static private String getAdditions(String request) {

        String additions = "";

        if (validateProtocol(request)) {

            //--------------------| Get addition's URL |------------------------
            try {
                URL url = new URL(replaceProtocol(request));
                if (url.getQuery() != null) {
                    additions = url.getQuery();
                }
            } catch (MalformedURLException e) {
                System.out.println("Invalid URL");
            }
            //------------------------------------------------------------------

        } // If

        return additions;
    }

    //==========================================================================
    //
    //====================| Format additions for header |=======================
    static private String processAdditions(String additionslist) {

        String additions = "";
        String additionsListArray[];


        if (additionslist.equals("*")) {
            additions = "\naccept-additions:*";
        } else if (!(additionslist.equals(""))) {

            //---------| Format additions in order to be processed |------------
            additionslist = additionslist.replaceAll("=", ";");
            additionsListArray = additionslist.split("&");
            additions = "\naccept-additions:";
            //------------------------------------------------------------------

            //-----------| Build additions string using the array |-------------
            for (String thisAddition : additionsListArray) {

                String thisAdditions = (thisAddition.split(";")[1]);
                additions += thisAdditions + ";";
            }
            //------------------------------------------------------------------
        }

        additions += "\r\n\r\n";
        return additions;
    }

    //==========================================================================
    //
    //===============| Create BREW message to send to server |==================
    static private String createBrewMessage(String request) {

        String head = "";

        if (validateProtocol(request)) {
            head = "BREW" + getPotDesignator(request) + "HTCPCP/1.0 \r"
                    + processAdditions(getAdditions(request));
        }

        return head;
    }

    //==========================================================================
    //
    //================| Create GET message to send to server |==================
    static private String createGetMessage(String request) {

        String head = "";

        if (validateProtocol(request)) {
            head = "GET" + getPotDesignator(request) + "HTCPCP/1.0 \r\n\r\n";
        }

        return head;
    }

    //==========================================================================
    //
    //===============| Create WHEN message to send to server |==================
    static private String createWhenMessage(String request) {
        
        String head = "";
        
        if (validateProtocol(request)) {
            head = "WHEN" + getPotDesignator(request) + "HTCPCP/1.0 \r\n\r\n";
        }
        
        return head;
    }

    //==========================================================================
    //
    //=============| Create PROPFIND message to send to server |================
    static private String createPropfindMessage(String request) {
       
        String head = "";
        
        if (validateProtocol(request)) {
            head = "PROPFIND" + getPotDesignator(request)
                    + "HTCPCP/1.0 \r\n\r\n";
        }
        
        return head;
    }

    //==========================================================================
    //
    //===============| Create PARSE message to send to server |=================
    static public String parseRequest(String request, StreamSocket streamServer) {
       
        if (!(getHost(request).equals("")) || (getHost(request).equals(streamServer.getCurrentHost()))) {
            try {
                streamServer.updateHost(getHost(request));
            } catch (UnknownHostException e) {
                
                System.out.print("Host not found\n");
                
                try {
                    streamServer.kill();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                
                return "";
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //-------------------| Create Appropiate Message |----------------------
        if (getAdditions(request).equals("")) {
            return createGetMessage(request);
        } else if (getAdditions(request).equalsIgnoreCase("when")) {
            return createWhenMessage(request);
        } else if (getAdditions(request).equalsIgnoreCase("propfind")) {
            return createPropfindMessage(request);
        } else {
            return createBrewMessage(request);
        }
        //----------------------------------------------------------------------
    }

    //==========================================================================
    //
    //===================| Format the Response message. |=======================
    static public String parseResponse(String response) {
       
        return response.replaceAll("\r\n", "").replaceAll("HTCPCP/1.0 ", "")
                .replaceAll("accept-additions:", "").replaceAll(";", ", ");
    }
    //==========================================================================
}