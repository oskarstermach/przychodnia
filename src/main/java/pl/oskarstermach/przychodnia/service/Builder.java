package pl.oskarstermach.przychodnia.service;

import pl.oskarstermach.przychodnia.models.Doctor;
import pl.oskarstermach.przychodnia.models.Medicine;
import pl.oskarstermach.przychodnia.models.Patient;
import pl.oskarstermach.przychodnia.models.Person;
import pl.oskarstermach.przychodnia.models.Receipt;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Builder {
    private static final Scanner in = new Scanner(System.in);

    public static Doctor buildDoctor() {
        System.out.println("Building doctor..");
        return new Doctor(buildPerson());
    }

    public static Person buildPerson() {
        Person person = new Person();

        System.out.print("Enter first name:  ");
        person.setFirstName(in.nextLine());

        System.out.print("Enter last name:  ");
        person.setLastName(in.nextLine());

        System.out.print("Enter age:  ");

        String age = in.nextLine();

        if(age.matches("[0-9]+")){
            person.setAge(Integer.parseInt(age));
        }else{
            System.out.println("Invalid age value!");
            person.setAge(-1);
        }

        return person;
    }

    public static List<Medicine> buildMedicine() {
        boolean addNewMedicine = true;
        List<Medicine> medicines = new ArrayList<>();


        while (addNewMedicine) {
            System.out.print("Enter medicine name:  ");
            String medicineName = in.nextLine();

            System.out.print("Enter amount:  ");
            int amount = Integer.parseInt(in.nextLine());

            Medicine medicine = new Medicine(medicineName, amount);
            medicines.add(medicine);

            System.out.println("Add more? Y/N");
            if(in.nextLine().toUpperCase().equals("N")){
                addNewMedicine = false;
            }
        }

        return medicines;
    }

    public static Patient buildPatient() {
        System.out.println("Building patient..");
        Patient patient = new Patient();
        patient.setPerson(buildPerson());

        System.out.print("Enter patient disease:  ");
        String disease = in.nextLine();
        patient.setDisease(disease);

        return patient;
    }

    public static Receipt buildReceipt() {
        System.out.println("Building receipt..");
        Receipt receipt = new Receipt(buildDoctor(), buildPatient(), buildMedicine(), LocalDateTime.now());
        return receipt;
    }


}
