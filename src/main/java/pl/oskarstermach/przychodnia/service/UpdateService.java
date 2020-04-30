package pl.oskarstermach.przychodnia.service;

import com.whalin.MemCached.MemCachedClient;
import pl.oskarstermach.przychodnia.models.Receipt;

import java.util.Scanner;

public class UpdateService extends AbstractService{


    public UpdateService(Scanner in, MemCachedClient memCachedClient) {
        super(in, memCachedClient);
    }

    public void updateSelection() {
        findAndUpdate(getKey());
    }

    private String getKey() {
        System.out.println("Insert search key ");
        return in.nextLine();
    }

    public void findAndUpdate(String key) {
        System.out.println("Insert identifier");
        final Object o = memCachedClient.get(key);

        if(o != null){
            Receipt receipt = (Receipt) o;
            System.out.println(receipt.toString());
            Receipt updateReceipt = Builder.buildReceipt();
            memCachedClient.delete(key);
            memCachedClient.add(key,updateReceipt);
            System.out.println("Update receipt: " + updateReceipt.toString());
        }else{
            System.out.println("Couldnt find receipt in the system");
        }

    }
}
