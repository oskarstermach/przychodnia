package pl.oskarstermach.przychodnia;

import pl.oskarstermach.przychodnia.models.AppOperation;

import java.util.Scanner;


public class AppManager {

    public void controlApplicationFlow(){
        Scanner in = new Scanner(System.in);
        AppOperation appOperation = AppOperation.get(in.nextLine());
        while (true){
            switch (appOperation){
                case ADD:
                    break;
                case DELETE:
                    break;
                case UPDATE:
                    break;
                case GET:
                    break;
                case TOP_MEDICINES:
                    break;
            }
        }
    }
}
