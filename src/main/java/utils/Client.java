package utils;

import utils.Service.ServiceType;

public class Client {
    //this is the object that recieves things from the services
    public void recieve(Object input)
    {
        Service service;
        if (Object.class.equals(Service.class)) service = (Service) input;
        else return;
        if (service.type() == ServiceType.INT_SERVICE) System.out.println("Intservice: " + service.intOutput);
        else if (service.type() == ServiceType.STRING_SERVICE) {System.out.println("Stringservice: " + service.stringOutput);}
    }
}
