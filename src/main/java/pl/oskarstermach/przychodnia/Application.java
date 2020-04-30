package pl.oskarstermach.przychodnia;


import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;
import pl.oskarstermach.przychodnia.service.ApplicationService;
import pl.oskarstermach.przychodnia.service.DeleteService;
import pl.oskarstermach.przychodnia.service.MedicineService;
import pl.oskarstermach.przychodnia.service.UpdateService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {

        String[] servers = {"127.0.0.1:11211"};
        SockIOPool pool = SockIOPool.getInstance("Przychodnia");
        pool.setServers(servers);
        pool.setFailover(true);
        pool.setInitConn(10);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        pool.setMaintSleep(30);
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setAliveCheck(true);
        pool.initialize();
        MemCachedClient memCachedClient = new MemCachedClient("Przychodnia");

        Scanner in = new Scanner(System.in);

        DeleteService deleteService = new DeleteService(in, memCachedClient);
        MedicineService medicineService = new MedicineService(in,memCachedClient);
        UpdateService updateService = new UpdateService(in,memCachedClient);

        ApplicationService applicationService = new ApplicationService(deleteService,updateService,medicineService,in,memCachedClient);
        AppManager appManager = new AppManager(applicationService);
        appManager.controlApplicationFlow();
    }
}
