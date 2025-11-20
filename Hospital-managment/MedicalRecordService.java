import java.util.*;

public class MedicalRecordService {

    private ArrayList<MedicalRecord> records = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private final String FILE = "records.txt";
    private int nextId = 1;

    public MedicalRecordService() {
        loadRecords();
    }

    private void loadRecords() {
        ArrayList<String> data = Utils.readAll(FILE);
        int maxId = 0;

        for (String line : data) {
            String[] r = line.split(",");
            int id = Integer.parseInt(r[0]);
            records.add(new MedicalRecord(id, Integer.parseInt(r[1]), r[2]));
            if (id > maxId) maxId = id;
        }

        nextId = maxId + 1;
    }

    public void addRecord() {
        int id = nextId++;

        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();

        System.out.print("Enter Diagnosis: ");
        String diag = sc.next();

        MedicalRecord r = new MedicalRecord(id, pid, diag);
        records.add(r);

        Utils.writeToFile(FILE, id + "," + pid + "," + diag);

        System.out.println("Medical Record added with ID: " + id);
    }

    public void viewRecords() {
        for (MedicalRecord r : records)
            System.out.println(r);
    }
}