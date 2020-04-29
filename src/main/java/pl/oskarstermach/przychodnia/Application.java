package pl.oskarstermach.przychodnia;

import pl.oskarstermach.przychodnia.service.ApplicationService;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        ApplicationService applicationService = new ApplicationService();
        AppManager appManager = new AppManager(applicationService);
        appManager.controlApplicationFlow();
    }
}
