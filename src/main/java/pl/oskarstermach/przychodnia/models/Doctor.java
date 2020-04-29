package pl.oskarstermach.przychodnia.models;

public class Doctor {
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
}
