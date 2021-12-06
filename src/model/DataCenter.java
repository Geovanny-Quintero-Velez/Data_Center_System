package model;

/**
 * The class DataCenter is the controller of the program, it represents a data center that is distributed in corridors that in turn have mini-halls. The number of corridors is represented by the constant DATA_CENTER_CORRIDORS and the number of mini-halls per corridor is represented by the constant MINIROOMS_PER_CORRIDOR. From this class is also decided the price that each mini-room will have from a base value and a series of discounts that the mini-rooms will have for being positioned in one place or another.
* @author Geovanny Quintero Velez.
* @version 05/12/2021/A
 */
public class DataCenter{

    public static final int DATA_CENTER_CORRIDORS = 8;
    public static final int MINIROOMS_PER_CORRIDOR = 50;
    public static final double BASE_VALUE = 100;
    public static final double WINDOW_DISCOUNT = 0.90;
    public static final double SEVENTH_CORRIDOR_DISCOUNT = 0.85;
    public static final double SECOND_SIXTH_CORRIDOR_SURCHARGE = 1.25;
    public static final double SUB_USE_FINE = 0.85;

    private MiniRoom[][] miniRooms;

    /**
     * The DataCenter builder will create the data center along with the mini-rooms in it, assigning each mini-room a rental price according to its position.
     */
    public DataCenter(){
        miniRooms = new MiniRoom[DATA_CENTER_CORRIDORS][MINIROOMS_PER_CORRIDOR];
        double rentalValue = BASE_VALUE;
        boolean window = false;
        for(int i = 0; i<DATA_CENTER_CORRIDORS; i++){
            for(int j=0; j<MINIROOMS_PER_CORRIDOR; j++){
                if(i == 0 || i == 7 || j == 0 || j == 49){
                    window = true;
                    rentalValue *= WINDOW_DISCOUNT;
                }
                if(i == 7){
                    rentalValue *= SEVENTH_CORRIDOR_DISCOUNT;
                }
                else if(i>2 && i<6){
                    rentalValue *= SECOND_SIXTH_CORRIDOR_SURCHARGE;
                }
                miniRooms[i][j] = new MiniRoom(window, rentalValue);
                window = false;
                rentalValue = BASE_VALUE;
            }
        }
    }

    /**
     * The listAvailableMinirooms method searches for available minirooms, identified by boolean. In case of being available (not being occupied by any company) the method will save in a message all the information of the minirooms and then return it.
     * @return message: It is a String that contains all the information (attributes) of all the mini-rooms that are available.
     */
    public String listAvailableMinirooms(){
        String message = "";
        for(int i=0; i<DATA_CENTER_CORRIDORS; i++){
            for(int j=0; j<MINIROOMS_PER_CORRIDOR; j++){
                if(miniRooms[i][j].getAvailable() == true){
                    message += "The miniroom of the row "+i+" and column "+j+": "+miniRooms[i][j].toString();
                }
            }
        }
        return message;
    }

    /**
     * The rentMiniroom method will occupy a mini-room for a company.
     * @param name: Is a String representing the company name.
     * @param nit: It is a String that represents the company's Nit.
     * @param rentalDate: Is a String representing the date the miniroom was rented.
     * @param serversAmount: It is an int that represents the number of servers in the rack that the company wishes to use.
     * @param cacheMemory: It is a double that represents the amount of RAM cache memory that the servers will have.
     * @param processorsAmount: It is an int that represents the number of processors that the servers have.
     * @param processorsType: It is an int whose number will represent the brand of server processors.
     * @param disksAmount: This is an int representing the number of disks the server has.
     * @param disksCapacity: It is a double that represents the capacity in Terabytes of the disks.
     * @return message: It is a String containing a message informing of the success or failure of the operation.
     */
    public String rentMiniroom(String name, String nit, String rentalDate, int serversAmount, double cacheMemory, int processorsAmount, int processorsType, int disksAmount, double disksCapacity){
        String message = "ERROR. All mini-rooms are occupied. \n";
        boolean flag = true;
        for(int i=0; i<DATA_CENTER_CORRIDORS && flag == true; i++){
            for(int j=0; j<MINIROOMS_PER_CORRIDOR && flag == true; j++){
                if(miniRooms[i][j].getAvailable() == true){
                    miniRooms[i][j].rentMiniroom(name, nit);
                    miniRooms[i][j].setRentalDate(rentalDate);
                    miniRooms[i][j].setAvailable(false);
                    miniRooms[i][j].setLightOn(true);
                    for(int z = 0; z<serversAmount; z++){
                        miniRooms[i][j].addServer(cacheMemory, processorsAmount, processorsType, disksAmount, disksCapacity);
                    }
                    flag = false;
                    message = "Mini-room successfully rented. \n";
                }
            }
        }
        return message;
    }

