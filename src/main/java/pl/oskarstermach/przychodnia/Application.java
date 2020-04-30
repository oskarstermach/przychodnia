package pl.oskarstermach.przychodnia;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import pl.oskarstermach.przychodnia.models.Medicine;
import pl.oskarstermach.przychodnia.service.ApplicationService;
import pl.oskarstermach.przychodnia.service.DeleteService;
import pl.oskarstermach.przychodnia.service.MedicineService;
import pl.oskarstermach.przychodnia.service.UpdateService;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Config config = HConfig.getConfig();
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);

        DeleteService deleteService = new DeleteService(hazelcastInstance);
        MedicineService medicineService = new MedicineService(hazelcastInstance);
        UpdateService updateService = new UpdateService(hazelcastInstance);

        ApplicationService applicationService = new ApplicationService(hazelcastInstance,deleteService,updateService,medicineService);
        AppManager appManager = new AppManager(applicationService);
        appManager.controlApplicationFlow();
    }
}
