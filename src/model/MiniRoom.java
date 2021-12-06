package model;

import javax.lang.model.util.ElementScanner6;

/**
* The MiniRoom class represents the rooms inside the datacenter. It can have a window, has a rental value and lights, which are turned off if the place is not rented. It can be occupied by a company, and when it is rented the rental date is saved. It has inside a rack whose servers can be used by the tenant company.
* @author Geovanny Quintero Velez.
* @version 05/12/2021/A
*/
public class MiniRoom{

    private boolean window;
    private double rentalValue;
    private boolean lightOn;
    private String rentalDate;
    private boolean available;
    private Tenant tenant;
    private Rack rack;

    /**
     * The MiniRoom constructor will create a MiniRoom object with the attributes passed by parameter. Initially the lights are off, there is no rent date and there is no tenant company, so the miniroom is available and the rack inside it is available.
     * @param window: Is a boolean representing whether or not the miniroom has a window.
     * @param rentalValue: It is a double that represents the rental value of the miniroom.
     */
    public MiniRoom(boolean window, double rentalValue){
        this.window = window;
        this.rentalValue = rentalValue;
        lightOn = false;
        rentalDate = "0";
        available = true;
        tenant = null;
        rack = null;
    }

    /**
     * The getTenant method returns the Tenant object from the miniroom.
     * @return tenant: Is a Tenant object representing the tenant company of the miniroom (If not present, it is null).
     */
    public Tenant getTenant(){
        return tenant;
    }

    /**
     * The cancelRent method calls the cancel rent method of the rack and what it returns is stored inside a String that will return. It empties the rack (converts it to null) and the boolean available converts it to true.
     * @return message: It is a String with the information of the processing capacity of each server in the rack.
     */
    public String cancelRent(){
        String message = rack.cancelRent();
        rack = null;
        available = true;
        tenant = null;
        return message;
    }

    /**
     * The addServer method adds a server to the rack.
     * @param cacheMemory: It is a double that represents the RAM memory in cache that the server will have.
     * @param processorsAmount: It is an int that represents the number of processors that the server will have.
     * @param processorsType: An int representing the type of server processor.
     * @param disksAmount: It is an int that represents the number of disks that the server has.
     * @param disksCapacity: It is a double that represents the capacity of the disks contained in the server.
     */
    public void addServer(double cacheMemory, int processorsAmount, int processorsType, int disksAmount, double disksCapacity){
        rack.addServer(cacheMemory, processorsAmount, processorsType, disksAmount, disksCapacity);
    }

    /**
     * The rentMiniroom method occupies the miniroom by setting the available attribute false, turning on the lights and creating a company object.
     * @param name: Is a String representing the company name
     * @param nit: It is a String that represents the company's Nit.
     */
    public void rentMiniroom(String name, String nit){
        tenant = new Tenant(name, nit);
        rack = new Rack();
    }

    /**
     * The rentMiniroom method occupies the miniroom by setting the available attribute false, turning on the lights and creating a ICESI_PI (ICESI project investigation) object.
     * @param projectRegistrationId: A String representing the registration number of the research project. 
     */
    public void rentMiniroom(String projectRegistrationId){
        tenant = new Icesi_PI(projectRegistrationId);
        rack = new Rack();
    }

    /**
     * The setWindow method will change the window boolean from a boolean passed as a parameter.
     * @param window: A boolean representing whether the miniroom has a window or not.
     */
    public void setWindow(boolean window) {
        this.window = window;
    }

    /**
     * The getWindow method returns the object's window boolean.
     * @return window: It is a boolean that represents whether the object has a window or not.
     */
    public boolean getWindow() {
        return window;
    }

    /**
     * The setRentalValue method will change the rental value double from a double passed as a parameter.
     * @param rentalValue: A double that represents the rental value of the miniroom.
     */
    public void setRentalValue(double rentalValue) {
        this.rentalValue = rentalValue;
    }

    /**
     * The getRentalValue method returns the object's rentalValue double.
     * @return rentalValue: It is a double that represents the miniroom rental value.
     */
    public double getRentalValue() {
        return rentalValue;
    }

    /**
     * The setLightOn method will change the lights boolean from a boolean passed as a parameter.
     * @param lightOn: A boolean representing whether the miniroom has the lights on or off.
     */
    public void setLightOn(boolean lightOn) {
        this.lightOn = lightOn;
    }

    /**
     * The getLightOn method returns the object's window boolean.
     * @return lightOn: It is a boolean that represents whether the object has a window or not.
     */
    public boolean getLightOn() {
        return lightOn;
    }

    /**
     * The setRentalDate method will change the rental date String from a String passed as a parameter.
     * @param rentalDate: A String representing the date the miniroom was rented.
     */
    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    /**
     * The getRentalDate method returns the object's rentalDate String.
     * @return rentalDate: A String representing the date the miniroom was rented.
     */
    public String getRentalDate() {
        return rentalDate;
    }

    /**
     * The setAvailable method will change the available boolean from a boolean passed as a parameter.
     * @param available: It is a boolean that represents whether the object is available or not.
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * The getAvailbale method returns the object's lightOn boolean.
     * @return lightOn: It is a boolean that represents whether the object is available or not.
     */
    public boolean getAvailable() {
        return available;
    }

    /**
     * The toString method will return a message with all the attribute information of the miniroom.
     * @return message: It is a String that contains the information of the attributes of the miniroom.
     */
    public String toString(){
        String message = "";
        if(window == true)
            message = "The mini-room have a window, ";
        else
            message = "The mini-room haven't a window, ";
        message += "the rental value is: "+rentalValue+", ";
        if(lightOn == true)
            message += "the mini-room has lights on, ";
        else
            message += "the mini-room hasn't lights on, ";
        if(available == true)
            message += "the mini-room is available, the rental date is: "+rentalDate+". \n ***************************************************************** \n";
        else
            message += "the mini-room isn't available. \n ***************************************************************** \n";
        return message;
    }
}