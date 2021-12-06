package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
* The Rack class represents a rack that contains servers and is inside each mini-room.
* @author Geovanny Quintero Velez.
* @version 05/12/2021/A
*/
public class Rack{

    private ArrayList<Server> servers = new ArrayList<Server>();

    /**
     * The Rack constructor will create a Rack object. 
     */
    public Rack(){
        
    }

    /**
     * The addServer method will add a server object to the arrayList servers.
     * @param cacheMemory: It is a double that represents the RAM memory in cache that the server will have.
     * @param processorsAmount: It is an int that represents the number of processors that the server will have.
     * @param processorsType: An int representing the type of server processor.
     * @param disksAmount: It is an int that represents the number of disks that the server has.
     * @param disksCapacity: It is a double that represents the capacity of the disks contained in the server.
     */
    public void addServer(double cacheMemory, int processorsAmount, int processorsType, int disksAmount, double disksCapacity){
        Server servidor = new Server(cacheMemory, processorsAmount, processorsType, disksAmount, disksCapacity);
        servers.add(servidor);
    }

    /**
     * The cancelRent method will enter in a String the information of the processing capacity (total disk capacity and total RAM memory) of the servers in the rack.
     * @return message: Is a String containing the processing capacity information (total disk capacity and total RAM memory) of the servers in the rack.
     */
    public String cancelRent(){
        String message = "";
        Server server = null;
        int counter = 1;
        Iterator<Server> iteratorOfServers = servers.iterator();
        while(iteratorOfServers.hasNext()){
            server = iteratorOfServers.next();
            message += "The server #"+counter+" has a total capacity per disk of: "+server.getDisksCapacity()+" and has a total RAM memory of: "+server.getCacheMemory()+". \n ******************************************************************* \n";
            counter++;
        }
        return message;
    }

}