package model;

/**
* The Tenant class represents the companies that will occupy the mini-rooms. They have a name and a Nit.
* @author Geovanny Quintero Velez.
* @version 05/12/2021/A
*/
public class Tenant{

    private String name;
    private String nit;

    /**
     * The Tenant constructor will create a Tenant object. It will have a name and a Nit, both of which will be passed as parameters.
     * @param name: It is a String that will represent the name of the company.
     * @param nit: It is a String that will represent the company's Nit.
     */
    public Tenant(String name, String nit){
        this.name = name;
        this.nit = nit;
    }

    /**
     * The setName method will change the class name attribute to a String passed as a parameter.
     * @param name: It is a String that will represent the name of the company.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The getName method will return the company name.
     * @return name: It is a String that will represent the name of the company.
     */
    public String getName() {
        return name;
    }

    /**
     * The setNit method will change the class Nit attribute to a String passed as a parameter.
     * @param nit: It is a String that will represent the Nit of the company.
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * The getName method will return the company Nit.
     * @return nit: It is a String that will represent the Nit of the company.
     */
    public String getNit() {
        return nit;
    }

    /**
     * The toString method will return a message with all the attribute information of the tenant.
     * @return message: It is a String that contains the information of the attributes of the tenant.
     */
    public String toString(){
        String message = "";
        message = "The tenants name is: "+name+", the tenants nit is: "+nit+". \n ***************************************************************** \n";
        return message;
    }
    
}