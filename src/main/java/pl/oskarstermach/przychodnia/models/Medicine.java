package pl.oskarstermach.przychodnia.models;

import java.io.Serializable;

public class Medicine implements Serializable {
    private String name;
    private int amount;

    public Medicine() {
    }

    public Medicine(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
