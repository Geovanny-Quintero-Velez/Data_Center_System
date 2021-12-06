package model;

/**
* The Tenant class represents a Icesi's project investigation, that will occupy the mini-rooms. They name is ICESI and the Nit is 890.316.745-5. Also will have a project investigation registration number.
* @author Geovanny Quintero Velez.
* @version 05/12/2021/A
*/
public class Icesi_PI extends Tenant{

    public static final String NAME = "ICESI";
    public static final String NIT = "890.316.745-5";
    private String projectRegistrationId;

    /**
     * The ICESI_PI constructor will create a ICESI_PI object. It have a name ICESI, a Nit 890.316.745-5 and a project investigation registration number to be passed by parameter.
     * @param projectRegistrationId: It is a String that will represent the project investigation registration number of the project investigation.
     */
    public Icesi_PI(String projectRegistrationId){
        super(NAME, NIT);
        this.projectRegistrationId = projectRegistrationId;
    }

    /**
     * The setProjectRegistrationId method will change the class projectRegistrationId attribute to a String passed as a parameter.
     * @param projectRegistrationId: It is a String that will represent the project investigation registration number of the project investigation.
     */
    public void setProjectRegistrationId(String projectRegistrationId) {
        this.projectRegistrationId = projectRegistrationId;
    }

    /**
     * The getProjectRegistrationId method will return the project investigation registration number.
     * @return projectRegistrationId: It is a String that will represent the project investigation registration number of the project investigation.
     */
    public String getProjectRegistrationId() {
        return projectRegistrationId;
    }

    /**
     * The toString method will return a message with all the attribute information of the ICESI_PI.
     * @return message: It is a String that contains the information of the attributes of the ICESI_PI.
     */
    public String toString(){
        String message = "";
        message = "The tenants name is: "+NAME+", the tenats nit is: "+super.getNit()+", the project registration number is: "+projectRegistrationId+". \n *******************************************************************";
        return message;
    }
}