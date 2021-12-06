package ui;
import model.*;
import java.util.Scanner;

/**
 * The class DataCenterSystem will be the user interface of the system, through this the object corresponding to the data center will be instantiated with the attributes that the user enters, also a menu with the following functions will be shown:
* <ul> 
*	<li> List available mini-rooms </li>
	<li> Rent a mini-room </li>
	<li> Cancel a mini-room rental </li>
	<li> Show the data center map </li>
	<li> Simulate all mini-rooms lighting </li>
	<li> Simulate mini-rooms shutdown </li>
	<li> Exit to the system </li>
* </ul>
* And depending on the option or function that the user chooses to do the class will call the method that will perform it.
* @author Geovanny Quintero Velez.
* @version 05/12/2021/A
 */

public class DataCenterSystem{

    public static Scanner lector = new Scanner(System.in);
    public static DataCenter dataCenter = new DataCenter();
/**
 * The method main will call the methods that will perform each process. One process or another will be performed according to the variable option.
 * @param args
 */
    public static void main(String[] args){
        int option = 0;
        boolean continuar = true;
        while(continuar == true){
            option = menu();
            switch(option){
                case 1: listAvailableMinirooms();
                        break;
                case 2: rentMiniroom();
                        break;
                case 3: cancelRent();
                        break;
                case 4: showDatacenterMap();
                        break;
                case 5: simulateMiniroomsLighting();
                        break;
                case 6: continuar = false;
                        break;
            }
        }
    }

    /**
     * The menu method will show the user all the functions that the system performs, and will ask for a number that represents the function to be performed.
     * @return option: It is an integer that represents the function to be performed by the program.
     */

    public static int menu(){
        int option = 0;
	System.out.println("*************************************************************************");
	System.out.println("*  1. List available mini-rooms                                         *");
	System.out.println("*  2. Rent a mini-room                                                  *");
	System.out.println("*  3. Cancel a mini-room rental                                         *");
	System.out.println("*  4. Show the data center map                                          *");
        System.out.println("*  5. Simulate all mini-rooms lighting and Simulate mini-rooms shutdown *");
        System.out.println("*  6. Exit                                                              *");
        System.out.println("*************************************************************************");
	option = lector.nextInt();
	lector.nextLine();
	return option;
    }

    /**
     * The listAvailableMinirooms method will display a list message with the information of all available mini-rooms.
     */
    public static void listAvailableMinirooms(){
        System.out.println(dataCenter.listAvailableMinirooms());
    }

    /**
     * The rentMiniroom method will query the attributes of the enterprise objects that will be created inside the Miniroom and the Server objects that will be created inside the rack inside the Miniroom.
     */
    public static void rentMiniroom(){
        String message = "";
        int serversAmount = 0;
        double cacheMemory = 0;
        int processorsAmount = 0;
        int processorsType = 0;
        int disksAmount = 0;
        double disksCapacity = 0;
        String rentalDate = "";
        System.out.println("Is it for an ICESI research project? \n 1. Yes \n 2. No");
        switch(lector.nextInt()){
            case 1: System.out.println("What is the project registration number?");
                    String projectRegistrationId = lector.nextLine();
                    lector.nextLine();
                    System.out.println("What is the date you are renting the room?");
                    rentalDate = lector.nextLine();
                    lector.nextLine();
                    System.out.println("How many servers will your rack host?");
                    serversAmount = lector.nextInt();
                    lector.nextLine();
                    System.out.println("What is the RAM memory capacity of the servers that the miniroom rack will have?");
                    cacheMemory = lector.nextDouble();
                    lector.nextLine();
                    System.out.println("How many processors does the server have?");
                    processorsAmount = lector.nextInt();
                    lector.nextLine();
                    System.out.println("What is the brand of the server processors? \n 1. INTEL \n 2. AMD");
                    processorsType = lector.nextInt();
                    lector.nextLine();
                    System.out.println("How many disks does the server have?");
                    disksAmount = lector.nextInt();
                    lector.nextLine();
                    System.out.println("What is the capacity in teras of the server's disks?");
                    disksCapacity = lector.nextInt();
                    lector.nextLine();
                    message = dataCenter.rentMiniroom(projectRegistrationId, rentalDate, serversAmount, cacheMemory, processorsAmount, processorsType, disksAmount, disksCapacity);
                    break;
            case 2: System.out.println("What is the company name?");
                    String name = lector.nextLine();
                    lector.nextLine();
                    System.out.println("What is the company Nit?");
                    String nit = lector.nextLine();
                    lector.nextLine();
                    System.out.println("What is the date you are renting the room?");
                    rentalDate = lector.nextLine();
                    lector.nextLine();
                    System.out.println("How many servers will your rack host?");
                    serversAmount = lector.nextInt();
                    lector.nextLine();
                    System.out.println("What is the RAM memory capacity of the servers that the miniroom rack will have?");
                    cacheMemory = lector.nextDouble();
                    lector.nextLine();
                    System.out.println("How many processors does the server have?");
                    processorsAmount = lector.nextInt();
                    lector.nextLine();
                    System.out.println("What is the brand of the server processors? \n 1. INTEL \n 2. AMD");
                    processorsType = lector.nextInt();
                    lector.nextLine();
                    System.out.println("How many disks does the server have?");
                    disksAmount = lector.nextInt();
                    lector.nextLine();
                    System.out.println("What is the capacity in teras of the server's disks?");
                    disksCapacity = lector.nextInt();
                    lector.nextLine();
                    message = dataCenter.rentMiniroom(name, nit, rentalDate, serversAmount, cacheMemory, processorsAmount, processorsType, disksAmount, disksCapacity);
                    break;
        }
        System.out.println(message);
    }

