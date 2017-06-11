package coffeepotserver;

/*
 * Parser Class
 * 
 * This class parses through all values selected by the client for use with 
 * other classes. It deals with additions, the request header type and the
 * pot number.
 * 
 * David Norton - 10005864
 * Hiten Kotecha - 11004776
 */
public class Parser {

    //=========================| Global Variables |=============================
    int errorNo;
    int potNo;
    Order order;

    //==========================================================================
    //
    //=======================| Parse Request |=========================
    public Protocol.Method parseHeader(String request, int noOfPots) {

        //-----------------------|  Get pot number |---------------------------
        
        if (request.matches(".*\\/pot-\\d.*")) {

            potNo = Integer.parseInt(request.replaceAll("[\\D]", "").substring(0, 1));

            if ((potNo < 0) && (potNo > noOfPots)) {
                errorNo = 404;
                return Protocol.Method.ERROR;
            }

        } else { // No request
            potNo = 0;
        }
        //----------------------------------------------------------------------
        //
        //----------------------|  Get request type |---------------------------
        if (request.contains("BREW") || request.contains("POST")) {
            order = new Order();
            return Protocol.Method.BREW;
        } else if (request.contains("GET")) {
            return Protocol.Method.GET;
        } else if (request.contains("PROPFIND")) {
            return Protocol.Method.PROPFIND;
        } else if (request.contains("WHEN")) {
            return Protocol.Method.WHEN;
        } else {
            errorNo = 406;
            return Protocol.Method.ERROR;
        }
        //----------------------------------------------------------------------
    }

    //==========================================================================
    //
    //==========================| Add on additions |============================
    public void addToOrder(String request) {

        //--------------------|  Parse milk additions |-------------------------
        if (request.contains("Cream")) {
            order.wantsMilk(true);
            order.setMilkName("Cream");
        } else if (request.contains("Half and half")) {
            order.wantsMilk(true);
            order.setMilkName("Half and half");
        } else if (request.contains("Whole-milk")) {
            order.wantsMilk(true);
            order.setMilkName("Whole-milk");
        }
        //----------------------------------------------------------------------
        //
        //--------------------|  Parse syrup additions |------------------------
        if (request.contains("Vanilla")) {
            order.wantsSyrup(true);
            order.setSyrupName("Vanilla");
        } else if (request.contains("Almond")) {
            order.wantsSyrup(true);
            order.setSyrupName("Almond");
        } else if (request.contains("Raspberry")) {
            order.wantsSyrup(true);
            order.setSyrupName("Raspberry");
        }
        //----------------------------------------------------------------------
        //
        //--------------------|  Parse alcohol additions |----------------------
        if (request.contains("Whiskey")) {
            order.wantsSyrup(true);
            order.setAlcoholName("Whiskey");
        } else if (request.contains("Rum")) {
            order.wantsSyrup(true);
            order.setAlcoholName("Rum");
        } else if (request.contains("Kahlua")) {
            order.wantsSyrup(true);
            order.setAlcoholName("Kahlua");
        } else if (request.contains("Aquavit")) {
            order.wantsSyrup(true);
            order.setAlcoholName("Aquavit");
        }
        //----------------------------------------------------------------------
    }

    //==========================================================================
    //
    //=============================| Getters |==================================
    public Order getOrder() {

        return order;
    }

    public int getPotNo() {

        return potNo;
    }

    public int getErrorNo() {

        return errorNo;
    }
    //==========================================================================
}
