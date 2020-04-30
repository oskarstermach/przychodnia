package pl.oskarstermach.przychodnia;

import pl.oskarstermach.przychodnia.models.AppOperation;
import pl.oskarstermach.przychodnia.service.ApplicationService;
import pl.oskarstermach.przychodnia.service.DeleteService;
import pl.oskarstermach.przychodnia.service.UpdateService;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;


public class AppManager {
    private ApplicationService applicationService;

    public AppManager(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    public void controlApplicationFlow() throws IOException {
        Scanner in = new Scanner(System.in);
        while (true) {
            showSelectionMenu();
            AppOperation appOperation = handleInput(in.nextLine());
            switch (appOperation) {
                case ADD:
                    applicationService.addNewEntry();
                    break;
                case DELETE:
                    applicationService.deleteEntry();
                    break;
                case UPDATE:
                    applicationService.updateEntry();
                    break;
                case GET:
                    applicationService.getEntries();
                    break;
                case TOP_MEDICINES:
                    applicationService.showTopRatedMedicines();
                    break;
                case INVALID:
                    System.out.println("Unrecognized operation!");
            }
        }
    }

    public AppOperation handleInput(String choice) {
        if (choice.matches("[0-9]{1}")) {
            return AppOperation.INVALID;
        } else {
            return choice.toUpperCase().matches("[ADUGT]") ?
                    AppOperation.get(choice.toUpperCase()) : AppOperation.INVALID;
        }
    }

    private void showSelectionMenu() {
        System.out.println("----------------------------------------\n[A] - New Receipt\n[D] Delete receipt\n[U] Update receipt\n[G] Get receipt\n[T] Find top medicines\n----------------------------------------");
    }
}
