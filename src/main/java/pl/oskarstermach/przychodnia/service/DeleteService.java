package pl.oskarstermach.przychodnia.service;

import com.whalin.MemCached.MemCachedClient;
import pl.oskarstermach.przychodnia.models.Receipt;

import java.util.Scanner;

public class DeleteService extends AbstractService{

    public DeleteService(Scanner in, MemCachedClient memCachedClient) {
        super(in, memCachedClient);
    }

    public void deleteOptionSelector() {
        findAndDelete(getKey());
    }

    private String getKey() {
        System.out.println("Insert search key");
        return in.nextLine();
    }

    public void findAndDelete(String key) {
        final Object o = memCachedClient.get(key);
        if(o!= null){
            Receipt receipt = (Receipt) o;
            System.out.println("Deleteing: " + receipt.toString());
            memCachedClient.delete(key);
        }else{
            System.out.println("No value");
        }
    }

}
