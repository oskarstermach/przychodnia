package pl.oskarstermach.przychodnia.service;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import pl.oskarstermach.przychodnia.HConfig;
import pl.oskarstermach.przychodnia.models.Receipt;

import java.net.UnknownHostException;
import java.util.Map;
import java.util.UUID;

public class ApplicationService {
    private HazelcastInstance instance;
    private DeleteService deleteService;
    private UpdateService updateService;

    public ApplicationService() throws UnknownHostException {
        this.updateService = new UpdateService();
        Config config = HConfig.getConfig();
        this.instance = Hazelcast.newHazelcastInstance(config);
        deleteService = new DeleteService();
    }

    public void addNewEntry() throws UnknownHostException {
        Map<String, Receipt> receipts = instance.getMap("receipts");
        receipts.put(UUID.randomUUID().toString(), Builder.buildReceipt());
    }

    public void deleteEntry() throws UnknownHostException {
        deleteService.deleteOptionSelector();
    }

    public void getEntries() throws UnknownHostException {
        Map<String, Receipt> receipts = instance.getMap("receipts");
        receipts.values().forEach(System.out::println);
    }

    public void updateEntry(){
        updateService.updateSelection();
    }


}
