package utils;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Service {
    public enum ServiceType {
        INT_SERVICE,
        STRING_SERVICE
    }
    private ServiceType type;
    public Service(ServiceType serviceType)
    {
        type = serviceType;
    }
    public int generateIntOutput()
    {
        Random random = new Random();
        return random.nextInt();
    }
    public String generateStringOutput()
    {
        int length = 10;  
        int leftLimit = 97;     // 'a'
        int rightLimit = 122;   // 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++)
        {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
    public ServiceType type(){return type;}
}
