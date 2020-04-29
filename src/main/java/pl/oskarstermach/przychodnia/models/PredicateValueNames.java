package pl.oskarstermach.przychodnia.models;

import java.util.Map;
import java.util.TreeMap;

public class PredicateValueNames {
    public static final String doctorFirstName = "doctor.person.firstName";
    public static final String doctorLastName = "doctor.person.lastName";
    public static final String patientFirstName = "patient.person.firstName";
    public static final String patientLastName = "patient.person.lastName";
    public static final String patientDisease = " patient.disease";
    public static final String patientAge = "patient.person.age";
    public static final String doctorAge ="doctor.person.age";
    public static final String visitDate = "visitDate";
    public static final String medicineName = "medicine.name";
    public static final Map<Integer, String> predicateValues;

    static {
        predicateValues = new TreeMap<>();
        predicateValues.put(1,doctorFirstName);
        predicateValues.put(2,doctorLastName);
        predicateValues.put(3,patientFirstName);
        predicateValues.put(4,patientLastName);
        predicateValues.put(5,patientDisease);
        predicateValues.put(6,patientAge);
        predicateValues.put(7,doctorAge);
        predicateValues.put(8,visitDate);
        predicateValues.put(9,medicineName);
    }
}
