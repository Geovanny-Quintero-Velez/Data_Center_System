package model;

/**
* The Server class will represent one of the servers contained in the rack. 
* @author Geovanny Quintero Velez.
* @version 05/12/2021/A
*/
public class Server{

    private double cacheMemory;
    private int processorsAmount;
    private ProcessorBrand processorsType;
    private int disksAmount;
    private double disksCapacity;

    /**
     * The Server constructor will create a server object with the attributes passed by parameter.
     * @param cacheMemory: It is a double that represents the RAM memory in cache that the server will have.
     * @param processorsAmount: It is an int that represents the number of processors that the server will have.
     * @param processorsType: An int representing the type of server processor.
     * @param disksAmount: It is an int that represents the number of disks that the server has.
     * @param disksCapacity: It is a double that represents the capacity of the disks contained in the server.
     */
    public Server(double cacheMemory, int processorsAmount, int processorsType, int disksAmount, double disksCapacity){
        this.cacheMemory = cacheMemory;
        this.processorsAmount = processorsAmount;
        this.disksAmount = disksAmount;
        this.disksCapacity = disksCapacity;
        switch(processorsType){
            case 1: this.processorsType = ProcessorBrand.INTEL;
                    break;
            case 2: this.processorsType = ProcessorBrand.AMD;
                    break;
        }
    }

    /**
     * The setCacheMemory method will change the cacheMemory attribute from a double passed as a parameter.
     * @param cacheMemory: It is a double that represents the RAM memory in cache that the server will have.
     */
    public void setCacheMemory(double cacheMemory) {
        this.cacheMemory = cacheMemory;
    }

    /**
     * The getCacheMemory method will return the cacheMemory attribute.
     * @return cacheMemory: It is a double that represents the RAM memory in cache that the server will have.
     */
    public double getCacheMemory() {
        return cacheMemory;
    }

    /**
     * The setProcessorsAmount method will change the processorsAmount attribute from a int passed as a parameter.
     * @param processorsAmount: It is an int that represents the number of processors that the server will have.
     */
    public void setProcessorsAmount(int processorsAmount) {
        this.processorsAmount = processorsAmount;
    }

    /**
     * The getProcessorsAmount method will return the processorsAmount attribute.
     * @return processorsAmount: It is an int that represents the number of processors that the server will have.
     */
    public int getProcessorsAmount() {
        return processorsAmount;
    }

    /**
     * The setProcessorsType method will change the processorsType attribute from a int passed as a parameter.
     * @param processorsType: An int representing the type of server processor.
     */
    public void setProcessorsType(int processorsType) {
        switch(processorsType){
            case 1: this.processorsType = ProcessorBrand.INTEL;
                    break;
            case 2: this.processorsType = ProcessorBrand.AMD;
                    break;
        }
    }

    /**
     * The getProcessorsType method will return the processorsType attribute.
     * @return processorsType: It is an ProcessorBrand String that represents the processors type that the server will have.
     */
    public ProcessorBrand getProcessorsType(){
        return processorsType;
    }

    /**
     * The setDisksAmount method will change the disksAmount attribute from a int passed as a parameter.
     * @param disksAmount: It is an int that represents the number of disks that the server has.
     */
    public void setDisksAmount(int disksAmount) {
        this.disksAmount = disksAmount;
    }

    /**
     * The getDisksAmount method will return the disksAmount attribute.
     * @return disksAmount: It is an int that represents the number of disks that the server has.
     */
    public int getDisksAmount() {
        return disksAmount;
    }

    /**
     * The setDisksCapacity method will change the disksCapacity attribute from a double passed as a parameter.
     * @param disksCapacity: It is a double that represents the capacity of the disks contained in the server.
     */
    public void setDisksCapacity(double disksCapacity) {
        this.disksCapacity = disksCapacity;
    }

    /**
     * The getDisksAmount method will return the disksCapacity attribute.
     * @return disksCapacity: It is a double that represents the capacity of the disks contained in the server.
     */
    public double getDisksCapacity() {
        return disksCapacity;
    }

}