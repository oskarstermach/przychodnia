package pl.oskarstermach.przychodnia.service;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import pl.oskarstermach.przychodnia.HConfig;
import pl.oskarstermach.przychodnia.models.Receipt;

import java.net.UnknownHostException;
import java.util.Map;
import java.util.UUID;

public class ApplicationService extends AbstractService{
    private DeleteService deleteService;
    private UpdateService updateService;
    private MedicineService medicineService;

    public ApplicationService(HazelcastInstance instance, DeleteService deleteService, UpdateService updateService, MedicineService medicineService) {
        super(instance);
        this.deleteService = deleteService;
        this.updateService = updateService;
        this.medicineService = medicineService;
    }

    public void addNewEntry(){
        Map<String, Receipt> receipts = instance.getMap("receipts");
        receipts.put(UUID.randomUUID().toString(), Builder.buildReceipt());
    }

    public void deleteEntry(){
        deleteService.deleteOptionSelector();
    }

    public void getEntries() {
        Map<String, Receipt> receipts = instance.getMap("receipts");

        if(receipts.values().size() > 0) {
            receipts.values().forEach(System.out::println);
        }else{
            System.out.println("No receipts in the system!");
        }
    }

    public void updateEntry(){
        updateService.updateSelection();
    }

    public void showTopRatedMedicines(){
        medicineService.selectOption();
    }

}
