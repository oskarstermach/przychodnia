package pl.oskarstermach.przychodnia.service;

import com.whalin.MemCached.MemCachedClient;
import pl.oskarstermach.przychodnia.models.Receipt;

import java.util.Scanner;
import java.util.UUID;

public class ApplicationService extends AbstractService {
    private DeleteService deleteService;
    private UpdateService updateService;
    private MedicineService medicineService;

    public ApplicationService(DeleteService deleteService,
                              UpdateService updateService,
                              MedicineService medicineService,
                              Scanner in,
                              MemCachedClient memCachedClient) {
        super(in, memCachedClient);
        this.deleteService = deleteService;
        this.updateService = updateService;
        this.medicineService = medicineService;
    }

    public void addNewEntry() {
        String uuid = UUID.randomUUID().toString();
        System.out.println("Adding new entry with key: " + uuid);
        memCachedClient.add(uuid, Builder.buildReceipt());
    }

    public void deleteEntry() {
        deleteService.deleteOptionSelector();
    }

    public void getEntries() {
        System.out.println("Insert identifier");
        String uuid = in.nextLine();
        final Object o = memCachedClient.get(uuid);

        if(o != null){
            Receipt receipt = (Receipt) o;
            System.out.println(receipt.toString());
        }else{
            System.out.println("Couldnt find receipt in the system");
        }

    }

    public void updateEntry(){
        updateService.updateSelection();
    }

    public void showTopRatedMedicines(){
        medicineService.selectOption();
    }

}
