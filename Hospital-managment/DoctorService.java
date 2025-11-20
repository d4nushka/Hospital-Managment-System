import java.util.*;

public class DoctorService {

    private ArrayList<Doctor> doctors = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private final String FILE = "doctors.txt";
    private int nextId = 1;

    public DoctorService() {
        loadDoctors();
    }

    private void loadDoctors() {
        ArrayList<String> data = Utils.readAll(FILE);
        int maxId = 0;

        for (String line : data) {
            String[] d = line.split(",");
            int id = Integer.parseInt(d[0]);
            doctors.add(new Doctor(id, d[1], d[2]));
            if (id > maxId) maxId = id;
        }

        nextId = maxId + 1;
    }

    public void addDoctor() {
        int id = nextId++;

        System.out.print("Enter Name: ");
        sc.nextLine();
        String name = sc.nextLine();
        

        System.out.print("Enter Specialization: ");
        String spec = sc.nextLine();

        Doctor d = new Doctor(id, name, spec);
        doctors.add(d);

        Utils.writeToFile(FILE, id + "," + name + "," + spec);

        System.out.println("Doctor added with ID: " + id);
    }

    public void viewDoctors() {
        for (Doctor d : doctors)
            System.out.println(d);
    }
}