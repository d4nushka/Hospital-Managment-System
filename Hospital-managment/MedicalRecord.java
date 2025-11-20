public class MedicalRecord {
    public int id;
    public int patientId;
    public String diagnosis;

    public MedicalRecord(int id, int patientId, String diagnosis) {
        this.id = id;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
    }

    public String toString() {
        return "Record ID: " + id + " | Patient ID: " + patientId +
                " | Diagnosis: " + diagnosis;
    }
}
