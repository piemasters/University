package OFI;

public class Customer {

    private int customerID;
    private String cutomerName;
    private String customerEmail;
    private String cardNumber;
    private String cardIssueDate;
    private String cardExpireyDate;

    public Customer(int customerID, String cutomerName, String customerEmail, String cardNumber, String cardIssueDate, String cardExpireyDate) {
        this.customerID = customerID;
        this.cutomerName = cutomerName;
        this.customerEmail = customerEmail;
        this.cardNumber = cardNumber;
        this.cardIssueDate = cardIssueDate;
        this.cardExpireyDate = cardExpireyDate;
    }

    //-----------------------------------------------------------------------------------------
    //-----------------------------------| Getters & Setters |---------------------------------
    //-----------------------------------------------------------------------------------------
    
    // userID Getter/Setters -------------
    public int getcustomerID() {
        return customerID;
    }

    public void setcustomerID(int customerID) {
        this.customerID = customerID;
    }

    // cutomerName Getter/Setters -------------
    public String getcutomerName() {
        return cutomerName;
    }

    public void setcutomerName(String cutomerName) {
        this.cutomerName = cutomerName;
    }

    // customerEmail Getter/Setters -------------
    public String getcustomerEmail() {
        return customerEmail;
    }

    public void setcustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    // roomTypeID Getter/Setters -------------
    public String getcardNumber() {
        return cardNumber;
    }

    public void setcardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    // cardIssueDate Getter/Setters -------------
    public String getcardIssueDate() {
        return cardIssueDate;
    }

    public void setcardIssueDate(String cardIssueDate) {
        this.cardIssueDate = cardIssueDate;
    }

    // cardExpireyDate Getter/Setters -------------
    public String getcardExpireyDate() {
        return cardExpireyDate;
    }

    public void setcardExpireyDate(String cardExpireyDate) {
        this.cardExpireyDate = cardExpireyDate;
    }
    
    //-----------------------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------
    //--------------| Add customer to customerList if does not already exist |-----------------
    //-----------------------------------------------------------------------------------------
    
    public static int MakeCustomer(Customer[] customerList, String name, String email) {

        boolean customerExist = false;
        int cCount = 0;

        // check to see if customer already exists in customerList
        while (customerExist == false && cCount < customerList.length) {

            if (customerList[cCount] != null) {

                if (customerList[cCount].getcutomerName().equals(name)
                        && customerList[cCount].getcustomerEmail().equals(email)) {

                    customerExist = true;

                } else {
                    cCount++;
                }
            } else {
                cCount++;
            }
        }

        //if customer doesn't exist, add customer to next free slot in customerList
        if (customerExist == false) {

            boolean customerMade = false;
            cCount = 0;

            while (customerMade == false && cCount < customerList.length) {

                if (customerList[cCount] == null) {

                    customerMade = true;
                    customerList[cCount] = new Customer(cCount + 1, name, email,
                            "0", "0", "0"); //temp data 

                } else {
                    cCount++;
                }
            }
        }
        return cCount;
    }

    //-----------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------
    //-------------------------| Update customers payment details |----------------------------
    //-----------------------------------------------------------------------------------------

    public static void UpdateCustomer(Customer[] customerList, int cCount, String name,
            String email, String cardNumber, String cardIssue, String cardExpirey) {

        customerList[cCount] = new Customer(cCount + 1, name, email, cardNumber, cardIssue, cardExpirey);

    }

    //----------------------------------------------------------------------------------------- 
    
    //-----------------------------------------------------------------------------------------
    //--------------------------------------| toString |---------------------------------------
    //-----------------------------------------------------------------------------------------
    
    public String toString() {
        return "Customer ID: " + customerID + " | Name: " + cutomerName + " | Email: "
                + customerEmail + " | Card Number: " + cardNumber
                + " | Issue Date: " + cardIssueDate + " | Expirey Date: " + cardExpireyDate;
    }
    
    //-----------------------------------------------------------------------------------------
}
