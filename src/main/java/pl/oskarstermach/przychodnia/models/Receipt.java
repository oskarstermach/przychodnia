package pl.oskarstermach.przychodnia.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Receipt implements Serializable {
    private Doctor doctor;
    private Patient patient;
    private List<Medicine> medicineList;
    private LocalDateTime visitDate;

    public Receipt() {
    }

    public Receipt(Doctor doctor, Patient patient, List<Medicine> medicineList, LocalDateTime visitDate) {
        this.doctor = doctor;
        this.patient = patient;
        this.medicineList = medicineList;
        this.visitDate = visitDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDateTime visitDate) {
        this.visitDate = visitDate;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "doctor=" + doctor +
                ", patient=" + patient +
                ", medicineList=" + medicineList +
                ", visitDate=" + visitDate +
                '}';
    }
}
