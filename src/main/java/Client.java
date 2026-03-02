public class Client {
    //this is the object that recieves things from the services
    public void recieve(Object input)
    {
        Service service;
        if (Object.class.equals(Service.class)) service = (Service) input;
        else return;
    }
}
