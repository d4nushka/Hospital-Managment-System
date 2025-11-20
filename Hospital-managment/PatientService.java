import java.util.*;

public class PatientService {

    private ArrayList<Patient> patients = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private final String FILE = "patients.txt";
    private int nextId = 1;

    public PatientService() {
        loadPatients();
    }

    private void loadPatients() {
        ArrayList<String> data = Utils.readAll(FILE);
        int maxId = 0;

        for (String line : data) {

            if (line.trim().isEmpty()) continue; // skip empty lines

            String[] p = line.split(",");

            if (p.length != 4) {
                System.out.println("Skipping invalid patient line: " + line);
                continue;
            }

            try {
                int id = Integer.parseInt(p[0]);
                String name = p[1];
                int age = Integer.parseInt(p[2]);
                String disease = p[3];

                patients.add(new Patient(id, name, age, disease));

                if (id > maxId)
                    maxId = id;

            } catch (Exception e) {
                System.out.println("Skipping invalid patient line: " + line);
            }
        }

        nextId = maxId + 1;
    }

    public void addPatient() {
        int id = nextId++;

        sc.nextLine(); // clear buffer

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        sc.nextLine(); // clear buffer
        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        Patient p = new Patient(id, name, age, disease);
        patients.add(p);

        Utils.writeToFile(FILE, id + "," + name + "," + age + "," + disease);

        System.out.println("Patient added with ID: " + id);
    }

    public void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        for (Patient p : patients)
            System.out.println(p);
    }

    public void searchPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.id == id) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("Patient not found!");
    }
}