    /**
     * The rentMiniroom method will occupy a mini-room for an ICESI research project.
     * @param projectRegistrationId: It is a String that represents the registration number of the research project.
     * @param rentalDate: Is a String representing the date the miniroom was rented.
     * @param serversAmount: It is an int that represents the number of servers in the rack that the company wishes to use.
     * @param cacheMemory: It is a double that represents the amount of RAM cache memory that the servers will have.
     * @param processorsAmount: It is an int that represents the number of processors that the servers have.
     * @param processorsType: It is an int whose number will represent the brand of server processors.
     * @param disksAmount: This is an int representing the number of disks the server has.
     * @param disksCapacity: It is a double that represents the capacity in Terabytes of the disks.
     * @return message: It is a String containing a message informing of the success or failure of the operation.
     */
    public String rentMiniroom(String projectRegistrationId, String rentalDate, int serversAmount, double cacheMemory, int processorsAmount, int processorsType, int disksAmount, double disksCapacity){
        String message = "ERROR. All mini-rooms are occupied. \n";
        boolean flag = true;
        for(int i=0; i<DATA_CENTER_CORRIDORS && flag == true; i++){
            for(int j=0; j<MINIROOMS_PER_CORRIDOR && flag == true; j++){
                if(miniRooms[i][j].getAvailable() == true){
                    miniRooms[i][j].rentMiniroom(projectRegistrationId);
                    miniRooms[i][j].setRentalDate(rentalDate);
                    miniRooms[i][j].setAvailable(false);
                    miniRooms[i][j].setLightOn(true);
                    for(int z=0; z<serversAmount; z++){
                        miniRooms[i][j].addServer(cacheMemory, processorsAmount, processorsType, disksAmount, disksCapacity);
                    }
                    flag = false;
                    message = "Mini-room successfully rented. \n";
                }
            }
        }
        return message;
    }

    /**
     * The cancelTenantMinirooms method will vacate a company's mini-rooms by canceling their rent. 
     * @param nit: It is a String that represents the company's Nit.
     * @return message: A String containing a message with the processing capacity (total disk capacity, total RAM memory) of the mini-rooms whose rental has been cancelled. 
     */
    // public String cancelTenantMinirooms(String nit){
    //    boolean flag = true;
    //    Tenant tenant = null;
    //    String message = "";
    //    for(int i = 0; i<DATA_CENTER_CORRIDORS && flag; i++){
    //        for(int j = 0; j<MINIROOMS_PER_CORRIDOR && flag; j++){
    //            tenant = miniRooms[i][j].getTenant();
    //           if(tenant != null && nit.equals(tenant.getNit())){
    //                message += "MiniRoom in the row "+i+" and column "+j+": "+miniRooms[i][j].cancelRent();
    //                miniRooms[i][j].setLightOn(false);
    //            }
    //        }
    //    }
    //    return message;
    //}

    /**
     * The cancelTenantMinirooms method will vacate a mini-room by paying the rent for it.
     * @param row: It is an int that represents the row where the miniroom to cancel the rent is located.
     * @param column: It is an int that represents the column where the miniroom to cancel the rent is located.
     * @return message: A String containing a message with the processing capacity (total disk capacity, total RAM memory) of the mini-rooms whose rental has been cancelled.
     */
    public String cancelMiniroom(int row, int column){
        String message = "ERROR. The mini-room was not previously occupied.";
        if(miniRooms[row][column].getAvailable() == false){
            message = "MiniRoom in the row "+row+" and column "+column+": "+miniRooms[row][column].cancelRent();
            miniRooms[row][column].setLightOn(false);
        }
        return message;
    }
/**
 * The showDatacenterMap method will store in a String a message with the shape of the data center map where you can see the mini-rooms on and off. If a miniroom is on it will appear as x, and if it is off it will appear as 0.
 * @return message: It is a String with the datacenter map showing the mini-rooms on and off.
 */
    public String showDatacenterMap(){
        String finalMessage = "";
        String[] message = new String[17];
        for(int i=0; i<17; i++){
            message[i] = "";
        }
        System.out.println("********************************************************************* ");
        for(int i = 8; i<(DATA_CENTER_CORRIDORS*2)+1; i++){
            for(int j = 0; j<MINIROOMS_PER_CORRIDOR; j++){
                message[i] += "-";
            }
        }
        for(int i = 0; i<DATA_CENTER_CORRIDORS; i++){
            for(int j = 0; j<MINIROOMS_PER_CORRIDOR; j++){
                if(miniRooms[i][j].getLightOn()==false){
                    if(j == 0){
                        message[i] += "|0|";
                    }
                    else{
                        message[i] += "0|";
                    }
                }
                else{
                    if(j == 0){
                        message[i] += "|x|";
                    }
                    else{
                        message[i] += "x|";
                    }
                }
            }
        }
        finalMessage = message[8]+"\n";
        for(int i=0; i<DATA_CENTER_CORRIDORS; i++){
            finalMessage += message[i]+"\n";
            finalMessage += message[i+9]+"\n";
        }
        return finalMessage;
    }