    /**
     * The cancelRent method will ask if you want to cancel the rent of all the minirooms of a company or of a particular miniroom, and will ask for the company nit or the miniroom position as the case may be.
     */
    public static void cancelRent(){
        String message = "";
        System.out.println("What is the row number for the mini-room?");
        int row = lector.nextInt();
        lector.nextLine();
        System.out.println("What is the column number for the mini-room?");
        int column = lector.nextInt();
        lector.nextLine();
        message = dataCenter.cancelMiniroom(row, column);
        System.out.println(message);
    }

    /**
     * The showDatacenterMap method will display a String in the form of a datacenter map showing the mini-rooms with the lights on and the mini-rooms with the lights off.
     */
    public static void showDatacenterMap(){
        System.out.println(dataCenter.showDatacenterMap());
        System.out.println("*********************************************************************");
    }

    /**
     * The simulateMiniroomsLighting method will show a String of the datacenter map, where all the lights will be on. Then it will ask which minirooms to turn off according to a letter, until you want to end the simulation by returning the lights to the way they were at the beginning.
     */
    public static void simulateMiniroomsLighting(){
        boolean continu = true;
        System.out.println(dataCenter.simulateMiniroomsLighting());
        while(continu == true){
                System.out.println("*********************************************************************");
                continu = simulateMiniroomsShutdown();
        }

    }

    /**
     * The simulateMiniroomsShutdown method will ask the user for a letter which will turn off or turn on the lights of certain minirooms, there is a letter that serves to end the process or simulation. This method works only if the simulateMiniroomsLighting method was activated first.
     * @return continue: It is a boolean that represents if it is desired to continue turning off the lights of certain minirooms, to hang them all. Once it is false it means that the user wants all the lights to go back to the way they were at the beginning. This boolean was intended to be an indicator for a cycle of the simulateMiniroomsLighting method.
     */
    public static boolean simulateMiniroomsShutdown(){
        boolean continu = true;
        char identifyingLetter = '0';
        System.out.println("* Type the letter corresponding to the function you want to implement.");
        System.out.println("* Letter L: turns off the first mini-rooms of all corridors, together with the mini-rooms of the first corridor.");
        System.out.println("* Letter Z: turns off the mini-rooms of the first and last corridor, together with the mini-rooms of the reverse diagonal.");
        System.out.println("* Letter H: turns off the mini-rooms located in the odd numbered corridors.");
        System.out.println("* Letter O: turns off the mini-rooms located in the windows.");
        System.out.println("* Letter M: Turns off all the mini-rooms in a column.");
        System.out.println("* Letter P: Turns off all the mini-rooms in a corridor.");
        System.out.println("* Letter A: Turn all lights back on.");
        System.out.println("* Letra X: End Simulation.");
        System.out.println("*********************************************************************");
        identifyingLetter = (lector.nextLine().toUpperCase()).charAt(0);
        if(identifyingLetter == 'M' || identifyingLetter == 'P'){
                System.out.println("Enter the number of the column or row you wish to turn off.");
                System.out.println(dataCenter.TurnOffMiniroomsOfALine(identifyingLetter, lector.nextInt()));
                lector.nextLine();
        }
        else if(identifyingLetter == 'X'){
                System.out.println(dataCenter.simulateMiniroomsShutdown(identifyingLetter));
                continu = false;
        }
        else if(identifyingLetter == 'A'){
                System.out.println(dataCenter.simulateMiniroomsLighting());
        }
        else{
                System.out.println(dataCenter.simulateMiniroomsShutdown(identifyingLetter));
        }
        return continu;
    }


}