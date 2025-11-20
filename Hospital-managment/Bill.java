public class Bill {
    public int id;
    public int patientId;
    public double amount;

    public Bill(int id, int patientId, double amount) {
        this.id = id;
        this.patientId = patientId;
        this.amount = amount;
    }

    public String toString() {
        return "Bill ID: " + id + " | Patient ID: " + patientId +
                " | Amount: Rs." + amount;
    }
}
