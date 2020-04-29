package pl.oskarstermach.przychodnia.models;

import java.io.Serializable;

public class Patient implements Serializable {
    private Person person;
    private String disease;

    public Patient() {
    }

    public Patient(Person person, String disease) {
        this.person = person;
        this.disease = disease;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "person=" + person +
                ", disease='" + disease + '\'' +
                '}';
    }
}