    /**
     * The simulateMiniroomsLighting method will light up all the minirooms in the data center and display a String map of the location.
     * @return message: It is a String with the datacenter map showing the mini-rooms on and off.
     */
    public String simulateMiniroomsLighting(){
        String message = "";
        for(int i = 0; i<DATA_CENTER_CORRIDORS; i++){
            for(int j = 0; j<MINIROOMS_PER_CORRIDOR; j++){
                miniRooms[i][j].setLightOn(true);
            }
        }
        message = showDatacenterMap();
        return message;
    }

    /**
     * The simulateMiniroomsShutdown method, based on a letter passed as a parameter, will shut down certain minirooms. The letter X returns the lights of the minirooms to the way they were at the beginning.
     * @param identifyingLetter: It is a char that represents the function to be performed.
     * @return message: It is a String with the datacenter map showing the mini-rooms on and off.
     */
    public String simulateMiniroomsShutdown(char identifyingLetter){
        int i = 0;
        int j = 0;
        int count = 1;
        int storer = 1;
        String message = "";
        boolean flag = true;
        switch(identifyingLetter){
            case 'L': for(i = 0; i<DATA_CENTER_CORRIDORS; i++){
                        for(j = 0; j<MINIROOMS_PER_CORRIDOR; j++){
                            if(i == 0 || j == 0){
                                miniRooms[i][j].setLightOn(false);
                            }
                        }
                    }
                    break;
            case 'Z': miniRooms[0][0].setLightOn(false);
                    miniRooms[DATA_CENTER_CORRIDORS-1][MINIROOMS_PER_CORRIDOR-1].setLightOn(false); 
                    for(i = 1; i<DATA_CENTER_CORRIDORS-1; i++){
                        for(j = storer; j<(DATA_CENTER_CORRIDORS*count)+1 && flag == true; j++){
                            miniRooms[i][j].setLightOn(false);
                            if(j==DATA_CENTER_CORRIDORS*count){
                                count++;
                                storer = j;
                                flag = false;
                            }
                        }
                        flag = true;
                    }
                    break;
            case 'H': for(i = 0; i<DATA_CENTER_CORRIDORS; i++){
                        for(j = 0; j<MINIROOMS_PER_CORRIDOR; j++){
                            if(j%2 == 0.0){
                                miniRooms[i][j].setLightOn(false);
                            }
                        }
                    }
                    break;
            case 'O': for(i = 0; i<DATA_CENTER_CORRIDORS; i++){
                        for(j = 0; j<MINIROOMS_PER_CORRIDOR; j++){
                            if(miniRooms[i][j].getWindow()==true){
                                miniRooms[i][j].setLightOn(false);
                            }
                        }
                    }
                    break;
            case 'X': for(i = 0; i<DATA_CENTER_CORRIDORS; i++){
                        for(j = 0; j<MINIROOMS_PER_CORRIDOR; j++){
                            if(miniRooms[i][j].getAvailable() == true){
                                miniRooms[i][j].setLightOn(false);
                            }
                            else{
                                miniRooms[i][j].setLightOn(true);
                            }
                        }
                    }
                    break;
        }
        message = showDatacenterMap();
        return message;
    }

    /**
     * The simulateMiniroomsShutdown method, based on a letter passed as a parameter will perform 2 functions, shutdown a row or shutdown a column of minirooms. It will also identify the column or row from a number passed as a parameter.
     * @param identifyingLetter: It is a char that represents the function to be performed.
     * @param number: This is an int that will identify the column or row of minirooms to be turned off.
     * @return message: It is a String with the datacenter map showing the mini-rooms on and off.
     */
    public String TurnOffMiniroomsOfALine(char identifyingLetter, int number){
        String message = "";
        if(identifyingLetter == 'M'){
            for(int i = 0; i<DATA_CENTER_CORRIDORS; i++){
                for(int j = 0; j<MINIROOMS_PER_CORRIDOR; j++){
                    if(j == number-1){
                        miniRooms[i][j].setLightOn(false);
                    }
                }
            }
        }
        else{
            for(int i = 0; i<DATA_CENTER_CORRIDORS; i++){
                for(int j = 0; j<MINIROOMS_PER_CORRIDOR; j++){
                    if(i == number-1){
                        miniRooms[i][j].setLightOn(false);
                    }
                }
            }
        }
        message = showDatacenterMap();
        return message;
    }
    
}