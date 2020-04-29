package pl.oskarstermach.przychodnia.models;

import java.io.Serializable;

public class Doctor implements Serializable {
    private Person person;

    public Doctor(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "person=" + person +
                '}';
    }
}
