package utils;

import utils.Service.ServiceType;

public class Client {
    //this is the object that recieves things from the services
    public void receiveInt(int input)
    {
        System.out.println("Integer output: " + input);
    }
    public void receiveString(String string)
    {
        System.out.println("String output: " + string);
    }
}
